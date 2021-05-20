package com.springtest.model.autowire;

import com.springtest.model.annotation.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @date 2020/1/6 18:13
 */
@Component
public class RoleService2Impl implements RoleService2 {


    private Role role;

    @Autowired
    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public void print() {
        System.out.println(role.getId() + "," + role.getRole() + "," + role.getNote());
    }
}
