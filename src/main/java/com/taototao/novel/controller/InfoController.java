package com.taototao.novel.controller;

import com.taototao.novel.bean.ArticleSearchBean;
import com.taototao.novel.bean.ChapterSearchBean;
import com.taototao.novel.bean.ReviewSearchBean;
import com.taototao.novel.cache.CacheManager;
import com.taototao.novel.constant.ICommon;
import com.taototao.novel.constant.TaoToTaoConfig;
import com.taototao.novel.constant.TaoToTaoConstants;
import com.taototao.novel.controller.base.AbstractPublicBaseController;
import com.taototao.novel.entity.Article;
import com.taototao.novel.entity.Chapter;
import com.taototao.novel.entity.Review;
import com.taototao.novel.service.ArticleService;
import com.taototao.novel.service.ChapterService;
import com.taototao.novel.service.ReviewService;
import com.taototao.novel.utils.Pagination;
import com.taototao.novel.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-25 14:27
 **/
@Controller
@RequestMapping(AbstractPublicBaseController.INFO_NAMES)
public class InfoController extends AbstractPublicBaseController {


    @Autowired
    private ArticleService articleService;
    @Autowired
    private ChapterService chapterService;
    @Autowired
    private ReviewService reviewService;

    @RequestMapping("/{subdir}/{articleno}/{pinyin}")
    public String index(@PathVariable int subdir, @PathVariable int articleno,@PathVariable  String pinyin, ModelMap map) {

        logger.debug("load data --------------->sybdir={},articleno={},pinyin=", subdir, articleno, pinyin);

        Article article = null;

        if (TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.ENABLE_PINYINURL, false)) {
            article = CacheManager.getObject(CacheManager.CacheKeyPrefix.CACHE_KEY_ARTICEL_PREFIX, pinyin);
            if (!Utils.isDefined(article)) {
                ArticleSearchBean searchBean = new ArticleSearchBean();
                searchBean.setPinyin(pinyin.toUpperCase());
                List<Article> articleList = articleService.find(searchBean);
                if (Utils.isDefined(articleList)) {
                    article = articleList.get(0);
                    CacheManager.putObject(CacheManager.CacheKeyPrefix.CACHE_KEY_ARTICEL_PREFIX, pinyin, article);
                }
            }
        } else {
            article = CacheManager.getObject(CacheManager.CacheKeyPrefix.CACHE_KEY_ARTICEL_PREFIX, articleno);

            if (!Utils.isDefined(article)) {
                article = articleService.getByNo(articleno);
                CacheManager.putObject(CacheManager.CacheKeyPrefix.CACHE_KEY_ARTICEL_PREFIX, articleno, article);
            }

        }


        if (article != null) {
//            if (!YiDuConstants.yiduConf.getBoolean(YiDuConfig.ENABLE_CHAPTER_INDEX_PAGE, false)
//                    || (YiDuConstants.singleBookFlag.get() != null && YiDuConstants.singleBookFlag.get())) {
            // 获取章节信息
            ChapterSearchBean searchBean = new ChapterSearchBean();
            searchBean.setArticleno(article.getArticleno());
            List<Chapter> chapterList = CacheManager.getObject(CacheManager.CacheKeyPrefix.CACHE_KEY_CHAPTER_LIST_PREFIX,
                    searchBean);
            if (!Utils.isDefined(chapterList)) {
                chapterList = chapterService.findWithPinyin(searchBean);
                if (Utils.isDefined(chapterList)) {
                    CacheManager.putObject(CacheManager.CacheKeyPrefix.CACHE_KEY_CHAPTER_LIST_PREFIX, searchBean,
                            chapterList);
                }
            }

            map.put("chapterList",chapterList);


            // 获取评论信息
            ReviewSearchBean reviewSearchBean = new ReviewSearchBean();
            reviewSearchBean.setArticleno(article.getArticleno());
            // 获取评论件数
            int reviewCount = reviewService.getCount(reviewSearchBean);
            map.put("reviewCount",reviewCount);
            // 获取评论
            Pagination pagination = new Pagination(TaoToTaoConstants.taoToTaoConf.getInt(TaoToTaoConfig.REVIEW_NUM, 5), 1);
            pagination.setSortColumn("postdate");
            pagination.setSortOrder("DESC");
            reviewSearchBean.setPagination(pagination);
            List<Review> reviewList = reviewService.find(reviewSearchBean);
            map.put("reviewList",reviewList);
            // 更新统计信息
            articleService.updateVisitStatistic(article.getArticleno());

//            }
        }

        map.put("pageType",TaoToTaoConstants.Pagetype.PAGE_ARTICLE_INFO);
        map.put("article",article);
        map.put("enableChapterIndexPage",TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.ENABLE_CHAPTER_INDEX_PAGE, false));
        loadBlock(map);

        return ICommon.themes + "/pc/info";
    }



}
