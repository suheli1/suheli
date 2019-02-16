package com.shl.dao;

import com.shl.entity.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountMapper {
    @Select("select *  from account")
    @Results({
            @Result(property = "id",column = "id"),
           // @Result(property = "uid",column = "uid"),
            @Result(property = "user",column = "uid",
                    one = @One(select ="com.shl.dao.UserMapper.findById",fetchType = FetchType.LAZY)),
    }
    )
    public List<Account> findAllAccount();

    @Select("select * from account where accountId=#{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "uid",column = "uid"),
            @Result(property = "user",column = "uid",
                    one = @One(select = "com.shl.dao.UserMapper.findById",fetchType = FetchType.LAZY))
    })
    public Account findById(int id);
}
