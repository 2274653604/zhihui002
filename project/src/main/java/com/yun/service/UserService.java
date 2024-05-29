package com.yun.service;

import com.yun.entity.User;
import com.yun.exception.ServiceException;
import com.yun.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //注入到spring容器里
public class UserService {

    @Autowired
    UserMapper userMapper;

//验证用户账户是否合法
    public User login(User user) {
        // 根据用户名查询数据库的用户信息
        User dbUser = userMapper.selectByUsername(user.getUsername());
        if (dbUser == null) {
            // 抛出一个自定义的异常
            throw new ServiceException("用户名错误");
        }
        if (!user.getPassword().equals(dbUser.getPassword())) {
            throw new ServiceException("密码错误");
        }
        return dbUser;
    }

    public User register(User user) {
        User dbUser = userMapper.selectByUsername(user.getUsername());
        if (dbUser != null) {
            throw new ServiceException("用户名已存在");
        }
        userMapper.insert(user);
        return user;
    }

}




