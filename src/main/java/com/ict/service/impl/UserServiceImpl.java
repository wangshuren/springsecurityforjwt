package com.ict.service.impl;

import com.ict.entity.UserEntity;
import com.ict.service.UserService;
import com.ict.util.JwtUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 用户业务实现类
 * @Author wangsr
 * @Date 2021/2/19
 * @Version 1.0
 */

@Service
public class UserServiceImpl implements UserService {

    /**
     * 通过用户名获取用户信息
     * @param userName
     * @return
     */
    @Override
    public UserEntity getByUserName(String userName) {
        //这里应该要访问存储介质获取到用户信息的，但是这些步骤都是十分常规的操作，因此这里跳过，直接模拟了访问数据
        List<String> authorities=new ArrayList<>();
        authorities.add("ALL");
        UserEntity user=new UserEntity("pingwazi","123",authorities);
        return user;
    }

    /**
     * 用户登录，如果账号密码比对成功，就生成一个token串返回给前端
     * @param userName
     * @param password
     * @return
     */
    @Override
    public String login(String userName, String password) {
        //这里应该要访问存储介质获取到用户信息的，但是这些步骤都是十分常规的操作，因此这里跳过，直接模拟了访问数据
        if("pingwazi".equals(userName) && "123".equals(password))
        {
            return JwtUtils.createJwtToken(userName);
        }
        return "";
    }
}