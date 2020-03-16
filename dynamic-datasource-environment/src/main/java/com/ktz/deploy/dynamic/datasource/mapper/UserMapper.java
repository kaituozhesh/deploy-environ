package com.ktz.deploy.dynamic.datasource.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.ktz.deploy.dynamic.datasource.entity.SysUser;

@DS("lanhuapp-test")
public interface UserMapper {

    SysUser selectByPrimaryKey(Integer id);
}
