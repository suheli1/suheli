/**
 * @Copyright (C) 2018 苏何丽自创有限公司
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 * @文件名称: Account.java
 * @描述:
 * @创建人:苏何丽
 * @创建时间: 2019/1/8 17:17
 * @版本:
 */

package com.shl.entity;

/**
 * @类功能说明:
 * @创建人: 苏何丽
 * @创建时间: 2019/1/8 17:17
 */
public class Account {

    private Integer accountId;
    private Integer uid;
    private Double money;
    // 账户关联用户,一对一关系(association)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}