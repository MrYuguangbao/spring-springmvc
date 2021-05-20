package com.springtest.model.profile;

import com.springtest.model.annotation.PojoConfig;
import com.springtest.model.annotation.pojo.Role;
import com.springtest.model.autowire.UserController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author admin
 * @date 2020/1/6 21:42
 */
public class ProfileMainTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PojoConfig.class);
        ProfileController controller = context.getBean(ProfileController.class);
        controller.printProfile();

        /*ConfigurableEnvironment environment = context.getEnvironment();
        System.out.println("url:"+environment.getProperty("database.url"));*/

        context.close();
    }

}
