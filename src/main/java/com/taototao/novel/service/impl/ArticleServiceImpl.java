package com.taototao.novel.service.impl;

import com.taototao.novel.bean.ArticleSearchBean;
import com.taototao.novel.dao.ArticleDao;
import com.taototao.novel.entity.Article;
import com.taototao.novel.service.ArticleService;
import com.taototao.novel.utils.Utils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-19 11:46
 **/
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;


    public int getCount(ArticleSearchBean searchBean) {

        return articleDao.getCount(searchBean);
    }

    public List<Article> find(ArticleSearchBean searchBean) {

        // 标签指定的话，添加标签条件
        if(Utils.isDefined(searchBean.getTag())){
            searchBean.setTag(StringEscapeUtils.escapeSql(searchBean.getTag()));
        }
        // 条件追加,文章名
        if(StringUtils.isNotEmpty(searchBean.getKey())){
            searchBean.setKey(StringEscapeUtils.escapeSql(searchBean.getKey().toLowerCase()));
        }

        return articleDao.find(searchBean);
    }



    public Article findByPinyinRegularRxpressions(String pinyin) {
        return articleDao.findByPinyinRegularRxpressions(pinyin);
    }

    public int save(Article article) {
        return articleDao.save(article);
    }

    public Article getByNo(int articleno) {
        return articleDao.getByNo(articleno);
    }

    public void update(Article article) {
         articleDao.update(article);
    }

    public void delByNo(Article article) {
        articleDao.delByNo(article);
    }
}
