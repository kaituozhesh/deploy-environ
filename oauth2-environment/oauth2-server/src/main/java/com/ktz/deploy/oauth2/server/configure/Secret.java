package com.ktz.deploy.oauth2.server.configure;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ClassName Secret
 * @Description
 * @Author kaituozhesh
 * @Date 2020/3/16 15:20
 * @Version V1.0
 **/
public class Secret {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("secret"));
    }
}
