package com.springtest.model.annotation;

import com.springtest.model.CusRole;
import com.springtest.model.annotation.pojo.Role;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @date 2020/1/6 17:38
 */
@Component
public class RoleServiceImpl implements RoleService {

    @Override
    public void print(Role role) {
        System.out.println(role.getId() + "," + role.getRole() + "," + role.getNote());
    }
}
