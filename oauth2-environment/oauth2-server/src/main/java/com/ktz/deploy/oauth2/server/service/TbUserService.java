package com.ktz.deploy.oauth2.server.service;


import com.ktz.deploy.oauth2.server.domain.TbUser;

public interface TbUserService{

    TbUser getByUsername(String username);

}
