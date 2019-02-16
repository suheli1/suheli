/**
 * @Copyright (C) 2018 苏何丽自创有限公司
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 * @文件名称: DefaultSqlSession.java
 * @描述:
 * @创建人:苏何丽
 * @创建时间: 2019/1/5 18:24
 * @版本:
 */

package com.shl.ibatis.session;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 *
 * @类功能说明:
 * @创建人: 苏何丽
 * @创建时间: 2019/1/5 18:24
 */
public class DefaultSqlSession implements SqlSession {
    //获得userDao代理对象
    public <T> T getMapper(Class<T> tClass) {

        return  (T)Proxy.newProxyInstance(this.getClass().getClassLoader(),
                 new Class[]{tClass},
                new MapperProxy());
    }



}