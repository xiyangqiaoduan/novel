package com.taototao.novel.controller.admin;

import com.taototao.novel.spider.bixiange.BiXianGeSpider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-28 16:50
 **/
@Controller
@RequestMapping("spider")
public class SpiderController {
    @Autowired
    private BiXianGeSpider biXianGeSpider;
    @RequestMapping("index")
    public String spider(){
        biXianGeSpider.main();
        return "SUCCESS";
    }


}
