package com.taototao.novel.entity;

import com.taototao.novel.constant.TaoToTaoConstants;
import com.taototao.novel.controller.ReaderController;
import com.taototao.novel.controller.base.AbstractPublicBaseController;

import java.io.Serializable;
import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-12 22:45
 **/
public class Chapter implements Serializable {
    /**章节编号*/
    private int chapterno;
    /**文章编号*/
    private int articleno;
    /**文章名称*/
    private String articlename;
    /**章节类型*/
    private Short chaptertype;
    /**章节名称*/
    private String chaptername;
    /**数量*/
    private int size;
    /**是否VIP*/
    private boolean isvip;
    /**时间*/
    private Date postdate;
    /**删除状态*/
    private boolean deleteflag;
    /**发表时间*/
    private Date publishtime;
    /**修改编号*/
    private int modifyuserno;
    /**修改时间*/
    private Date modifytime;
    /**是否发表*/
    private boolean ispublish;
    /**最后校验时间*/
    private Date lastchecktime;
    /**章节内容**/
    private String content;


    public int getChapterno() {
        return chapterno;
    }

    public void setChapterno(int chapterno) {
        this.chapterno = chapterno;
    }

    public int getArticleno() {
        return articleno;
    }

    public void setArticleno(int articleno) {
        this.articleno = articleno;
    }

    public String getArticlename() {
        return articlename;
    }

    public void setArticlename(String articlename) {
        this.articlename = articlename;
    }

    public Short getChaptertype() {
        return chaptertype;
    }

    public void setChaptertype(Short chaptertype) {
        this.chaptertype = chaptertype;
    }

    public String getChaptername() {
        return chaptername;
    }

    public void setChaptername(String chaptername) {
        this.chaptername = chaptername;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isIsvip() {
        return isvip;
    }

    public void setIsvip(boolean isvip) {
        this.isvip = isvip;
    }

    public Date getPostdate() {
        return postdate;
    }

    public void setPostdate(Date postdate) {
        this.postdate = postdate;
    }

    public boolean isDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(boolean deleteflag) {
        this.deleteflag = deleteflag;
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public int getModifyuserno() {
        return modifyuserno;
    }

    public void setModifyuserno(int modifyuserno) {
        this.modifyuserno = modifyuserno;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public boolean isIspublish() {
        return ispublish;
    }

    public void setIspublish(boolean ispublish) {
        this.ispublish = ispublish;
    }

    public Date getLastchecktime() {
        return lastchecktime;
    }

    public void setLastchecktime(Date lastchecktime) {
        this.lastchecktime = lastchecktime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "chapterno=" + chapterno +
                ", articleno=" + articleno +
                ", articlename='" + articlename + '\'' +
                ", chaptertype=" + chaptertype +
                ", chaptername='" + chaptername + '\'' +
                ", size=" + size +
                ", isvip=" + isvip +
                ", postdate=" + postdate +
                ", deleteflag=" + deleteflag +
                ", publishtime=" + publishtime +
                ", modifyuserno=" + modifyuserno +
                ", modifytime=" + modifytime +
                ", ispublish=" + ispublish +
                ", lastchecktime=" + lastchecktime +
                '}';
    }


    /**
     * 获取章节URL
     *
     * @return 章节URL
     */
    public String getUrl() {
        StringBuffer sb=new StringBuffer(AbstractPublicBaseController.READER_NAMES);
        sb.append("/")
                .append(ReaderController.CHAPTER_DETAIL)
                .append("/")
                .append(getSubdir())
                .append("/")
                .append( getArticleno())
                .append("/")
                .append(getChapterno());
        return sb.toString();
    }

    /**
     * 获得子目录 <br>
     * 默认是小说号/1000
     *
     * @return 子目录
     */
    public Integer getSubdir() {
        return getArticleno() / TaoToTaoConstants.SUB_DIR_ARTICLES;
    }


}
