package com.taototao.novel.controller.admin;

import com.taototao.novel.bean.ChapterSearchBean;
import com.taototao.novel.controller.base.AbstractAdminBaseController;
import com.taototao.novel.entity.Article;
import com.taototao.novel.entity.Chapter;
import com.taototao.novel.service.ArticleService;
import com.taototao.novel.service.ChapterService;
import com.taototao.novel.utils.Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-20 16:42
 **/
@Controller
@RequestMapping(AbstractAdminBaseController.NAMESPACE)
public class ChapterController extends AbstractAdminBaseController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ChapterService chapterService;

    @RequestMapping("chapter/list")
    public String list(int articleno, ModelMap map) {

        Article article = articleService.getByNo(articleno);
        ChapterSearchBean searchBean = new ChapterSearchBean();
        searchBean.setPagination(null);
        List<Chapter> chapterList = chapterService.find(searchBean);
        map.put("article", article);
        map.put("chapterList", chapterList);
        return "admin/chapterList";
    }

    @RequestMapping("chapter/addPage")
    public String addPage(int articleno, ModelMap map) {
        Article article = articleService.getByNo(articleno);
        map.put("article", article);
        return "admin/chapterEdit";
    }

    @RequestMapping("chapter/save")
    public String save(Chapter chapter, String content) {
        logger.debug("章节信息----------->{}", chapter.toString());

        chapter.setChaptertype((short) 0);
        chapter.setPostdate(new Date());
        chapter.setSize(StringUtils.length(content));
        chapter.setModifytime(new Date());
        chapter.setModifyuserno(0);
        chapter.setPublishtime(new Date());
        chapter.setIspublish(true);
        chapter.setLastchecktime(new Date());
        chapterService.save(chapter);
        try {
            Utils.saveContext(chapter.getArticleno(), chapter.getChapterno(), content);
        } catch (Exception e) {
            logger.debug("save content error -------------->", e);
        }
        logger.debug("-------------------->更新最新章节信息");
        // 最新章节等信息
        Article article = new Article();
        article.setArticleno(chapter.getArticleno());
        article.setLastchapterno(chapter.getChapterno());
        article.setLastchapter(chapter.getChaptername());
        article.setLastupdate(new Date());
        article.setChapters(chapterService.getChapterCount(chapter.getArticleno()));
        article.setSize(chapterService.getChapterCountSize(chapter.getArticleno()));
        article.setModifytime(new Date());
        article.setModifyuserno(0);
        articleService.updateNewChapter(article);
        logger.debug(" -----------------------------> save chapter end ");
        return "redirect:/admin/chapter/list?articleno=" + chapter.getArticleno();
    }


    @RequestMapping("chapter/editPage/{chapterno}")
    public String editPage(@PathVariable int chapterno, ModelMap map) {
        Chapter chapter = chapterService.getByNo(chapterno);
        map.put("content", Utils.getContext(chapter, false));
        map.put("chapter", chapter);
        return "admin/chapterEdit";
    }

    @RequestMapping("chapter/edit")
    public String edit(Chapter chapter, String content) {
        logger.debug("update start ------------->{}", chapter.toString());

        Chapter chapter1 = chapterService.getByNo(chapter.getChapterno());
        if (chapter1 == null) {
            return "redirect:/admin/chapter/list?articleno=" + chapter.getArticleno();
        }
        chapter1.setSize(StringUtils.length(content));
        chapter1.setPostdate(new Date());
        chapter1.setModifytime(new Date());
        chapter1.setModifyuserno(0);
        chapter1.setChaptername(chapter.getChaptername());
        chapter1.setIsvip(chapter.isIsvip());
        try {
            Utils.saveContext(chapter1.getArticleno(), chapter1.getChapterno(), content);
        } catch (Exception e) {
            logger.error(" update chapter content error------------->", e);
        }

        chapterService.update(chapter1);


        Article article = articleService.getByNo(chapter1.getArticleno());
        article.setArticleno(chapter.getArticleno());
        article.setSize(chapterService.getChapterCountSize(chapter1.getArticleno()));
        article.setModifytime(new Date());
        article.setModifyuserno(0);

        articleService.updateNewChapter(article);

        return "redirect:/admin/chapter/list?articleno=" + chapter.getArticleno();
    }


    @RequestMapping("chapter/del/{chapterno}")
    public String delete(@PathVariable int chapterno) {
        Chapter chapter = chapterService.getByNo(chapterno);
        chapter.setDeleteflag(true);
        chapter.setModifyuserno(0);
        chapter.setModifytime(new Date());
        chapterService.update(chapter);

        Chapter lastChapter = chapterService.getLastChapter(chapter.getArticleno());
        Article article = articleService.getByNo(chapter.getArticleno());
        if (lastChapter != null) {
            article.setChapters(chapterService.getChapterCount(chapter.getArticleno()));
            article.setSize(chapterService.getChapterCountSize(chapter.getArticleno()));
            article.setLastchapterno(lastChapter.getChapterno());
            article.setLastchapter(lastChapter.getChaptername());
            article.setLastupdate(new Date());
        } else {
            article.setChapters(0);
            article.setSize(0);
            article.setLastchapterno(0);
            article.setLastchapter(null);
            article.setLastupdate(null);
        }
        article.setModifytime(new Date());
        article.setModifyuserno(0);
        articleService.updateNewChapter(article);

        return "redirect:/admin/chapter/list?articleno=" + chapter.getArticleno();
    }


    @RequestMapping("chapter/delall/{articleno}")
    public String deletelAll(@PathVariable int articleno) {

        chapterService.deleteAllByArticleno(articleno);

        Article article=new Article();
        article.setArticleno(articleno);
        article.setChapters(0);
        article.setSize(0);
        article.setLastchapterno(0);
        article.setLastchapter(null);
        article.setLastupdate(null);
        article.setModifytime(new Date());
        article.setModifyuserno(0);
        articleService.updateNewChapter(article);

        return "redirect:/admin/chapter/list?articleno=" + articleno;
    }


}
