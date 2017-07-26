package com.taototao.novel.dao;

import com.taototao.novel.bean.ChapterSearchBean;
import com.taototao.novel.entity.Chapter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-13 17:44
 **/
public interface ChapterDao {
    /**
     * 根据条件取得章节列表
     *
     * @param searchBean
     *            检索条件
     * @return 章节列表
     */
    List<Chapter> find(ChapterSearchBean searchBean);

    /**
     * 根据小说编号获取章节数
     *
     * @param articleno
     *            小说编号
     * @return 章节数
     */
    int getChapterCount(int articleno);

    /**
     * 新增章节信息
     * @param chapter
     */
    void save(Chapter chapter);

    Chapter getByNo(int chapterno);

    /**
     * 根据小说编号获取小数总字数
     * @param articleno
     * @return
     */
    int getChapterCountSize(int articleno);

    /**
     * 更新章节信息
     * @param chapter
     */
    void update(Chapter chapter);

    /**
     * 获取最新章节信息
     * @param articleno
     * @return
     */
    Chapter getLastChapter(int articleno);

    /**
     * 根据小说编号删除所有章节
     * @param articleno
     */
    void deleteAllByArticleno(int articleno);
    /**
     * 根据条件取得章节列表
     *
     * @param searchBean
     *            检索条件
     * @return 章节列表
     */
    List<Chapter> findWithPinyin(ChapterSearchBean searchBean);
    /**
     * 获取一个区间段内的章节, 用于全文阅读
     *
     * @param articleno
     *            小说编号
     * @param chapterno
     *            开始章节编号
     * @param toChapterno
     *            结束章节编号
     * @return 章节列表
     */
    List<Chapter> getChapterInSegement(@Param("articleno") int articleno,@Param("chapterno") int chapterno,@Param("toChapterno") int toChapterno);
    /**
     * 根据小说编号和章节编号和标致获取章下一个章节信息
     *
     * @param articleno
     *            小说编号
     * @param chapterno
     *            章节编号
     * @param isNext
     *            TRUE的话，下一章；false的话，上一章
     * @return 章节信息
     */
    Chapter getNextChapter(@Param("articleno") int articleno,@Param("chapterno") int chapterno,@Param("isNext")  boolean isNext);
}
