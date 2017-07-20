package com.taototao.novel.controller.admin;

import com.taototao.novel.bean.ChapterSearchBean;
import com.taototao.novel.controller.base.AbstractAdminBaseController;
import com.taototao.novel.entity.Article;
import com.taototao.novel.entity.Chapter;
import com.taototao.novel.service.ArticleService;
import com.taototao.novel.service.ChapterService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String list(int articleno, ModelMap map){

        Article article=articleService.getByNo(articleno);
        ChapterSearchBean searchBean = new ChapterSearchBean();
        searchBean.setPagination(null);
        List<Chapter> chapterList=chapterService.find(searchBean);
        map.put("article",article);
        map.put("chapterList",chapterList);
        return "admin/chapterList";
    }

    @RequestMapping("chapter/addPage")
    public String addPage(int articleno,ModelMap map){
        Article article=articleService.getByNo(articleno);
        map.put("article",article);
        return "admin/chapterEdit";
    }

    @RequestMapping("chapter/save")
    public String save(Chapter chapter,String context){
        logger.debug("章节信息----------->{}",chapter.toString());

        chapter.setChaptertype((short)0);
        chapter.setPostdate(new Date());
        chapter.setSize(StringUtils.length(context));
        chapter.setModifytime(new Date());
        chapter.setModifyuserno(0);

        chapterService.save(chapter);

        // 最新章节等信息

        Article article=new Article();
        article.setArticleno(chapter.getArticleno());
        article.setLastchapterno(chapter.getChapterno());
        article.setLastupdate(new Date());
        article.setSize(chapterService.getChapterCount(chapter.getArticleno()));
        article.setModifytime(new Date());
        article.setModifyuserno(0);


        return "redirect:/admin/chapter/list?articleno="+chapter.getArticleno();
    }


}
