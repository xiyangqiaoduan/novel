package com.taototao.novel.service.impl;

import com.taototao.novel.bean.MessageSearchBean;
import com.taototao.novel.dao.MessageDao;
import com.taototao.novel.entity.Message;
import com.taototao.novel.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-21 15:47
 **/
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    public int getCount(MessageSearchBean searchBean) {
        return messageDao.getCount(searchBean);
    }

    public List<Message> find(MessageSearchBean searchBean) {

        return  messageDao.find(searchBean);
    }

    public void deleteByNo(Message message) {
        messageDao.deleteByNo(message);
    }
}
