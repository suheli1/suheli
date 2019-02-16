/**
 * @Copyright (C) 2018 苏何丽自创有限公司
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 * @文件名称: TestUser.java
 * @描述:
 * @创建人:苏何丽
 * @创建时间: 2019/1/6 15:40
 * @版本:
 */

package com.shl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import com.shl.dao.UserMapper;
import com.shl.entity.QueryVo;
import com.shl.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @类功能说明:  ``````````
 * @创建人: 苏何丽
 * @创建时间: 2019/1/6 15:40
 */
public class TestUser {
    private InputStream in;
    private SqlSession sqlSession;
    private UserMapper mapper;

    @Before
    public void before() {
        try {
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            in = Resources.getResourceAsStream("sqlMapConfig.xml");
            SqlSessionFactory factory = builder.build(in);
            sqlSession = factory.openSession();
            mapper = sqlSession.getMapper(UserMapper.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //测试查询所有
    @Test
    public void testFindAll() {
        List<User> userList = mapper.findAll();
        System.out.println(userList);
    }

    //测试更新
    @Test
    public void testUpdateById() {
        try {
            QueryVo queryVo = new QueryVo();
            User user = new User();
            user.setUsername("shl");
            user.setSex("女");
           // user.setId(62);
            /*集合*/
           ArrayList<Object> ids = new ArrayList<>();
            /*id为数组*/
            ids.add(42);
            ids.add(45);
            Object[] idArray = ids.toArray();
            queryVo.setUser(user);
            queryVo.setIds(idArray);
            mapper.updateById(queryVo);
            sqlSession.commit(true);

        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }
    }
    //测试保存
    @Test
    public void testSave() {
        try {
            User user = new User();
            user.setId(0);
            user.setUsername("shl");
            Date date = new Date();
            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
            System.out.println(format);
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(format));
            user.setSex("女");
            user.setAddress("广州");
            mapper.saveUser(user);
            sqlSession.commit(true);
        } catch (ParseException e) {
            e.printStackTrace();
            sqlSession.rollback();
        }
    }

    //测试删除
    @Test
    public void testDeleteUser() {
        try {
            mapper.deleteUser(41);
            sqlSession.commit(true);
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }
    }

    //根据时间差多条件查询
    @Test
    public void testFindByCondition() {
        try {
            QueryVo queryVo = new QueryVo();
            User user = new User();
            user.setUsername("suheli");
            queryVo.setUser(user);
           // queryVo.setStarDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-03-02 00:00:00"));
            queryVo.setEndDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-03-04 23:00:00"));

            List<User> queryVoList = mapper.findByCondition(queryVo);
            System.out.println(queryVoList);
            sqlSession.commit(true);
        } catch (ParseException e) {
            e.printStackTrace();
            sqlSession.rollback();
        }
    }

    //防止注入的SQL的方法
    @Test
    public void findByUsernamelike() {
        List<User> userList = mapper.findByUsernameLike("%s%");
        System.out.println(userList);
    }

    //无法防止注入的方法
    @Test
    public void testFindByUsernameLikeNotSecurity() {
        List<User> userslist = mapper.findByUsernameLikeNotSecurity("' or 1=1 -- ");

        System.out.println(userslist);
    }

    //测试resultMap地数据的封装
    @Test
    public void testFindAllToMap() {
        List<User> allToMap = mapper.findAllToMap();
        System.out.println(allToMap);
    }

    @Test
    public void testFindReturnId() {
        try {
            User user = new User();
            user.setId(0);
            user.setUsername("suheli");
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-12--22 22:00:00"));
            user.setSex("女");
            user.setAddress("深圳");
            System.out.println("保存前:" + user);
            int returnId = mapper.findReturnId(user);

            System.out.println(returnId);

            sqlSession.commit(true);
            System.out.println("保存后:" + user);

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