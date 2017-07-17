package com.taototao.novel.service;

import com.taototao.novel.bean.SystemBlockSearchBean;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-17 17:58
 **/
public interface SystemBlockService {
    /**
     * 根据条件取得区块件数
     *
     * @param searchBean
     *            检索条件
     * @return 区块件数
     */
    Integer getCount(SystemBlockSearchBean searchBean);





}
