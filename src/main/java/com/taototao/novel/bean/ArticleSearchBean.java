package com.taototao.novel.bean;

import java.util.Date;

/**
 * 小说搜索条件
 *
 * @author yangcb
 * @create 2017-07-19 11:09
 **/
public class ArticleSearchBean extends BaseSearchBean {


    private int articleno;
    private Date lastupdate;
    private String articlename;
    private String keywords;
    private int authorid;
    private String author;
    private int category;
    private boolean fullflag;

    private String key;

    private String articlenos;

    private int pageType;

    private int fromArticleno;

    private String pinyin;

    private String tag;

    public int getArticleno() {
        return articleno;
    }

    public void setArticleno(int articleno) {
        this.articleno = articleno;
    }

    public Date getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(Date lastupdate) {
        this.lastupdate = lastupdate;
    }

    public String getArticlename() {
        return articlename;
    }

    public void setArticlename(String articlename) {
        this.articlename = articlename;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getAuthorid() {
        return authorid;
    }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public boolean getFullflag() {
        return fullflag;
    }

    public void setFullflag(boolean fullflag) {
        this.fullflag = fullflag;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getArticlenos() {
        return articlenos;
    }

    public void setArticlenos(String articlenos) {
        this.articlenos = articlenos;
    }

    public int getPageType() {
        return pageType;
    }

    public void setPageType(int pageType) {
        this.pageType = pageType;
    }

    public int getFromArticleno() {
        return fromArticleno;
    }

    public void setFromArticleno(int fromArticleno) {
        this.fromArticleno = fromArticleno;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "ArticleSearchBean{" +
                "articleno=" + articleno +
                ", lastupdate=" + lastupdate +
                ", articlename='" + articlename + '\'' +
                ", keywords='" + keywords + '\'' +
                ", authorid=" + authorid +
                ", author='" + author + '\'' +
                ", category=" + category +
                ", fullflag=" + fullflag +
                ", key='" + key + '\'' +
                ", articlenos='" + articlenos + '\'' +
                ", pageType=" + pageType +
                ", fromArticleno=" + fromArticleno +
                ", pinyin='" + pinyin + '\'' +
                ", tag='" + tag + '\'' + getPagination() +
                '}';
    }

    public class PageType {
        public static final int publicPage = 1;
        public static final int authorPage = 2;
        public static final int adminPage = 3;
    }

}
