package com.springtest.bean.assembly;

import com.springtest.mybatis.model.User;

public interface IUser {
    void printUserInfo(User user);

    void printUsrInfo1();

    User queryUserByBean(int id);
}
