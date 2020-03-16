/**
 * Copyright 2020 the original author or authors.
 */
package com.ktz.deploy.dynamic.datasource.service.impl;


import com.ktz.deploy.dynamic.datasource.entity.SysUser;
import com.ktz.deploy.dynamic.datasource.mapper.UserMapper;
import com.ktz.deploy.dynamic.datasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Zhao Wanzi
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public SysUser selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }


}
