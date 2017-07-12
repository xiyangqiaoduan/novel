package com.taototao.novel.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-12 22:39
 **/
public class CreditHistory implements Serializable {

    /**编号*/
    private int credithistoryno;
    /**用户编号*/
    private int userno;
    /**loginid*/
    private String loginid;
    /**文章编号*/
    private int articleno;
    /**文章名称*/
    private String articlename;
    /**章节编号*/
    private int chapterno;
    /**章节名称*/
    private String chaptername;
    /**积分*/
    private int creditpoint;
    /**修改人编号*/
    private int modifyuserno;
    /**修改时间*/
    private Date modifytime;

    public int getCredithistoryno() {
        return credithistoryno;
    }

    public void setCredithistoryno(int credithistoryno) {
        this.credithistoryno = credithistoryno;
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

    public int getCreditpoint() {
        return creditpoint;
    }

    public void setCreditpoint(int creditpoint) {
        this.creditpoint = creditpoint;
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
        return "CreditHistory{" +
                "credithistoryno=" + credithistoryno +
                ", userno=" + userno +
                ", loginid='" + loginid + '\'' +
                ", articleno=" + articleno +
                ", articlename='" + articlename + '\'' +
                ", chapterno=" + chapterno +
                ", chaptername='" + chaptername + '\'' +
                ", creditpoint=" + creditpoint +
                ", modifyuserno=" + modifyuserno +
                ", modifytime=" + modifytime +
                '}';
    }
}
