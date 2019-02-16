/**
 * @Copyright (C) 2018 苏何丽自创有限公司
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 * @文件名称: UserTest.java
 * @描述:
 * @创建人:苏何丽
 * @创建时间: 2019/1/5 17:04
 * @版本:
 */

import com.shl.dao.UserMapper;
import com.shl.entity.User;
import com.shl.ibatis.session.SqlSession;
import com.shl.ibatis.session.SqlSessionFactory;
import org.junit.Test;

/**
 *
 * @类功能说明:
 * @创建人: 苏何丽
 * @创建时间: 2019/1/5 17:04
 */
public class UserTest {
    @Test
   public  void testFindAll(){

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //反向代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.findAll();
    }

}