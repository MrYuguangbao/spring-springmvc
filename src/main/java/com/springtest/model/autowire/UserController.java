package com.springtest.model.autowire;

import com.springtest.model.CusRole;
import com.springtest.model.annotation.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * @author admin
 * @date 2020/1/6 19:38
 */
@Component
public class UserController {

    @Autowired
    @Qualifier(value = "prop")
    private Properties props;

    private UserService userService;

    public UserController(@Autowired @Qualifier(value = "service1") UserService userService) {
        this.userService = userService;
    }

    public void printUser(Role role) {
        System.out.println("注入的props:" + props);
        userService.printUserInfo(role);
    }

    public Role getRole(long id) {
        Role role = userService.getRole(id);
        return role;
    }
}
