package com.springtest.bean.assembly;

import com.springtest.mybatis.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author admin
 * @desc
 * @date 2019/7/27 10:56
 */
public class ComMainTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        UserController controller = (UserController) context.getBean(UserController.class);
        controller.printUser(new User());
    }
}
