package com.taototao.novel.service;

import com.taototao.novel.bean.ArticleSearchBean;
import com.taototao.novel.entity.Article;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-19 11:45
 **/
public interface ArticleService {
    /**
     * 根据条件取得小说件数
     * @param searchBean
     *          检索条件
     * @return 小说件数
     */
    int getCount(ArticleSearchBean searchBean);

    /**
     * 根据条件取得小说列表
     * @param searchBean
     *          检索条件
     * @return 小说列表
     */
    List<Article> find(ArticleSearchBean searchBean);

    /**
     * 通过拼音查找小说
     * @param pinyin
     *          拼音
     * @return 小说
     */
    Article findByPinyinRegularRxpressions(String pinyin);

    /**
     * 新增小说
     * @param article
     */
    int save(Article article);

    /**
     * 根据编号获取小说
     * @param articleno
     * @return 小说
     */
    Article getByNo(int articleno);

    /**
     * 更新小说
     * @param article
     */
    void update(Article article);

    /**
     * 删除
     * @param article
     */
    void delByNo(Article article);
}
