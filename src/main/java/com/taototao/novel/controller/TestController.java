package com.taototao.novel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-12 15:25
 **/
@Controller
public class TestController {

    @RequestMapping("index")
    public String index(){
        return "/default/index";
    }

}
