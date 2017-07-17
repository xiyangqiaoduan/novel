package com.taototao.novel.controller.admin;

import com.taototao.novel.constant.TaoToTaoConfig;
import com.taototao.novel.constant.TaoToTaoConstants;
import com.taototao.novel.controller.base.AbstractAdminBaseController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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
    public String index(ModelMap modelMap){
        modelMap.put(TaoToTaoConfig.URI,TaoToTaoConstants.taoToTaoConf.getString(TaoToTaoConfig.URI));
        modelMap.put(TaoToTaoConfig.MOBILE_URI,TaoToTaoConstants.taoToTaoConf.getString(TaoToTaoConfig.MOBILE_URI));
        modelMap.put(TaoToTaoConfig.FILE_PATH,TaoToTaoConstants.taoToTaoConf.getString(TaoToTaoConfig.FILE_PATH));
        modelMap.put(TaoToTaoConfig.RELATIVE_IAMGE_PATH,TaoToTaoConstants.taoToTaoConf.getString(TaoToTaoConfig.RELATIVE_IAMGE_PATH));
        modelMap.put(TaoToTaoConfig.CACHE_EFFECTIVE,TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.CACHE_EFFECTIVE));
        modelMap.put(TaoToTaoConfig.CLEAN_URL,TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.CLEAN_URL));
        modelMap.put(TaoToTaoConfig.GZIP_EFFECTIVE,TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.GZIP_EFFECTIVE));
        modelMap.put(TaoToTaoConfig.AD_EFFECTIVE,TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.AD_EFFECTIVE));
        modelMap.put(TaoToTaoConfig.COUNT_PER_PAGE,TaoToTaoConstants.taoToTaoConf.getInt(TaoToTaoConfig.COUNT_PER_PAGE));
        modelMap.put(TaoToTaoConfig.MAX_BOOKCASE,TaoToTaoConstants.taoToTaoConf.getInt(TaoToTaoConfig.MAX_BOOKCASE));
        modelMap.put(TaoToTaoConfig.THEME_NAME,TaoToTaoConstants.taoToTaoConf.getString(TaoToTaoConfig.THEME_NAME));
        modelMap.put(TaoToTaoConfig.CREATE_INDEXPAGE,TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.CREATE_INDEXPAGE));
        modelMap.put(TaoToTaoConfig.CREATE_SITEMAP,TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.CREATE_SITEMAP));
        modelMap.put(TaoToTaoConfig.CREATE_STRUCTURINGDATA,TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.CREATE_STRUCTURINGDATA));
        modelMap.put(TaoToTaoConfig.SITEMAP_TYPE,TaoToTaoConstants.taoToTaoConf.getString(TaoToTaoConfig.SITEMAP_TYPE));
        modelMap.put(TaoToTaoConfig.XML_SITEMAP_LIST_WITH_NO_PAGE_URL,TaoToTaoConstants.taoToTaoConf.getString(TaoToTaoConfig.XML_SITEMAP_LIST_WITH_NO_PAGE_URL));
        modelMap.put(TaoToTaoConfig.XML_SITEMAP_LIST_URL,TaoToTaoConstants.taoToTaoConf.getString(TaoToTaoConfig.XML_SITEMAP_LIST_URL));
        modelMap.put(TaoToTaoConfig.XML_SITEMAP_INFO_URL,TaoToTaoConstants.taoToTaoConf.getString(TaoToTaoConfig.XML_SITEMAP_INFO_URL));
        modelMap.put(TaoToTaoConfig.XML_SITEMAP_CHATERLIST_URL,TaoToTaoConstants.taoToTaoConf.getString(TaoToTaoConfig.XML_SITEMAP_CHATERLIST_URL));
        modelMap.put(TaoToTaoConfig.XML_SITEMAP_READER_URL,TaoToTaoConstants.taoToTaoConf.getString(TaoToTaoConfig.XML_SITEMAP_READER_URL));
        modelMap.put(TaoToTaoConfig.COMPRESS_EFFECTIVE,TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.COMPRESS_EFFECTIVE));
        modelMap.put(TaoToTaoConfig.TXT_ENCODING,TaoToTaoConstants.taoToTaoConf.getString(TaoToTaoConfig.TXT_ENCODING));
        modelMap.put(TaoToTaoConfig.ADD_REVIEW_WITHOUT_LOGIN,TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.ADD_REVIEW_WITHOUT_LOGIN));
        modelMap.put(TaoToTaoConfig.ENABLE_MOBILE_SITE,TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.ENABLE_MOBILE_SITE));
        modelMap.put(TaoToTaoConfig.JUDG_MOBILESITE_BY_DOMIAN,TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.JUDG_MOBILESITE_BY_DOMIAN));
        modelMap.put(TaoToTaoConfig.MOBILESITE_DOMIAN,TaoToTaoConstants.taoToTaoConf.getString(TaoToTaoConfig.MOBILESITE_DOMIAN));
        modelMap.put(TaoToTaoConfig.ENABLE_PSEUDO,TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.ENABLE_PSEUDO));
        modelMap.put(TaoToTaoConfig.ENABLE_QQLOGIN,TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.ENABLE_QQLOGIN));
        modelMap.put(TaoToTaoConfig.APP_ID,TaoToTaoConstants.taoToTaoConf.getString(TaoToTaoConfig.APP_ID));
        modelMap.put(TaoToTaoConfig.APP_KEY,TaoToTaoConstants.taoToTaoConf.getString(TaoToTaoConfig.APP_KEY));



        modelMap.put(TaoToTaoConfig.ENABLE_CACHE_ARTICLE_COUNT,TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.ENABLE_CACHE_ARTICLE_COUNT));
        modelMap.put(TaoToTaoConfig.ENABLE_CHAPTER_INDEX_PAGE,TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.ENABLE_CHAPTER_INDEX_PAGE));
        modelMap.put(TaoToTaoConfig.ENABLE_GENERATE_HTML_FILE,TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.ENABLE_GENERATE_HTML_FILE));
        modelMap.put(TaoToTaoConfig.ENABLE_MAIL_AUTH,TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.ENABLE_MAIL_AUTH));
        modelMap.put(TaoToTaoConfig.MAIL_SMTP_AUTH,TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.MAIL_SMTP_AUTH));
        modelMap.put(TaoToTaoConfig.MAIL_SMTP_STARTTLS_ENABLE,TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.MAIL_SMTP_STARTTLS_ENABLE));
        modelMap.put(TaoToTaoConfig.MAIL_SMTP_HOST,TaoToTaoConstants.taoToTaoConf.getString(TaoToTaoConfig.MAIL_SMTP_HOST));
        modelMap.put(TaoToTaoConfig.MAIL_SMTP_PORT,TaoToTaoConstants.taoToTaoConf.getInt(TaoToTaoConfig.MAIL_SMTP_PORT,25));
        modelMap.put(TaoToTaoConfig.MAIL_SMTP_USERNAME,TaoToTaoConstants.taoToTaoConf.getString(TaoToTaoConfig.MAIL_SMTP_USERNAME));
        modelMap.put(TaoToTaoConfig.MAIL_SMTP_PASSWORD,TaoToTaoConstants.taoToTaoConf.getString(TaoToTaoConfig.MAIL_SMTP_PASSWORD));
        modelMap.put(TaoToTaoConfig.MAIL_SMTP_FROM,TaoToTaoConstants.taoToTaoConf.getString(TaoToTaoConfig.MAIL_SMTP_FROM));
        modelMap.put(TaoToTaoConfig.MAX_SUBSCRIBE,TaoToTaoConstants.taoToTaoConf.getInt(TaoToTaoConfig.MAX_SUBSCRIBE,30));
        modelMap.put(TaoToTaoConfig.SEND_SUBSCRIBE_INTEVAL,TaoToTaoConstants.taoToTaoConf.getInt(TaoToTaoConfig.SEND_SUBSCRIBE_INTEVAL,15));
        modelMap.put(TaoToTaoConfig.ENABLE_SINGLE_BOOK,TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.ENABLE_SINGLE_BOOK,false));
        modelMap.put(TaoToTaoConfig.ROOT_DOMAIN,TaoToTaoConstants.taoToTaoConf.getString(TaoToTaoConfig.ROOT_DOMAIN));
        modelMap.put(TaoToTaoConfig.EXCLUDE_SUB_DOMAIN,TaoToTaoConstants.taoToTaoConf.getString(TaoToTaoConfig.EXCLUDE_SUB_DOMAIN));
        modelMap.put(TaoToTaoConfig.RELOAD_SINGLE_BOOK_INTERVAL,TaoToTaoConstants.taoToTaoConf.getInt(TaoToTaoConfig.RELOAD_SINGLE_BOOK_INTERVAL,120));
        modelMap.put(TaoToTaoConfig.ENABLE_CLEAN_IMAGE_URL,TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.ENABLE_CLEAN_IMAGE_URL,false));
        modelMap.put(TaoToTaoConfig.FILTER_KEYWORD,TaoToTaoConstants.taoToTaoConf.getString(TaoToTaoConfig.FILTER_KEYWORD));
        modelMap.put(TaoToTaoConfig.ENABLE_PINYINURL,TaoToTaoConstants.taoToTaoConf.getBoolean(TaoToTaoConfig.ENABLE_PINYINURL));

        if(StringUtils.isNotEmpty(TaoToTaoConstants.taoToTaoConf.getString(TaoToTaoConfig.MSG))){
            modelMap.put(TaoToTaoConfig.MSG,TaoToTaoConstants.taoToTaoConf.getString(TaoToTaoConfig.MSG));
            TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.MSG,null);
        }
        return "admin/configEdit";
    }


    @RequestMapping("configEdit/save")
    public String save(HttpServletRequest request,ModelMap modelMap){
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.URI,request.getParameter(TaoToTaoConfig.URI));
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.MOBILE_URI,request.getParameter(TaoToTaoConfig.MOBILE_URI));
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.FILE_PATH,request.getParameter(TaoToTaoConfig.FILE_PATH));
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.RELATIVE_IAMGE_PATH,request.getParameter(TaoToTaoConfig.RELATIVE_IAMGE_PATH));
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.CACHE_EFFECTIVE,"1".equals(request.getParameter(TaoToTaoConfig.CACHE_EFFECTIVE))?true:false);
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.CLEAN_URL,"1".equals(request.getParameter(TaoToTaoConfig.CLEAN_URL))?true:false);
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.GZIP_EFFECTIVE,"1".equals(request.getParameter(TaoToTaoConfig.GZIP_EFFECTIVE))?true:false);
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.AD_EFFECTIVE,"1".equals(request.getParameter(TaoToTaoConfig.AD_EFFECTIVE))?true:false);
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.COUNT_PER_PAGE,StringUtils.isEmpty(request.getParameter(TaoToTaoConfig.COUNT_PER_PAGE))?15:Integer.parseInt(request.getParameter(TaoToTaoConfig.COUNT_PER_PAGE)));
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.MAX_BOOKCASE,StringUtils.isEmpty(request.getParameter(TaoToTaoConfig.COUNT_PER_PAGE))?15:Integer.parseInt(request.getParameter(TaoToTaoConfig.COUNT_PER_PAGE)));
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.THEME_NAME,request.getParameter(TaoToTaoConfig.THEME_NAME));
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.CREATE_INDEXPAGE,"1".equals(request.getParameter(TaoToTaoConfig.CREATE_INDEXPAGE))?true:false);
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.CREATE_SITEMAP,"1".equals(request.getParameter(TaoToTaoConfig.CREATE_SITEMAP))?true:false);
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.CREATE_STRUCTURINGDATA,"1".equals(request.getParameter(TaoToTaoConfig.CREATE_STRUCTURINGDATA))?true:false);
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.SITEMAP_TYPE,request.getParameter(TaoToTaoConfig.SITEMAP_TYPE));
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.XML_SITEMAP_LIST_WITH_NO_PAGE_URL,request.getParameter(TaoToTaoConfig.XML_SITEMAP_LIST_WITH_NO_PAGE_URL));
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.XML_SITEMAP_LIST_URL,request.getParameter(TaoToTaoConfig.XML_SITEMAP_LIST_URL));
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.XML_SITEMAP_INFO_URL,request.getParameter(TaoToTaoConfig.XML_SITEMAP_INFO_URL));
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.XML_SITEMAP_CHATERLIST_URL,request.getParameter(TaoToTaoConfig.XML_SITEMAP_CHATERLIST_URL));
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.XML_SITEMAP_READER_URL,request.getParameter(TaoToTaoConfig.XML_SITEMAP_READER_URL));
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.COMPRESS_EFFECTIVE,"1".equals(request.getParameter(TaoToTaoConfig.COMPRESS_EFFECTIVE))?true:false);
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.TXT_ENCODING,request.getParameter(TaoToTaoConfig.TXT_ENCODING));

        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.ADD_REVIEW_WITHOUT_LOGIN,"1".equals(request.getParameter(TaoToTaoConfig.ADD_REVIEW_WITHOUT_LOGIN))?true:false);
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.ENABLE_MOBILE_SITE,"1".equals(request.getParameter(TaoToTaoConfig.ENABLE_MOBILE_SITE))?true:false);
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.JUDG_MOBILESITE_BY_DOMIAN,"1".equals(request.getParameter(TaoToTaoConfig.JUDG_MOBILESITE_BY_DOMIAN))?true:false);
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.MOBILESITE_DOMIAN,request.getParameter(TaoToTaoConfig.MOBILESITE_DOMIAN));
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.ENABLE_PSEUDO,"1".equals(request.getParameter(TaoToTaoConfig.ENABLE_PSEUDO))?true:false);
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.ENABLE_QQLOGIN,"1".equals(request.getParameter(TaoToTaoConfig.ENABLE_QQLOGIN))?true:false);
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.APP_ID,request.getParameter(TaoToTaoConfig.APP_ID));
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.APP_KEY,request.getParameter(TaoToTaoConfig.APP_KEY));


        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.ENABLE_CACHE_ARTICLE_COUNT,"1".equals(request.getParameter(TaoToTaoConfig.ENABLE_CACHE_ARTICLE_COUNT))?true:false);
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.ENABLE_CHAPTER_INDEX_PAGE,"1".equals(request.getParameter(TaoToTaoConfig.ENABLE_CHAPTER_INDEX_PAGE))?true:false);
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.ENABLE_GENERATE_HTML_FILE,"1".equals(request.getParameter(TaoToTaoConfig.ENABLE_GENERATE_HTML_FILE))?true:false);
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.ENABLE_MAIL_AUTH,"1".equals(request.getParameter(TaoToTaoConfig.ENABLE_GENERATE_HTML_FILE))?true:false);

        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.MAIL_SMTP_AUTH,"1".equals(request.getParameter(TaoToTaoConfig.MAIL_SMTP_AUTH))?true:false);
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.MAIL_SMTP_STARTTLS_ENABLE,"1".equals(request.getParameter(TaoToTaoConfig.MAIL_SMTP_STARTTLS_ENABLE))?true:false);
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.MAIL_SMTP_HOST,request.getParameter(TaoToTaoConfig.MAIL_SMTP_HOST));
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.MAIL_SMTP_USERNAME,request.getParameter(TaoToTaoConfig.MAIL_SMTP_USERNAME));
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.MAIL_SMTP_PASSWORD,request.getParameter(TaoToTaoConfig.MAIL_SMTP_PASSWORD));
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.MAIL_SMTP_FROM,request.getParameter(TaoToTaoConfig.MAIL_SMTP_FROM));
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.MAX_SUBSCRIBE,StringUtils.isEmpty(request.getParameter(TaoToTaoConfig.MAX_SUBSCRIBE))?30:request.getParameter(TaoToTaoConfig.MAX_SUBSCRIBE));
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.SEND_SUBSCRIBE_INTEVAL,StringUtils.isEmpty(request.getParameter(TaoToTaoConfig.SEND_SUBSCRIBE_INTEVAL))?15:request.getParameter(TaoToTaoConfig.SEND_SUBSCRIBE_INTEVAL));
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.ENABLE_SINGLE_BOOK,"1".equals(request.getParameter(TaoToTaoConfig.ENABLE_SINGLE_BOOK))?true:false);
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.ROOT_DOMAIN,request.getParameter(TaoToTaoConfig.ROOT_DOMAIN));
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.EXCLUDE_SUB_DOMAIN,request.getParameter(TaoToTaoConfig.EXCLUDE_SUB_DOMAIN));
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.RELOAD_SINGLE_BOOK_INTERVAL,StringUtils.isEmpty(request.getParameter(TaoToTaoConfig.RELOAD_SINGLE_BOOK_INTERVAL))?120:request.getParameter(TaoToTaoConfig.RELOAD_SINGLE_BOOK_INTERVAL));
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.ENABLE_CLEAN_IMAGE_URL,"1".equals(request.getParameter(TaoToTaoConfig.ENABLE_CLEAN_IMAGE_URL))?true:false);
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.FILTER_KEYWORD,request.getParameter(TaoToTaoConfig.FILTER_KEYWORD));
        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.ENABLE_PINYINURL,"1".equals(request.getParameter(TaoToTaoConfig.ENABLE_PINYINURL))?true:false);

        TaoToTaoConstants.taoToTaoConf.setProperty(TaoToTaoConfig.MSG,"参数设置成功");



        return "redirect:/admin/configEdit";
    }


}
