package com.ktz.deploy.redisson.service.impl;

import com.ktz.deploy.redisson.config.RedissonConfig;
import com.ktz.deploy.redisson.service.OrderService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * ClassName: OrderServiceImpl
 * Description:
 * date: 2020/3/9 10:48
 *
 * @author kaituozhe_sh
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RedissonClient redissonClient;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String order() {
        RLock lock = redissonClient.getLock("lock");
        try {
            if (lock.tryLock(5, 2 * 60, TimeUnit.SECONDS)) {
                return this.decrementOrder();
            } else {
                System.out.println("锁获取超时(5s)");
                return "timeout";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        } finally {
            if (null != lock) {
                lock.unlock();
            }
        }
    }

    private String decrementOrder() {
        Long count = Long.valueOf(stringRedisTemplate.opsForValue().get("count"));
        if (count <= 0) {
            return "库存不足";
        } else {
            count = this.stringRedisTemplate.opsForValue().decrement("count");
        }
        System.out.println("==================库存还剩{" + count + "}个================");
        return String.valueOf(count);
    }
}
