package com.taototao.novel.service.impl;

import com.taototao.novel.bean.ReviewSearchBean;
import com.taototao.novel.dao.ReviewDao;
import com.taototao.novel.entity.Review;
import com.taototao.novel.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-21 16:37
 **/
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewDao reviewDao;
    public int getCount(ReviewSearchBean searchBean) {
        return reviewDao.getCount(searchBean);
    }

    public List<Review> find(ReviewSearchBean searchBean) {
        return reviewDao.find(searchBean);
    }

    public void deleteByNo(int reviewno) {
        reviewDao.deleteByNo(reviewno);
    }
}
