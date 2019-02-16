package com.shl.dao;

import com.shl.entity.QueryVo;
import com.shl.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    @Select("select * from USER ")
    List<User> findAll();

    @Update("update user SET username=#{user.username} where id =#{user.id}")
    void updateById(QueryVo queryVo);

    //保存
    @Insert("insert into user(username,birthday,sex,address) VALUE (#{username},#{birthday},#{sex},#{address})")
    void saveUser(User user);

    //删除
    @Delete("delete from user where id =#{id}")
    void deleteUser(int id);

    //根据生日的时间间隔查询(多条件查询)
   /* @Select("<script>select * from user  <where> " +
            " <if test=\"user!=null and user.username !=''\">\n" +
            "   and username =#{user.username}\n" +
            "   </if>\n" +
            "   <if test=\"starDate !=null\">\n" +
            "   and birthday>=#{starDate}\n" +
            "   </if>\n" +
            "    <if test=\"endDate !=null\">\n" +
            "     and birthday&lt;=#{endDate}\n" +
            "     </if></where> </script>")*/
    List<User> findByCondition(QueryVo queryVo);

    //模糊查询
    List<User> findByUsernameLike(String username);

    List<User> findByUsernameLikeNotSecurity(String username);

    //resultMap的介绍
    List<User> findAllToMap();

    //查询返回主键
     int findReturnId(User user);

     @Select("select * from user where id=#{id}")
     User findById(int id);


}
