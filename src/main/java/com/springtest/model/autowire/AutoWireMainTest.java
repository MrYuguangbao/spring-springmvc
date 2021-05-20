package com.springtest.model.autowire;

import com.springtest.model.annotation.PojoConfig;
import com.springtest.model.annotation.pojo.Role;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author admin
 * @date 2020/1/6 18:18
 */
public class AutoWireMainTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PojoConfig.class);
        Role role = context.getBean(Role.class);
        UserController controller = context.getBean(UserController.class);
        controller.printUser(role);
       /* Role result = controller.getRole(1);
        System.out.println("根据id获取用户信息：\n"+result);*/
        context.close();

    }


}
