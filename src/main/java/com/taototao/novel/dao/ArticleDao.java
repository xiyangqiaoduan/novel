package com.taototao.novel.dao;

import com.taototao.novel.bean.ArticleSearchBean;
import com.taototao.novel.entity.Article;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-13 15:33
 **/
public interface ArticleDao {
    /**
     * 根据条件取得小说件数
     * @param searchBean
     *          检索条件
     * @return 小说件数
     */
    int getCount(ArticleSearchBean searchBean);

    /**
     * 根据条件获取小说列表
     * @param searchBean
     *          检索条件
     * @return 小说件数
     */
    List<Article> find(ArticleSearchBean searchBean);

    /**
     * 根据拼音查询小说
     * @param pinyin
     *          拼音
     * @return 小说
     */
    Article findByPinyinRegularRxpressions(String pinyin);

    /**
     * 新增小说
     * @param article
     * @return
     */
    int save(Article article);

    /**
     * 根据编号获取小说
     * @param articleno
     *          小说编号
     * @return 小说
     */
    Article getByNo(int articleno);

    /**
     * 更新小说
     * @param article
     */
    void update(Article article);

    /**
     * 根据编号删除
     * @param article
     */
    void delByNo(Article article);

    /**
     * 更新最新章节
     * @param article
     */
    void updateNewChapter(Article article);
}
