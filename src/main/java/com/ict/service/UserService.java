package com.ict.service;

import com.ict.entity.UserEntity;

/**
 * @Description: 用户业务方法接口
 * @Author wangsr
 * @Date 2021/2/19
 * @Version 1.0
 */
public interface UserService {
    UserEntity getByUserName(String userName);

    String login(String userName,String password);
}