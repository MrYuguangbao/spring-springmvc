package com.springtest.model.annotation;

import com.springtest.model.annotation.pojo.Role;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author admin
 * @date 2020/1/6 17:02
 */
public class AnnotationMainTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PojoConfig.class);

        Role role = context.getBean(Role.class);
        RoleAnnotation bean = context.getBean(RoleAnnotation.class);
        System.out.println(role.getId() + "," + role.getRole() + "," + role.getNote());

    }


}
