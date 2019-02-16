/**
 * @Copyright (C) 2018 苏何丽自创有限公司
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 * @文件名称: QueryVo.java
 * @描述:
 * @创建人:苏何丽
 * @创建时间: 2019/1/6 17:10
 * @版本:
 */

package com.shl.entity;

import java.util.ArrayList;
import java.util.Date;

/**
 * @类功能说明:
 * @创建人: 苏何丽
 * @创建时间: 2019/1/6 17:10
 */
public class QueryVo {
    private User user;
    private Object[] ids;

    public Object[] getIds() {
        return ids;
    }

    public void setIds(Object[] ids) {
        this.ids = ids;
    }

    //查询开始时间
    private Date starDate;
    //结束时间
    private Date endDate;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getStarDate() {
        return starDate;
    }

    public void setStarDate(Date starDate) {
        this.starDate = starDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}