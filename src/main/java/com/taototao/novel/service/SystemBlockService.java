package com.taototao.novel.service;

import com.taototao.novel.bean.SystemBlockSearchBean;
import com.taototao.novel.entity.SystemBlock;

import java.util.List;

/**
 *
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

    /**
     * 根据条件获取区块列表
     * @param searchBean
     * @return
     */
    List<SystemBlock> find(SystemBlockSearchBean searchBean);

    /**
     * 通过区块编号取得区块信息
     * @param blockNo
     *          区块编号
     * @return 区块详细
     */
    SystemBlock getByNo(int blockNo);
}
