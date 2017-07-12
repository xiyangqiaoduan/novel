package com.taototao.novel.entity;

import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-12 18:18
 **/
public class Message {

    /**消息编号*/
    private int messageno;
    /**用户编号*/
    private int userno;
    /**loginID*/
    private String loginid;
    /**接收人编号*/
    private int touserno;
    /**接受人loginID*/
    private String tologinid;
    /**标题*/
    private String title;
    /**内容*/
    private String content;

    private int category;
    private boolean isread;
    private Date postdate;
    private boolean deleteflag;
    private int modifyuserno;
    private Date modifytime;


    public int getMessageno() {
        return messageno;
    }

    public void setMessageno(int messageno) {
        this.messageno = messageno;
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

    public int getTouserno() {
        return touserno;
    }

    public void setTouserno(int touserno) {
        this.touserno = touserno;
    }

    public String getTologinid() {
        return tologinid;
    }

    public void setTologinid(String tologinid) {
        this.tologinid = tologinid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public boolean isIsread() {
        return isread;
    }

    public void setIsread(boolean isread) {
        this.isread = isread;
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
        return "Message{" +
                "messageno=" + messageno +
                ", userno=" + userno +
                ", loginid='" + loginid + '\'' +
                ", touserno=" + touserno +
                ", tologinid='" + tologinid + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", category=" + category +
                ", isread=" + isread +
                ", postdate=" + postdate +
                ", deleteflag=" + deleteflag +
                ", modifyuserno=" + modifyuserno +
                ", modifytime=" + modifytime +
                '}';
    }
}
