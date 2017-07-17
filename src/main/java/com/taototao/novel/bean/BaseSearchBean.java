package com.taototao.novel.bean;

import com.taototao.novel.utils.Pagination;

/**
 * 检索条件基类
 * @author yangcb
 * @create 2017-07-17 17:08
 **/
public class BaseSearchBean {

    /**翻页信息*/
    private Pagination pagination;


    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
