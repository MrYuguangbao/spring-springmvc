package com.springtest.redis;

import com.springtest.redis.model.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import redis.clients.jedis.Jedis;

/**
 * @author admin
 * @date 2019/8/6 23:30
 */
public class JedisTest {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        RedisTemplate redisTemplate = ac.getBean(RedisTemplate.class);
        Role role = new Role();
        role.setId(1L);
        role.setRoleName("roledddd");
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("role_1", role);
        System.out.println("存入redis成功");
        Role role1 = (Role) valueOperations.get("role_1");
        System.out.println(role1.getRoleName());

    }


}
