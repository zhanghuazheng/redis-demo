package com.huazheng;

import redis.clients.jedis.Jedis;

/**
 * @Classname JedisDemo
 * @Description TODO
 * @Date 2020/7/22 14:10
 * @Created by zhanghuazheng
 */
public class JedisDemo {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set("name","zhanghuazheng");
        System.out.println(jedis.get("name"));

        System.out.println(jedis.keys("*"));


        System.out.println(jedis.ping());
    }
}
