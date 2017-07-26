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

    /**
     * 更新最新章节
     * @param article
     */
    void updateNewChapter(Article article);


    /**
     * 根据小说分类取得随机推荐列表<br>
     *
     * @param count
     *            小说件数
     * @return 推荐列表
     */
    List<Article> findRandomRecommendArticleList(int count);
    /**
     * 根据小说分类和小说编号取得推荐列表<br>
     * 其实就是取同类的小说中当前小说的之后的指定的count本小说<br>
     *
     * @param category
     *            分类编号
     * @param articleno
     *            小说编号
     * @return 推荐列表
     */
    List<Article> findRecommendArticleList(int category, int articleno, int limitnum);
    /**
     * 根据关键和件数取得相关小说列表<br>
     *
     * @param keys
     *            相似关键字
     * @return 推荐列表
     */
    List<Article> findRelativeArticleList(List<String> keys, String sortCol, boolean isAsc, int limitnum);
    /**
     * 更新点击量信息
     *
     * @param articleno
     *            小说编号
     */
    void updateVisitStatistic(int articleno);

    /***
     * 更新推荐量信息
     * @param articleno 小说编号
     */
    void updateVoteStatistic(int articleno);
}
