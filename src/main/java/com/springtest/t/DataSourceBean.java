package com.springtest.t;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @desc
 * @date 2019/7/27 18:24
 */
@Component
public class DataSourceBean {

    @Value("${database.driver}")
    private String driver;
    @Value("${database.url}")
    private String url;
    @Value("${database.username}")
    private String username;
    @Value("${database.password}")
    private String password;

    public void show() {
        System.out.println("driver:" + driver + ",url:" + url);
        System.out.println(username + "," + password);
    }
}
