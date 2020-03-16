package com.ktz.deploy.bcrypt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncoderController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private static String oldPassword;

    /**
     * 加密
     *
     * @param password
     * @return
     */
    @GetMapping("/encoder")
    public String encoder(@RequestParam String password) {
        oldPassword = bCryptPasswordEncoder.encode(password);
        return oldPassword;
    }

    /**
     * 判断密码是否一致   无需手动解密
     *
     * @param password
     * @return
     */
    @GetMapping("/un_encoder")
    public boolean unEncoder(@RequestParam String password) {
        return bCryptPasswordEncoder.matches(password, oldPassword);
    }
}
