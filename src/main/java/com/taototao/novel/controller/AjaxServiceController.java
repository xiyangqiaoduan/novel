package com.taototao.novel.controller;

import com.taototao.novel.controller.base.AbstractPublicBaseController;
import com.taototao.novel.service.ArticleService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-26 9:47
 **/
@Controller
@RequestMapping("/")
public class AjaxServiceController extends AbstractPublicBaseController {


    @Autowired
    private ArticleService articleService;


    /**
     *
     * <p>
     * 处理类型定义
     * </p>
     */
    class ProccessType {
        /**
         * <p>
         * 私有构造方法
         * </p>
         */
        private ProccessType() {
            // do nothing
        }

        public static final String TOP_LIST = "toplist";
        public static final String CATEGORY_LIST = "categorylist";
        public static final String CHAPTER_LIST = "chapterlist";
        public static final String LOGIN = "login";
        public static final String CHANGE_PASSWORD = "changepassword";
        public static final String BOOKCASEIS_EXISTS = "bookcaseisexists";
        public static final String BOOKCASE = "bookcase";
        public static final String DELETE_BOOKCASE = "deletebookcase";
        public static final String ADD_BOOKCASE = "addbookcase";
        public static final String DELETE_BOOKCASE_BY_ARTICLE = "deletebookcasebyarticle";
        public static final String HISTORY = "history";
        public static final String SEARCH = "search";
        public static final String REGISTER = "register";
        public static final String VOTE = "vote";
        public static final String SUBSCRIBE = "subscribe";
    }


    /**
     *
     * <p>
     * 返回代码定义
     * </p>
     */
    class ReturnCode {
        /**
         * <p>
         * 私有构造方法
         * </p>
         */
        private ReturnCode() {
            // do nothing
        }

        /**
         * 返回值：正常
         */
        public static final int SUCCESS = 0;
        /**
         * 返回值：出错
         */
        public static final int FAILED = 1;
    }

    @RequestMapping(value = "ajaxService",produces={"application/json;charset=utf-8"})
    @ResponseBody
    public Map<String,Object> ajaxService(int articleno,String action){

        logger.debug("ajaxService start articleno={},action={}",articleno,action);

        if(StringUtils.equals(action,ProccessType.CATEGORY_LIST)){

        }else if (StringUtils.equals(action, ProccessType.VOTE)) {
            return  doVote(articleno);
        }
        return null;
    }
    /**
     * <p>
     * 推荐处理
     * </p>
     */
    private Map<String,Object> doVote(int articleno) {
        logger.debug("doVote start.");
        articleService.updateVoteStatistic(articleno);

        Map<String,Object> result=new HashMap<String,Object>();

        result.put("code",ReturnCode.SUCCESS);
        result.put("result","恭喜您，推荐成功！");
        logger.debug("doVote normally end.");
        return  result;
    }


}
