package com.taototao.novel.controller;

import java.util.Date;
import java.util.List;
import com.taototao.novel.bean.UserSearchBean;
import com.taototao.novel.constant.ICommon;
import com.taototao.novel.constant.TaoToTaoConstants;
import com.taototao.novel.controller.base.AbstractPublicBaseController;
import com.taototao.novel.entity.User;
import com.taototao.novel.service.UserService;
import com.taototao.novel.utils.CookieUtils;
import com.taototao.novel.utils.LoginManager;
import com.taototao.novel.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-26 14:53
 **/
@Controller
@RequestMapping("user")
public class UserFrontController extends AbstractPublicBaseController{



    @Autowired
    private UserService userService;


    @RequestMapping("registerPage")
    public String registerPage(ModelMap map){
       loadBlock(map);
       map.put("pageType",TaoToTaoConstants.Pagetype.PAGE_REGEDIT);
        return   ICommon.themes + "/pc/register";
    }

    @RequestMapping("register")
    public String register(User user, ModelMap map, HttpServletRequest request){

        logger.debug("register start user={}",user.toString());
        // 重复检查
        UserSearchBean searchBean = new UserSearchBean();
        searchBean.setLoginid(user.getLoginid());
        searchBean.setDeleteflag(false);
        List<User> userList=userService.find(searchBean);

        if(userList!=null&&!userList.isEmpty()){
            map.put("errMsg","当前用户名已被注册");
            return "redirect:/user/registerPage";
        }

        // 邮箱重复检查
        searchBean.setLoginid(user.getEmail());
        searchBean.setDeleteflag(false);
        userList=userService.find(searchBean);

        if(userList!=null&&!userList.isEmpty()){
            map.put("errMsg","当前邮箱已经被注册");
            return "redirect:/user/registerPage";
        }

        user.setDeleteflag(false);
        user.setRegdate(new Date());
        user.setPassword(Utils.convert2MD5(user.getPassword()));
        user.setType(TaoToTaoConstants.UserType.NORMAL_USER);
        user.setModifytime(new Date());


//        // 是否开启邮箱验证
//        if (TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.ENABLE_MAIL_AUTH, false)) {
//
//            user.setMailtoken(Utils.convert2MD5(loginid + password + email));
//            user.setActivedflag(false);
//            // 注册用户登录
//            this.userService.save(user);
//
//        } else {
//
//            user.setActivedflag(true);
//            // 注册用户登录
//            this.userService.save(user);
//            // 未开启的话，直接登录
//            doLogin(user);
//            // 登录处理
//            logger.debug("RegisterAction register normally end.");
//            return REDIRECT;
//        }
        user.setActivedflag(true);
        userService.save(user);
        LoginManager.doLogin(user);

        return  "redirect:/index";
    }

    @RequestMapping("loginPage")
    public String loginPage(ModelMap map){
        loadBlock(map);
        map.put("pageType",TaoToTaoConstants.Pagetype.PAGE_LOGIN);
        return  ICommon.themes + "/pc/login";
    }



    @RequestMapping("login")
    public String login(String loginid, String password, Boolean useCookie, ModelMap map, HttpServletResponse response){
        logger.debug("login ------------>logind={},password={},useCookie={}",loginid,password,useCookie);
        if (LoginManager.isLoginFlag()) {
            return "redirect:/index";
        }else{
            // 记录访问地址
            LoginManager.setReferer();
            User user = userService.findByLoginInfo(loginid, Utils.convert2MD5(password));

            if(user==null){
                map.put("errorMsg","账号或者密码错误");
                return "redirect:/user/login";
            }

            LoginManager.doLogin(user);
            user.setLastlogin(new Date());
            userService.update(user);
            if (useCookie) {
                Cookie cookie = CookieUtils.addUserCookie(user);
                // 添加cookie到response中
                response.addCookie(cookie);
            }

        }


        return "redirect:/index";
    }







}
