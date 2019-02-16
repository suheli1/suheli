/**
 * @Copyright (C) 2018 苏何丽自创有限公司
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 * @文件名称: UserMapper.java
 * @描述:
 * @创建人:苏何丽
 * @创建时间: 2019/1/5 16:30
 * @版本:
 */

package com.shl.dao;

import com.shl.entity.User;

import java.util.List;

/**
 *
 * @类功能说明:
 * @创建人: 苏何丽
 * @创建时间: 2019/1/5 16:30
 */
public interface UserMapper {
    public List<User> findAll();

}