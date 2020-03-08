package com.ktz.deploy.redis.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.PostConstruct;
import java.io.Serializable;

/**
 * ClassName: RedisConfig
 * Description:
 * date: 2020/3/8 11:07
 *
 * @author kaituozhe_sh
 */
@Configuration
public class RedisConfig {
    /**
     * 方式一：
     * 默认情况下RedisTemplate模板只能支持字符串，我们自定义一个RedisTemplate，设置序列化器，这样我们可以很方便的操作实例对象
     *
     * @param connectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<String, Serializable> redisTemplate(LettuceConnectionFactory connectionFactory) {
        RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }


    @Autowired
    protected RedisTemplate redisTemplate;
    @Autowired
    protected RedisConnectionFactory factory;

    /**
     * 方式二：
     *
     * @PostConstruct：用来修饰非静态void()方法。被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器执行一次。PostConstruct在构造函数之后执行，init()方法之前执行 通常我们会是在Spring框架中使用到@PostConstruct注解，该注解的方法在整个Bean初始化中的执行顺序
     * Constructor（构造方法） ->  @Autowired（依赖注入）  ->  @PostConstruct（注解的方法）
     */
    @PostConstruct
    public void init() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new FastJsonRedisSerializer<>(Object.class));
        redisTemplate.setHashKeySerializer(new FastJsonRedisSerializer<>(Object.class));
        redisTemplate.setConnectionFactory(factory);
    }
}
