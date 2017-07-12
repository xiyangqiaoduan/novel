package com.taototao.novel.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-12 17:35
 **/
public class User implements Serializable {
    /**用户编号*/
    private int userno;
    /**用户登录ID*/
    private String loginid;
    /**用户密码*/
    private String password;
    /**用户名称*/
    private String username;
    /**用户邮箱*/
    private String email;
    /**注册时间*/
    private Date regdate;
    /**性别*/
    private int sex;
    /**用户QQ*/
    private String qq;
    /**用户最后一次登录*/
    private Date lastlogin;
    /**访问次数*/
    private String lineno;
    /**用户类型*/
    private int type;
    /**投票次数*/
    private int votecount;
    /**用户状态*/
    private boolean deleteflag;
    /**用户真实名称*/
    private String realname;
    /**用户ID*/
    private String id;
    /**用户手机号*/
    private String mobileno;
    /**分支*/
    private String branch;
    /**账号*/
    private String bankno;
    /**阿里支付次数*/
    private String alipayacount;
    /**类型*/
    private int category;
    /**二级类型*/
    private int subcategory;
    /**修改人编号*/
    private int modifyuserno;
    /**修改时间*/
    private Date modifytime;
    /**openid*/
    private String openid;
    /**激活状态*/
    private boolean activedflag;
    /**邮件口令*/
    private String mailtoken;

    public int getUserno() {
        return userno;
    }

    public void setUserno(int userno) {
        this.userno = userno;
    }

    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Date getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Date lastlogin) {
        this.lastlogin = lastlogin;
    }

    public String getLineno() {
        return lineno;
    }

    public void setLineno(String lineno) {
        this.lineno = lineno;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getVotecount() {
        return votecount;
    }

    public void setVotecount(int votecount) {
        this.votecount = votecount;
    }

    public boolean isDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(boolean deleteflag) {
        this.deleteflag = deleteflag;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBankno() {
        return bankno;
    }

    public void setBankno(String bankno) {
        this.bankno = bankno;
    }

    public String getAlipayacount() {
        return alipayacount;
    }

    public void setAlipayacount(String alipayacount) {
        this.alipayacount = alipayacount;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(int subcategory) {
        this.subcategory = subcategory;
    }

    public int getModifyuserno() {
        return modifyuserno;
    }

    public void setModifyuserno(int modifyuserno) {
        this.modifyuserno = modifyuserno;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public boolean isActivedflag() {
        return activedflag;
    }

    public void setActivedflag(boolean activedflag) {
        this.activedflag = activedflag;
    }

    public String getMailtoken() {
        return mailtoken;
    }

    public void setMailtoken(String mailtoken) {
        this.mailtoken = mailtoken;
    }
}
