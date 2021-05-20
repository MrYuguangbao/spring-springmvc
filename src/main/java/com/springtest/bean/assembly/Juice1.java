package com.springtest.bean.assembly;

import com.springtest.bean.lifecycle.Juice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @desc
 * @date 2019/7/27 11:45
 */
@Component
public class Juice1 {

    @Bean(name = "juice")
    public Juice show() {
        Juice juice = new Juice();
        return juice;
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Juice juice = (Juice) context.getBean(Juice.class);
        juice.show();
        ((AnnotationConfigApplicationContext) context).close();
    }
}
