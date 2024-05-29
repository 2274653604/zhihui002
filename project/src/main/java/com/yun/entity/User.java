package com.yun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//对应数据库表
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private Integer id;
    private String username;
    private String password;


}
