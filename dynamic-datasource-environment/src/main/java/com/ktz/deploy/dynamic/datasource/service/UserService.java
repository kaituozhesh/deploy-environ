package com.ktz.deploy.dynamic.datasource.service;


import com.ktz.deploy.dynamic.datasource.entity.SysUser;

/**
 * @author Zhao Wanzi
 */
public interface UserService {


    SysUser selectByPrimaryKey(Integer id);

}
