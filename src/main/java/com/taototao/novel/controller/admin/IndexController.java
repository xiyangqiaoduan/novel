package com.taototao.novel.controller.admin;

import com.taototao.novel.controller.base.AbstractAdminBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-14 12:56
 **/
@Controller
@RequestMapping(AbstractAdminBaseController.NAMESPACE)
public class IndexController extends AbstractAdminBaseController{


    @RequestMapping("index")
    public String index(){
        return "admin/index";
    }



}
