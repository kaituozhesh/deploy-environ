package com.ktz.deploy.oauth2.server.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ClassName WebSecurityConfiguration
 * @Description 服务器安全配置
 * @Author kaituozhesh
 * @Date 2020/3/16 14:20
 * @Version V1.0
 **/
@Configuration
@EnableWebSecurity
// 全局方法拦截
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * 配置默认加密方式
     * 通过浏览器访问
     * http://localhost:8080/oauth/authorize?client_id=client&response_type=code
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 在内存中创建用户
        auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("123456")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("admin888")).roles("ADMIN");
    }
}
