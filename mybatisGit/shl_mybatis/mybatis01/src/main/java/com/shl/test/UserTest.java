/**
 * @Copyright (C) 2018 苏何丽自创有限公司
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 * @文件名称: UserTest.java
 * @描述:
 * @创建人:苏何丽
 * @创建时间: 2019/1/5 17:04
 * @版本:
 */

package com.shl.test;

import com.shl.dao.UserMapper;
import com.shl.entity.User;
import com.sun.deploy.model.Resource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.ResourceBundle;

/**
 *
 * @类功能说明:
 * @创建人: 苏何丽
 * @创建时间: 2019/1/5 17:04
 */
public class UserTest {

    @Test
   public  void testFindAll(){
        try {
            InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> all = mapper.findAll();
            System.out.println(all);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}