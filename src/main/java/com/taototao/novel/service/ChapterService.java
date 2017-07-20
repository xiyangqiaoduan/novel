package com.taototao.novel.service;

import com.taototao.novel.bean.ChapterSearchBean;
import com.taototao.novel.entity.Chapter;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-20 16:50
 **/
public interface ChapterService {

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
     *          章节信息
     */
    void save(Chapter chapter);
}
