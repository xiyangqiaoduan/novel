package com.taototao.novel.controller.admin;

import com.taototao.novel.controller.base.AbstractAdminBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-14 15:57
 **/
@Controller
@RequestMapping(AbstractAdminBaseController.NAMESPACE)
public class ConfigController extends AbstractAdminBaseController {

    @RequestMapping("configEdit")
    public String index(){

        return "admin/configEdit";
    }


}
