package com.springtest.annotation.anno;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Author: admin
 * @Description: 使用注解@EventListener定义监听器
 * @BelongsProject: SpringLearn
 * @BelongsPackage: com.springtest.annotation.anno
 * @CreateTime: 2021-05-10 15:55:23
 */
@Component
public class MyAnnotationApplicationListener {

	@EventListener(classes = {ApplicationEvent.class})
	public void myListener(ApplicationEvent event) {
		System.out.println("使用注解@EventListener监听到的事件：" + event);
	}

}
