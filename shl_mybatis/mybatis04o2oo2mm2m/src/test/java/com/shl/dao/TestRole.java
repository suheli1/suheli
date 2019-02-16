/**
 * @Copyright (C) 2018 苏何丽自创有限公司
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 * @文件名称: TestRole.java
 * @描述:
 * @创建人:苏何丽
 * @创建时间: 2019/1/8 20:57
 * @版本:
 */

package com.shl.dao;

import com.shl.entity.Account;
import com.shl.entity.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 *
 * @类功能说明:
 * @创建人: 苏何丽
 * @创建时间: 2019/1/8 20:57
 */
public class TestRole {
    private InputStream in;
    private SqlSession sqlSession;
    private RoleMapper mapper;

    @Before
    public void before() {
        try {
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            in = Resources.getResourceAsStream("sqlMapConfig.xml");
            SqlSessionFactory factory = builder.build(in);
            sqlSession = factory.openSession();
            mapper = sqlSession.getMapper(RoleMapper.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestFindAllRole(){

        try {

            List<Role> roles = mapper.findAllRole();
            System.out.println(roles);

            sqlSession.commit(true);

        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }


    }




    @After
    public void close() {
        try {
            if (sqlSession != null) {

                sqlSession.close();
            }
            if (in != null) {

                in.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}