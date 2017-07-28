package com.taototao.novel.service.impl;

import com.taototao.novel.bean.UserSearchBean;
import com.taototao.novel.dao.UserDao;
import com.taototao.novel.entity.User;
import com.taototao.novel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-21 13:06
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public int getCount(UserSearchBean searchBean) {
        return userDao.getCount(searchBean);
    }

    public List<User> find(UserSearchBean searchBean) {
        return userDao.find(searchBean);
    }

    public void save(User user) {
        userDao.save(user);
    }

    public User getByNo(int userno) {
        return userDao.getByNo(userno);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void delByNo(User user) {
        userDao.delByNo(user);
    }

    public User findByLoginInfo(String loginid, String password) {
        return userDao.findByLoginInfo(loginid,password);
    }
}
