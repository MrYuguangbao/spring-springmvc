package com.springtest.model.loadproperty;

import com.springtest.model.annotation.PojoConfig;
import com.springtest.model.profile.ProfileController;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.beans.Beans;
import java.util.Properties;

/**
 * @author admin
 * @date 2020/1/6 21:42
 */
public class PropertyMainTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PropConfig.class);
        PropertyController controller = context.getBean(PropertyController.class);
        controller.printProfile();
        PropertyController controller1 = context.getBean(PropertyController.class);
        System.out.println(controller == controller1);
        context.close();
    }

}
