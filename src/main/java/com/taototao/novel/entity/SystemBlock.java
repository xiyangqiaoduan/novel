package com.taototao.novel.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author yangcb
 * @create 2017-07-12 17:56
 **/
public class SystemBlock implements Serializable {
    /**编号*/
    private int blockno;
    /**blockID*/
    private String blockid;
    /**区块名称*/
    private String blockname;
    /**类型*/
    private int type;
    /**类别*/
    private int category;
    /**sortcol*/
    private String sortcol;
    /**是否降序*/
    private boolean isasc;
    /**是否完成*/
    private boolean isfinish;
    /**限制数量*/
    private int limitnum;
    /**内容*/
    private String content;
    /**目标*/
    private int target;
    /**删除状态*/
    private boolean deleteflag;
    /**修改人编号*/
    private int modifyuserno;
    /**修改时间*/
    private Date modifytime;

    public int getBlockno() {
        return blockno;
    }

    public void setBlockno(int blockno) {
        this.blockno = blockno;
    }

    public String getBlockid() {
        return blockid;
    }

    public void setBlockid(String blockid) {
        this.blockid = blockid;
    }

    public String getBlockname() {
        return blockname;
    }

    public void setBlockname(String blockname) {
        this.blockname = blockname;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getSortcol() {
        return sortcol;
    }

    public void setSortcol(String sortcol) {
        this.sortcol = sortcol;
    }

    public boolean isIsasc() {
        return isasc;
    }

    public void setIsasc(boolean isasc) {
        this.isasc = isasc;
    }

    public boolean isIsfinish() {
        return isfinish;
    }

    public void setIsfinish(boolean isfinish) {
        this.isfinish = isfinish;
    }

    public int getLimitnum() {
        return limitnum;
    }

    public void setLimitnum(int limitnum) {
        this.limitnum = limitnum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public boolean isDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(boolean deleteflag) {
        this.deleteflag = deleteflag;
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
}
