package com.springtest.redis;

import com.springtest.redis.model.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

/**
 * @author admin
 * @date 2019/8/7 0:25
 */
public class JedisOperationTest {
    public static void main(String[] args) {
        /*ApplicationContext ac = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        RedisTemplate redisTemplate = (RedisTemplate)ac.getBean(RedisTemplate.class);
        Role role = new Role();
        role.setId(2L);
        role.setRoleName("角色名称");

        SessionCallback callback = new SessionCallback() {
            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                operations.boundValueOps("role_2").set(role);
                Role role1 = (Role)operations.boundValueOps("role_2").get();
                return role1;
            }
        };
        Role saveRole = (Role)redisTemplate.execute(callback);
        System.out.println(saveRole.getId()+","+saveRole.getRoleName());*/
        String s = "abcbaerf";
        StringBuilder builder = new StringBuilder(s);
        System.out.println(builder.reverse().toString());

        StringBuffer buffer = new StringBuffer(s);
        System.out.println(buffer.reverse().toString());
    }
}
