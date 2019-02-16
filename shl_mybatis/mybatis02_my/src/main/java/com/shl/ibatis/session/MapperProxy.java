/**
 * @Copyright (C) 2018 苏何丽自创有限公司
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 * @文件名称: MapperProxy.java
 * @描述:
 * @创建人:苏何丽
 * @创建时间: 2019/1/5 18:43
 * @版本:
 */

package com.shl.ibatis.session;

import com.shl.ibatis.config.Config;
import com.shl.ibatis.config.Mapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 *
 * @类功能说明:
 * @创建人: 苏何丽
 * @创建时间: 2019/1/5 18:43
 */
public class MapperProxy  implements InvocationHandler{


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName(); //方法名
        String pathName = method.getDeclaringClass().getName();
        // TODO: 2019/1/5  可以通过获得id.遍历执行,通过判断符合的方法执行相应的业务逻辑
        //这里先写死
        if ("findAll".equals(name)){
            Config config = Config.getConfig();
            Map<String, Mapper> mapper = config.getMapper();
            //获取sql,使用druid的连接池
            Class<?>[] declaredClasses = method.getReturnType().getDeclaredClasses();



        }


        return null;
    }
}