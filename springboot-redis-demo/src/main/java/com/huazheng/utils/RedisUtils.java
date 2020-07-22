package com.huazheng.utils;

import com.huazheng.config.RedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Classname RedisUtils
 * @Description TODO
 * @Date 2020/7/22 15:03
 * @Created by zhanghuazheng
 */

@Component
public final class RedisUtils {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    /**
     * 设置过期时间
     * @param key
     * @param time
     * @return
     */
    public boolean experi(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }
}
