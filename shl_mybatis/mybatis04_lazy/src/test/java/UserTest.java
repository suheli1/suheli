
import java.util.Date;/**
 * @Copyright (C) 2018 苏何丽自创有限公司
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 * @文件名称: UserTest.java
 * @描述:
 * @创建人:苏何丽
 * @创建时间: 2019/1/9 15:41
 * @版本:
 */

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

import javax.xml.bind.SchemaOutputResolver;
import java.io.InputStream;
import java.util.List;

/**
 *
 * @类功能说明:  用户测试类
 * @创建人: 苏何丽
 * @创建时间: 2019/1/9 15:41
 */
public class UserTest {
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

    @Test
    public void select(){
        List<User> userList = mapper.findAll();
        System.out.println(userList);
    }

    @Test
    public void update(){
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setId(41);
        user.setUsername("sqm");
        queryVo.setUser(user);
        mapper.updateById(queryVo);

    }

    @Test
    public void insert(){
        User user = new User();
        user.setId(0);
        user.setUsername("nishishui");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("广州");
        mapper.saveUser(user);

    }


    @Test
    public void delete(){
        mapper.deleteUser(65);
    }

    @Test
    public void findByCondition(){
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername("shl");
        queryVo.setUser(user);
        queryVo.setEndDate(new Date());
        List<User> users = mapper.findByCondition(queryVo);
        System.out.println(users);
    }

    @Test
    public  void findAllAccount(){
        User user = mapper.findById(46);
        System.out.println(user);
    }
    @After
    public void close() {

        try {
            sqlSession.commit(true);
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