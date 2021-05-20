package com.springtest.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author admin
 * @date 2020/4/2 22:09
 */
public class CustomListener implements ApplicationListener<CustomEvent> {

    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("custom listener handle");
    }
}
