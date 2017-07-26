package com.taototao.novel.controller;

import com.taototao.novel.constant.ICommon;
import com.taototao.novel.controller.base.AbstractPublicBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-25 13:46
 **/
@Controller
@RequestMapping(AbstractPublicBaseController.CHAPTER_NAMES)
public class ChapterFrontController extends AbstractPublicBaseController {

    public final static  String DETAIL="detail";

    public final static String LIST="list";

    @RequestMapping(DETAIL+"/{subdir}/{articleno}/{chapterno}/{pinyin}")
    public String detail(int subdir, int articleno,int chapterno){


        return ICommon.themes+"/pc/reder";
    }

    @RequestMapping(LIST+"/{subdir}/{articleno}/{chapterno}/{pinyin}")
    public String list(int subdir, int articleno,int chapterno){

        return ICommon.themes+"/pc/chapterList";
    }
}
