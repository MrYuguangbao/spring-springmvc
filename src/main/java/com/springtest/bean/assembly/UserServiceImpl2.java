package com.springtest.bean.assembly;

import com.springtest.mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @desc
 * @date 2019/7/27 11:18
 */
@Component
@Primary
public class UserServiceImpl2 implements IUser {
    @Autowired
    private User user1;

    @Override
    public void printUserInfo(User user) {
        System.out.println(user.getId() + "," + user.getName() + "," + user.getIdentifyId());
    }

    @Override
    public void printUsrInfo1() {
        System.out.println(user1.getId() + "," + user1.getName() + "," + user1.getIdentifyId());
    }

    @Override
    public User queryUserByBean(int id) {
        return null;
    }
}
