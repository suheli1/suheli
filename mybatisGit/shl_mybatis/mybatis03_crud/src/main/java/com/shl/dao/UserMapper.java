package com.shl.dao;

import com.shl.entity.QueryVo;
import com.shl.entity.User;
import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.USER_EXCEPTION;

import java.util.List;

public interface UserMapper {

    List<User> findAll();

    /*void updateById(@Param("id") int id,@Param("username") String username);*/
    //更新
    void updateById(QueryVo queryVo);

    //保存
    void saveUser(User user);

    //删除
    void deleteUser(int id);

    //根据生日的时间间隔查询(多条件查询)
    List<User> findByCondition(QueryVo queryVo);

    //模糊查询
    List<User> findByUsernameLike(String username);

    List<User> findByUsernameLikeNotSecurity(String username);

    //resultMap的介绍
    List<User> findAllToMap();

    //查询返回主键
     int findReturnId(User user);


}
