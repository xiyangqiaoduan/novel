package com.taototao.novel.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-12 22:50
 **/
public class Bookcase implements Serializable {
    /**书架编号*/
    private int bookcaseno;
    /**文章编号*/
    private int articleno;
    /**文章名称*/
    private String articlename;
    /**文章分类*/
    private int category;
    /**用户编号*/
    private int userno;
    /**用户名称*/
    private String username;
    /**章节编号*/
    private int chapterno;
    /**章节名称*/
    private String chaptername;
    /**最后访问时间*/
    private Date lastvisit;
    /**创建时间*/
    private Date createtime;
    /**删除状态*/
    private boolean deleteflag;
    /**修改人编号*/
    private int modifyuserno;
    /**修改时间*/
    private Date modifytime;


    public int getBookcaseno() {
        return bookcaseno;
    }

    public void setBookcaseno(int bookcaseno) {
        this.bookcaseno = bookcaseno;
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

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getUserno() {
        return userno;
    }

    public void setUserno(int userno) {
        this.userno = userno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Date getLastvisit() {
        return lastvisit;
    }

    public void setLastvisit(Date lastvisit) {
        this.lastvisit = lastvisit;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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
        return "Bookcase{" +
                "bookcaseno=" + bookcaseno +
                ", articleno=" + articleno +
                ", articlename='" + articlename + '\'' +
                ", category=" + category +
                ", userno=" + userno +
                ", username='" + username + '\'' +
                ", chapterno=" + chapterno +
                ", chaptername='" + chaptername + '\'' +
                ", lastvisit=" + lastvisit +
                ", createtime=" + createtime +
                ", deleteflag=" + deleteflag +
                ", modifyuserno=" + modifyuserno +
                ", modifytime=" + modifytime +
                '}';
    }
}
