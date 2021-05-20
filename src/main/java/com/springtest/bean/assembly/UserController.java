package com.springtest.bean.assembly;

import com.springtest.mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @desc
 * @date 2019/7/27 11:26
 */
@Component
public class UserController {


    @Autowired
    @Qualifier("userService1")
    private IUser iUser;

    @Autowired
    private IUser iuser1;

    private IUser iUser2;

   /* public UserController(@Autowired IUser iUser){
        this.iUser2 = iUser;
    }*/

    public void printUser(User user) {
        System.out.println("iUser:" + IUser.class);
        iUser.printUserInfo(user);
    }
}
