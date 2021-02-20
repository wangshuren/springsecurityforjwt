package com.ict.entity;

import java.util.List;

/**
 * @Description: 用户信息实体
 * @Author wangsr
 * @Date 2021/2/19
 * @Version 1.0
 */
public class UserEntity {
    private  String userName;

    private String password;

    private List<String> authorities;

    public UserEntity(String userName, String password, List<String> authorities) {
        this.userName = userName;
        this.password = password;
        this.authorities = authorities;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}