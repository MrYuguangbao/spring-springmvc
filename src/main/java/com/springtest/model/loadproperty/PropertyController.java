package com.springtest.model.loadproperty;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Properties;

/**
 * @author admin
 * @date 2020/1/6 21:43
 */
@Controller
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PropertyController {

    @Value("${test.database.url}")
    private String url;

    @Value("${log4j.appender.stdout}")
    private String log4j;

    @Autowired
    private PropertyServiceImpl propertyService;

    public void printProfile() {
        System.out.println("属性文件占位符解析：" + url);
        System.out.println("log4j:" + log4j);
    }

}
