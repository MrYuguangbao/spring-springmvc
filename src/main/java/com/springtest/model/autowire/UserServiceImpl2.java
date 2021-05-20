package com.springtest.model.autowire;

import com.springtest.model.CusRole;
import com.springtest.model.annotation.pojo.Role;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @date 2020/1/6 19:37
 */
@Component("service2")
@Primary
public class UserServiceImpl2 implements UserService {


    @Override
    public void printUserInfo(Role role) {
        System.out.println("userserviceimpl2");
    }

    @Override
    public Role getRole(long id) {
        return null;
    }
}
