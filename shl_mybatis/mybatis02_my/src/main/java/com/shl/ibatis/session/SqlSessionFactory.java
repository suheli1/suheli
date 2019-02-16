package com.shl.ibatis.session;

public class SqlSessionFactory {
    public SqlSession openSession(){
        return new DefaultSqlSession();
    }
}
