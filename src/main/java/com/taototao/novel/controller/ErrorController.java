package com.taototao.novel.controller;

import com.taototao.novel.constant.ICommon;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-08-03 17:00
 **/
@Controller
@RequestMapping("error")
public class ErrorController {

    @RequestMapping("/")
    public String notfound(ModelMap map){
        map.put("contextPath","/novel");
        map.put("themeName", ICommon.themes);
        return ICommon.themes+"/single/error/error404";

    }

}
