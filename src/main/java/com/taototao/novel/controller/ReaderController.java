package com.taototao.novel.controller;

import com.taototao.novel.cache.CacheManager;
import com.taototao.novel.constant.ICommon;
import com.taototao.novel.constant.TaoToTaoConfig;
import com.taototao.novel.constant.TaoToTaoConstants;
import com.taototao.novel.controller.base.AbstractPublicBaseController;
import com.taototao.novel.dto.ChapterDTO;
import com.taototao.novel.entity.Article;
import com.taototao.novel.entity.Chapter;
import com.taototao.novel.service.ArticleService;
import com.taototao.novel.service.ChapterService;
import com.taototao.novel.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-26 10:40
 **/
@Controller
@RequestMapping(AbstractPublicBaseController.READER_NAMES)
public class ReaderController extends AbstractPublicBaseController {

    public final static String CHAPTER_DETAIL = "detail";

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping(CHAPTER_DETAIL + "/{subdir}/{articleno}/{chapterno}")
    public String chapterDetail(@PathVariable int subdir, @PathVariable int articleno, @PathVariable int chapterno,Integer toChapterno, ModelMap map) {

        logger.debug("chapter detail ---------->subdir={},articleno={},chapterno={}，toChapterno={}", subdir, articleno, chapterno, toChapterno);

        ChapterDTO chapter=null;
        if (toChapterno!=null && toChapterno != 0 && toChapterno.intValue() > chapterno) {
            List<ChapterDTO> fullReadChapterList = new ArrayList<ChapterDTO>();
            List<Chapter> segChapterList = chapterService.getChapterInSegement(articleno, chapterno, toChapterno);
            if (segChapterList == null || segChapterList.isEmpty()) {

            } else {
                for (Chapter tchapter : segChapterList) {
                    ChapterDTO chapterDto = new ChapterDTO();
                    BeanUtils.copyProperties(tchapter, chapterDto);
                    if (chapterDto != null && chapterDto.getChapterno() != 0) {
                        chapterDto.setContent(Utils.getContext(chapterDto, true,
                                TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.ENABLE_PSEUDO, false)));
                    }

                    fullReadChapterList.add(chapterDto);
                }
                 chapter = new ChapterDTO();
                BeanUtils.copyProperties(segChapterList.get(0), chapter);
                chapter.setChaptername(chapter.getChaptername() + " - "
                        + segChapterList.get(segChapterList.size() - 1).getChaptername());


            }

        }else{
            chapter = CacheManager.getObject(CacheManager.CacheKeyPrefix.CACHE_KEY_CHAPTER_PREFIX, chapterno);

            if (chapter == null || chapter.getChapterno() == 0) {
                Chapter tchapter = chapterService.getByNo(chapterno);
                Chapter nextchapter = chapterService.getNextChapter(tchapter.getArticleno(), chapterno, true);
                Chapter prechapter = chapterService.getNextChapter(tchapter.getArticleno(), chapterno, false);

                chapter = new ChapterDTO();
                BeanUtils.copyProperties(tchapter, chapter);
                if (nextchapter != null) {
                    chapter.setNextChapterno(nextchapter.getChapterno());
                }
                if (prechapter != null) {
                    chapter.setPreChapterno(prechapter.getChapterno());
                }
                CacheManager.putObject(CacheManager.CacheKeyPrefix.CACHE_KEY_CHAPTER_PREFIX, chapterno, chapter);

            }else{

            }

//            chapter.setContent(Utils.getContext(chapter, true,
//                    TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.ENABLE_PSEUDO, false)));

        }

        // 更新统计信息
        if (chapter != null && chapter.getArticleno() != 0) {
         Article article = CacheManager.getObject(CacheManager.CacheKeyPrefix.CACHE_KEY_ARTICEL_PREFIX,
                    chapter.getArticleno());
            if (article == null || article.getArticleno() == 0) {
                article = articleService.getByNo(chapter.getArticleno());
                CacheManager.putObject(CacheManager.CacheKeyPrefix.CACHE_KEY_ARTICEL_PREFIX, articleno, article);
            }
            if (article == null || article.getArticleno() == 0) {

            }
            articleService.updateVisitStatistic(chapter.getArticleno());
            // 设置拼音信息
            chapter.setPinyin(article.getPinyin());
            map.put("article",article);
        }

        map.put("chapter",chapter);
        map.put("pageType",TaoToTaoConstants.Pagetype.PAGE_READER);
        loadBlock(map);
        return ICommon.themes + "/pc/reader";

    }


}
