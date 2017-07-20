package com.taototao.novel.dao;

import com.taototao.novel.bean.SystemBlockSearchBean;
import com.taototao.novel.entity.SystemBlock;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-14 9:46
 **/
public interface SystemBlockDao {
    /**
     * 获取区块件数
     * @param searchBean
     *          检索条件
     * @return 区块件数
     */
    Integer getCount(SystemBlockSearchBean searchBean);

    /**
     * 通过条件查找区块信息列表
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

    /**
     * 新增区块
     * @param systemBlock
     */
    void save(SystemBlock systemBlock);

    /**
     * 更新区块
     * @param systemBlock
     */
    void update(SystemBlock systemBlock);
}
