package com.springtest.model.autowire;

import com.springtest.model.CusRole;
import com.springtest.model.annotation.pojo.Role;

public interface UserService {
    void printUserInfo(Role role);

    Role getRole(long id);
}
