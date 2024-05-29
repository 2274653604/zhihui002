package com.yun.dao;

import com.yun.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


//操作数据库
@Mapper //注入到spring容器
public interface UserMapper {
    @Insert("insert into user(username, password) " +
            "values (#{username}, #{password})")
    void insert(User user);

    @Select("select * from `user` where username = #{username} order by id desc")
    User selectByUsername(String username);

}
