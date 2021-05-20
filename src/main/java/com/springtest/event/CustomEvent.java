package com.springtest.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author admin
 * @date 2020/4/2 22:09
 */
public class CustomEvent extends ApplicationEvent {


    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public CustomEvent(Object source) {
        super(source);
        System.out.println("custom event");
    }
}
