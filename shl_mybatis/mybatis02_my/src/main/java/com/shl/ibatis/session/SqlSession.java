package com.shl.ibatis.session;

public interface SqlSession {
    <T> T getMapper(Class<T> tClass);
}
