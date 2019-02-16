/**
 * @Copyright (C) 2018 苏何丽自创有限公司
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 * @文件名称: TestUser.java
 * @描述:
 * @创建人:苏何丽
 * @创建时间: 2019/1/6 15:40
 * @版本:
 */

import com.shl.dao.AccountMapper;
import com.shl.entity.Account;
import com.shl.entity.User;
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
 * @类功能说明: ``````````
 * @创建人: 苏何丽
 * @创建时间: 2019/1/6 15:40
 */
public class TestAccount {
    private InputStream in;
    private SqlSession sqlSession;
    private AccountMapper mapper;

    @Before
    public void before() {
        try {
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            in = Resources.getResourceAsStream("sqlMapConfig.xml");
            SqlSessionFactory factory = builder.build(in);
            sqlSession = factory.openSession();
            mapper = sqlSession.getMapper(AccountMapper.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestFindAllAccount() {

        try {

            List<Account> accounts = mapper.findAllAccount();
            // System.out.println(accounts);
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }


    }

    @Test
    public void findById() {
        Account account = mapper.findById(1);
        System.out.println("-------------------------");
        Integer accountId = account.getAccountId();

        System.out.println(accountId);
        ///User user = account.getUser();
        ///System.out.println(user);
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