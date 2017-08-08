package com.taototao.novel.controller;

import com.taototao.novel.constant.ICommon;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-08-08 16:32
 **/
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public String defaultErrorHandler(HttpServletRequest req, ModelMap map, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        map.put("contextPath","/novel");
        map.put("themeName", ICommon.themes);
        return ICommon.themes+"/single/error/error404";

    }
}
