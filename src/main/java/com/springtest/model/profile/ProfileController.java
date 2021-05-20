package com.springtest.model.profile;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

/**
 * @author admin
 * @date 2020/1/6 21:43
 */
@Controller
public class ProfileController {

    @Autowired
    private BasicDataSource dataSource;

    @Value("${test.database.url}")
    private String url;

    public void printProfile() {
        System.out.println("数据库连接的url:" + dataSource.getUrl());
        System.out.println("属性文件占位符解析：" + url);
    }

}
