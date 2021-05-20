package com.springtest.bean.assembly;

import com.springtest.mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @desc
 * @date 2019/7/27 13:04
 */
@Component
public class MyUserController {

    @Autowired
    @Qualifier("myUserserviceImpl")
    private IUser iUser;

    public void queryUserByBean(int id) {
        User user = iUser.queryUserByBean(id);
        System.out.println("通过dbcp数据源获取的结果是：" + user.getId() + "," + user.getName() + "," + user.getIdentifyId());
    }
}
