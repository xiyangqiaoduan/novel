package com.taototao.novel.entity;

import java.io.Serializable;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-12 17:31
 **/
public class Subscribe implements Serializable {
    /**订阅编号*/
    private int subscribeno;
    /**用户编号*/
    private int userno;
    /**文章编号*/
    private int articleno;


    public int getSubscribeno() {
        return subscribeno;
    }

    public void setSubscribeno(int subscribeno) {
        this.subscribeno = subscribeno;
    }

    public int getUserno() {
        return userno;
    }

    public void setUserno(int userno) {
        this.userno = userno;
    }

    public int getArticleno() {
        return articleno;
    }

    public void setArticleno(int articleno) {
        this.articleno = articleno;
    }

    @Override
    public String toString() {
        return "Subscribe{" +
                "subscribeno=" + subscribeno +
                ", userno=" + userno +
                ", articleno=" + articleno +
                '}';
    }
}
