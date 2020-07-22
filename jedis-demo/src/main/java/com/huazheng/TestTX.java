package com.huazheng;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @Classname TestTX
 * @Description TODO
 * @Date 2020/7/22 14:23
 * @Created by zhanghuazheng
 */
public class TestTX {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        JSONObject json = new JSONObject();
        json.put("name","zhanghauzheng");
        json.put("age",12);

        //测试是否连通
        System.out.println(jedis.ping());
        jedis.flushDB();
        //开启事务
        Transaction multi = jedis.multi();
        String result = json.toJSONString();

        try {
            multi.set("user1",result);
            multi.set("user2",result);
            int m= 1/0;
            multi.exec();
        } catch (Exception e) {
            e.printStackTrace();
            multi.discard();
            System.out.println(e);
        } finally {
            String user1 = jedis.get("user1");
            System.out.println(user1);

            String user2 = jedis.get("user2");
            System.out.println(user2);
            jedis.close();
        }


        System.out.println();
    }
}
