package com.taototao.novel.dao;

import com.taototao.novel.bean.ArticleSearchBean;
import com.taototao.novel.entity.Article;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 根据小说分类取得随机推荐列表
     * @param searchBean
     * @return
     */
    List<Article> findRandomRecommendArticleList(  ArticleSearchBean searchBean);

    /**
     *
     * @param category
     * @param articleno
     * @param limitnum
     * @return
     */
    List<Article> findRecommendArticleList(@Param("category") int category, @Param("articleno")int articleno,@Param("limitnum") int limitnum);

    /**
     * 根据关键和件数取得相关小说列表<br>
     * @param cond
     * @param sortCol
     * @param isAsc
     * @param limitnum
     * @return
     */
    List<Article> findRelativeArticleList(@Param("cond") String cond, @Param("sortCol")String sortCol,@Param("isAsc") boolean isAsc, @Param("limitnum")int limitnum);


    /**
     * 更新点击量信息
     *
     * @param articleno
     *            小说编号
     */
    void updateVisitStatistic(int articleno);

    /**
     * 更新推荐量
     * @param articleno
     */
    void updateVoteStatistic(int articleno);
}
