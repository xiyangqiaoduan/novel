package com.taototao.novel.dao;

import com.taototao.novel.bean.ChapterSearchBean;
import com.taototao.novel.entity.Chapter;

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
}
