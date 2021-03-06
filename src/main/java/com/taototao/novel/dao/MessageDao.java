package com.taototao.novel.dao;

import com.taototao.novel.bean.MessageSearchBean;
import com.taototao.novel.entity.Message;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-13 17:45
 **/
public interface MessageDao {
    /**
     * 根据条件取得消息件数
     *
     * @param searchBean
     *            检索条件
     * @return 消息件数
     */
    int getCount(MessageSearchBean searchBean);

    /**
     * 根据条件取得消息列表
     *
     * @param searchBean
     *            检索条件
     * @return 消息列表
     */
    List<Message> find(MessageSearchBean searchBean);

    /**
     * 根据消息编号删除消息
     * @param message
     */
    void deleteByNo(Message message);
}
