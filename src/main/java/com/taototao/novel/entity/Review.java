package com.taototao.novel.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-12 18:10
 **/
public class Review implements Serializable{
    /**编号*/
    private int reviewno;
    /**用户编号*/
    private int userno;
    /**loginID*/
    private String loginid;
    /**文章编号*/
    private int articleno;
    /**文章名称*/
    private String articlename;
    /**章节*/
    private int chapterno;
    /**章节名称*/
    private String chaptername;
    /**标题*/
    private String title;
    /**评论*/
    private String review;
    /**邮箱*/
    private String email;
    /**发送时间*/
    private Date postdate;
    /**删除状态*/
    private boolean deleteflag;
    /**修改人编号*/
    private int modifyuserno;
    /**修改时间*/
    private Date modifytime;

    public int getReviewno() {
        return reviewno;
    }

    public void setReviewno(int reviewno) {
        this.reviewno = reviewno;
    }

    public int getUserno() {
        return userno;
    }

    public void setUserno(int userno) {
        this.userno = userno;
    }

    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
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

    public int getChapterno() {
        return chapterno;
    }

    public void setChapterno(int chapterno) {
        this.chapterno = chapterno;
    }

    public String getChaptername() {
        return chaptername;
    }

    public void setChaptername(String chaptername) {
        this.chaptername = chaptername;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "Review{" +
                "reviewno=" + reviewno +
                ", userno=" + userno +
                ", loginid='" + loginid + '\'' +
                ", articleno=" + articleno +
                ", articlename='" + articlename + '\'' +
                ", chapterno=" + chapterno +
                ", chaptername='" + chaptername + '\'' +
                ", title='" + title + '\'' +
                ", review='" + review + '\'' +
                ", email='" + email + '\'' +
                ", postdate=" + postdate +
                ", deleteflag=" + deleteflag +
                ", modifyuserno=" + modifyuserno +
                ", modifytime=" + modifytime +
                '}';
    }
}
