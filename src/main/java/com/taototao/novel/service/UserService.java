package com.taototao.novel.service;

import com.taototao.novel.bean.UserSearchBean;
import com.taototao.novel.entity.User;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-21 13:06
 **/
public interface UserService {


    /**
     * 取得条件用户件数
     *
     * @param searchBean
     *            检索条件
     * @return 件数
     */
    int getCount(UserSearchBean searchBean);


    /**
     * 取得条件用户列表
     *
     * @param searchBean
     *            检索条件
     * @return 用户信息列表
     */
    List<User> find(UserSearchBean searchBean);

    /**
     *
     * @param user
     */
    void save(User user);

    /**
     * 根据用户编号获取用户信息
     * @param userno
     * @return
     */
    User getByNo(int userno);

    /**
     * 更新用户信息
     * @param user
     */
    void update(User user);

    /**
     * 删除用户信息
     * @param user
     */
    void delByNo(User user);
    /**
     * 根据帐号密码取得用户信息，如果取不到就返回NULL
     *
     * @param loginid
     *            用户ID
     * @param password
     *            密码
     * @return 用户信息
     */
    User findByLoginInfo(String loginid, String password);
}
