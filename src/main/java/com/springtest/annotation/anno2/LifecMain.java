package com.springtest.annotation.anno2;

import com.springtest.annotation.anno.AnnotationConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author admin
 * @date 2020/4/2 21:01
 */
public class LifecMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(DriverAnnotationConfig.class);

        Driver driver = ac.getBean(Driver.class);
        System.out.println(driver);

        //ac.registerShutdownHook();

        System.out.println("--------------- 创建完成 ------------");
        // 调用close是为了调用销毁的逻辑
        ac.close();

        System.out.println("--------------- 销毁完成 ------------");
    }


}
