package com.annotation.profile;

import com.annotation.lifecycle.LifecycleConfig;
import com.springtest.bean.A;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import javax.sql.DataSource;

/**
 * @version 1.0
 * @project: spring-test
 * @package: com.annotation.lifecycle
 * @author:admin
 * @createTime 9月 19 2021 08:41:07
 */
public class ProfileMain {

    public static void main(String[] args) {
        //AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ProfileConfig.class);
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        ac.getEnvironment().setActiveProfiles("test");
        ac.register(ProfileConfig.class);
        ac.refresh();
        String[] beanNamesForType = ac.getBeanNamesForType(DataSource.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }

    }
}
