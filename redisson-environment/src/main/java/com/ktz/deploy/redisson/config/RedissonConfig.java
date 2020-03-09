package com.ktz.deploy.redisson.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * ClassName: RedissonConfig
 * Description:
 * date: 2020/3/9 10:31
 *
 * @author kaituozhe_sh
 */
@Configuration
public class RedissonConfig {

    @Autowired
    private RedisProperties redisProperties;

    @Value("${spring.redis.pattern}")
    private String pattern;

    @Bean
    public RedissonClient getRedisson() {
        Config config = new Config();
        if ("single".equals(pattern)) {
            StringBuilder builder = new StringBuilder("redis://");
            builder.append(redisProperties.getHost())
                    .append(":")
                    .append(redisProperties.getPort());
            config.useSingleServer()
                    .setAddress(builder.toString())
                    .setPassword(redisProperties.getPassword())
                    .setDatabase(redisProperties.getDatabase());
        } else if ("cluster".equals(pattern)) {
            RedisProperties.Cluster cluster = redisProperties.getCluster();
            List<String> nodes = cluster.getNodes();
            String[] strings = listToArray(nodes);
            config.useClusterServers()
                    .setScanInterval(2000)
                    .addNodeAddress(strings)
                    .setPassword(redisProperties.getPassword());
        }
        return Redisson.create(config);
    }

    private String[] listToArray(List<String> list) {
        if (null == list || list.size() <= 0) {
            return new String[0];
        }
        String[] r = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            r[i] = "redis://" + list.get(i);
        }
        return r;
    }
}
