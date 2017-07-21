package com.taototao.novel.controller.admin;

import java.util.Date;
import java.util.List;

import com.taototao.novel.bean.UserSearchBean;
import com.taototao.novel.constant.TaoToTaoConfig;
import com.taototao.novel.constant.TaoToTaoConstants;
import com.taototao.novel.controller.base.AbstractAdminBaseController;
import com.taototao.novel.entity.User;
import com.taototao.novel.service.UserService;
import com.taototao.novel.utils.Pagination;
import com.taototao.novel.utils.Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-21 13:02
 **/
@Controller
@RequestMapping(AbstractAdminBaseController.NAMESPACE)
public class UserController extends AbstractAdminBaseController {

    @Autowired
    private UserService userService;


    @RequestMapping("/user/list")
    public String list(Pagination pagination, ModelMap map) {

        UserSearchBean searchBean = new UserSearchBean();

        if (pagination.getPageSize() == 0) {
            pagination.setPageSize(TaoToTaoConstants.taoToTaoConf.getInt(TaoToTaoConfig.NUMBER_PER_PAGE));
        }
        if (pagination.getPageNumber() == 0) {
            pagination.setPageNumber(1);
            pagination.setStart(0);
        } else {
            pagination.setStart(pagination.getPageSize() * (pagination.getPageNumber() - 1));
        }
        if (StringUtils.isEmpty(pagination.getSortColumn())) {
            pagination.setSortColumn("userno");
        }
        searchBean.setPagination(pagination);
        pagination.setPreperties(userService.getCount(searchBean));
        List<User> userList = userService.find(searchBean);
        map.put("pagination", pagination);
        map.put("userList", userList);
        return "admin/userList";

    }


    @RequestMapping("user/addPage")
    public String addPage(){
        return "admin/userEdit";
    }


    @RequestMapping("user/add")
    public String save(User user){
        logger.debug("save start ----------->{}",user.toString());
        user.setModifytime(new Date());
        user.setActivedflag(true);
        user.setModifyuserno(0);
        user.setRegdate(new Date());
        if(StringUtils.isEmpty(user.getPassword())){
            user.setPassword(Utils.convert2MD5("taototao"));
        }else{
            user.setPassword(Utils.convert2MD5(user.getPassword()));
        }
        userService.save(user);
        return "redirect:/admin/user/list";
    }


    @RequestMapping("user/edit/{userno}")
    public String editPage(@PathVariable int userno , ModelMap map){
        User user=userService.getByNo(userno);
        map.put("user",user);
        return "admin/userEdit";

    }

    @RequestMapping("user/edit")
    public String edit(User user){
        userService.update(user);
        return "redirect:/admin/user/list";
    }


    @RequestMapping("user/del/{userno}")
    public String delete(@PathVariable int userno){

        User user=userService.getByNo(userno);

        userService.delByNo(user);

        return "redirect:/admin/user/list";
    }




}
