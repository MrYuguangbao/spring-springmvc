package com.springtest.redis.pipeline;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 使用pipeline测试性能
 * @author admin
 * @date 2020/4/9 11:04
 */
public class RedisPipeLineHandler {

    public void compare(){
        Jedis jedis = new Jedis("127.0.0.1",6379,100000);
        jedis.select(0);
        jedis.flushDB();
        Map<String,String> map = new ConcurrentHashMap<>();

        /*-----------------------------------------存储值-----------------------------------------*/

        Long start = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            map.clear();
            map.put("k_"+i,"v_"+i);
            jedis.hmset("hash_key_"+i,map);
        }
        System.out.println("未使用pipeline,通过 hmset 插入"+jedis.dbSize()+"条数据,耗时:"+(System.currentTimeMillis()-start));

        //使用pipeline
        jedis.select(0);
        jedis.flushDB();
        Pipeline pipelined = jedis.pipelined();
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            map.clear();
            map.put("k_"+i,"v_"+i);
            //此时命令并未执行
            pipelined.hmset("hash_key_"+i,map);
        }
        pipelined.sync();//将封装后的pipeline一次性发给redis服务器
        System.out.println("使用pipeline,通过 hmset 插入"+jedis.dbSize()+"条数据,耗时:"+(System.currentTimeMillis()-start));

        /*-----------------------------------------查询值-----------------------------------------*/
        Map<String,Map<String,String>> resultMap = new ConcurrentHashMap<>();
        Set<String> keys = jedis.keys("hash_key_*");
        /*start = System.currentTimeMillis();
        for (String key : keys) {
            resultMap.put(key,jedis.hgetAll(key));
        }
        System.out.println("未使用pipeline,通过 hgetAll 查询"+jedis.dbSize()+"条数据,耗时:"+(System.currentTimeMillis()-start));*/

        //使用Pipeline查询
        resultMap.clear();
        for (String key : keys) {
            pipelined.hgetAll(key);
        }
        //提交至redis查询
        pipelined.sync();
        System.out.println("使用pipeline,通过 hgetAll 查询"+jedis.dbSize()+"条数据,耗时:"+(System.currentTimeMillis()-start));

        System.out.println("redis连接关闭");
        jedis.disconnect();

    }

    public void pipelineDelExecutor(){
        Jedis jedis = new Jedis("127.0.0.1",6379,100000);
        jedis.select(0);
        jedis.flushDB();
        List<String> keys = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            keys.add("str_"+i);
        }

        Pipeline pipelined = jedis.pipelined();
        for (String key : keys) {
            pipelined.del(key);
        }
        pipelined.sync();
        System.out.println("通过pipeline删除key,返回："+jedis.keys("*"));
    }

    public void pipelineAsyncAll(){
        Jedis jedis = new Jedis("127.0.0.1",6379,100000);
        Pipeline pipelined = jedis.pipelined();
        pipelined.multi();
        pipelined.set("name","rrredis");
        pipelined.incr("age");
        pipelined.get("name");
        pipelined.discard();

        List<Object> objects = pipelined.syncAndReturnAll();
        for (Object object : objects) {
            System.out.println(object);
        }

        jedis.disconnect();

    }


    public static void main(String[] args) {
        RedisPipeLineHandler handler = new RedisPipeLineHandler();
        //handler.compare();
        //handler.pipelineDelExecutor();
        handler.pipelineAsyncAll();

    }

}
