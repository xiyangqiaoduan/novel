package com.taototao.novel.controller;

import com.taototao.novel.constant.ICommon;
import com.taototao.novel.constant.TaoToTaoConstants;
import com.taototao.novel.controller.base.AbstractPublicBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-24 10:17
 **/
@Controller
@RequestMapping("/")
public class IndexFrontController extends AbstractPublicBaseController {

    @RequestMapping("/index")
    public String index(ModelMap map){
        loadBlock(map);

        map.put("pageType",TaoToTaoConstants.Pagetype.PAGE_INDEX);
        return ICommon.themes+"/pc/index";
    }



}
