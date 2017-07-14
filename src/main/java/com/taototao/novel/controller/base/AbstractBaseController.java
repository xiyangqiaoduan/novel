package com.taototao.novel.controller.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-14 13:00
 **/
public abstract class AbstractBaseController {

    /**
     * JSON结果类型
     */
    protected static final String JSON_RESULT = "json";
    /**
     * 返回主页结果类型
     */
    public static final String GO_TOP = "GOTO_Top";
    /**
     * 跳转登录页结果类型
     */
    public static final String GOTO_LOGIN = "GOTO_Login";
    /**
     * 重定向结果类型
     */
    public static final String REDIRECT = "redirect";
    /**
     * 消息结果类型
     */
    public static final String MESSAGE = "message";
    /**
     * HTTP HEADER类型
     */
    public static final String HTTPHEADER404 = "httpheader404";
    /**
     * 管理系的错误结果类型
     */
    public static final String ADMIN_ERROR = "adminerror";
    /**
     * freemarker结果类型
     */
    public static final String FREEMARKER = "freemarker";
    /**
     * freemarker错误结果类型
     */
    public static final String FREEMARKER_ERROR = "freemarker_error";
    /**
     * freemarker消息结果类型
     */
    public static final String FREEMARKER_MESSAGE = "freemarker_message";
    /**
     * 手机freemarker结果类型
     */
    public static final String MOBILE_FREEMARKER = "mobile_freemarker";
    /**
     * 手机freemarker错误结果类型
     */
    public static final String MOBILE_FREEMARKER_ERROR = "mobile_freemarker_error";
    /**
     * 手机freemarker消息结果类型
     */
    public static final String MOBILE_FREEMARKER_MESSAGE = "mobile_freemarker_message";

    /**
     * 单本freemarker结果类型
     */
    public static final String SINGLE_FREEMARKER = "single_freemarker";

    /**
     * 单本freemarker错误结果类型
     */
    public static final String SINGLE_FREEMARKER_ERROR = "single_freemarker_error";

    /**
     * 输出log
     */
    protected Logger logger = LoggerFactory.getLogger(this.getClass());



    /**
     * 获得系统相对路径
     *
     * @return 系统相对路径
     */
    public String getContextPath() {
        WebApplicationContext webApplicationContext= ContextLoader.getCurrentWebApplicationContext();
        ServletContext servletContext=webApplicationContext.getServletContext();
        return servletContext.getContextPath();
    }

    /**
     * 获得系统相对路径
     *
     * @return 系统相对路径
     */
    public String getRequestUrl() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        return request.getRequestURL().toString();
    }



}
