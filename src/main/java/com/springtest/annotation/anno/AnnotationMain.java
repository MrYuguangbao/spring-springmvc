package com.springtest.annotation.anno;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author admin
 * @date 2020/4/2 21:01
 */
public class AnnotationMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        /*ConfigurableEnvironment environment = ac.getEnvironment();
        String var = environment.getProperty("database.username");
        System.out.println("database.username：" + var);*/

        // 发布事件
        /*ac.publishEvent(new ApplicationEvent(new String("发布自定义事件")) {
        });*/
        /*Car bean = ac.getBean(Car.class);
        System.out.println(bean);*/

        System.out.println("--------------- 创建完成 ------------");
        // 调用close是为了调用销毁的逻辑
        ac.close();

        System.out.println("--------------- 销毁完成 ------------");
    }


}
