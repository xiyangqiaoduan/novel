package com.taototao.novel.service.impl;

import com.taototao.novel.bean.ChapterSearchBean;
import com.taototao.novel.dao.ChapterDao;
import com.taototao.novel.entity.Chapter;
import com.taototao.novel.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-20 16:50
 **/
@Service
public class ChapterServiceImpl implements ChapterService{

    @Autowired
    private ChapterDao chapterDao;


    public List<Chapter> find(ChapterSearchBean searchBean) {


        return chapterDao.find(searchBean);
    }

    public int getChapterCount(int articleno) {
        return chapterDao.getChapterCount(articleno);
    }

    public void save(Chapter chapter) {
         chapterDao.save(chapter);
    }
}
