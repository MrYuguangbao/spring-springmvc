package com.springtest.bean.assembly;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author admin
 * @desc
 * @date 2019/7/27 12:44
 */
public class BeanAndXmlBeanTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        MyUserController controller = context.getBean(MyUserController.class);
        controller.queryUserByBean(6);


    }


}
