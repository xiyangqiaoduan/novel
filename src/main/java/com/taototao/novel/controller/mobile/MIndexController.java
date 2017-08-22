package com.taototao.novel.controller.mobile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-08-13 21:06
 **/
@Controller
@RequestMapping("m")
public class MIndexController {


    @RequestMapping("index.html")
    public String index(){


        return "";
    }

}


