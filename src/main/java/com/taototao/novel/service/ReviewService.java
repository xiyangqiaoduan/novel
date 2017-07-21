package com.taototao.novel.service;

import com.taototao.novel.bean.ReviewSearchBean;
import com.taototao.novel.entity.Review;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-21 16:37
 **/
public interface ReviewService {
    /**
     * 根据条件取得评论件数
     *
     * @param searchBean
     *            检索条件
     * @return 评论件数
     */
    int getCount(ReviewSearchBean searchBean);
    /**
     * 根据条件取得评论列表
     *
     * @param searchBean
     *            检索条件
     * @return 评论列表
     */
    List<Review> find(ReviewSearchBean searchBean);
    /**
     * 通过评论编号删除评论信息
     *
     * @param reviewno
     *            评论编号
     */
    void deleteByNo(int reviewno);
}
