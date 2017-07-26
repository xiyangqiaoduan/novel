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

    public Chapter getByNo(int chapterno) {
        return chapterDao.getByNo(chapterno);
    }

    public int getChapterCountSize(int articleno) {
        return chapterDao.getChapterCountSize(articleno);
    }

    public void update(Chapter chapter) {
        chapterDao.update(chapter);
    }

    public Chapter getLastChapter(int articleno) {
        return chapterDao.getLastChapter(articleno);
    }

    public void deleteAllByArticleno(int articleno) {
         chapterDao.deleteAllByArticleno(articleno);
    }

    public List<Chapter> findWithPinyin(ChapterSearchBean searchBean) {
        return chapterDao.findWithPinyin(searchBean);
    }

    public List<Chapter> getChapterInSegement(int articleno, int chapterno, int toChapterno) {
        return chapterDao.getChapterInSegement(articleno,chapterno,toChapterno);
    }

    public Chapter getNextChapter(int articleno, int chapterno, boolean isNext) {
        return chapterDao.getNextChapter(articleno,chapterno,isNext);
    }
}
