package com.springtest.annotation.anno;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author: admin
 * @Description: 自定義ApplicationListener
 * @BelongsProject: SpringLearn
 * @BelongsPackage: com.springtest.annotation.anno
 * @CreateTime: 2021-05-10 15:22:32
 */
@Component
public class MyApplicationListener implements ApplicationListener {


	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("--实现ApplicationListener接口，收到事件:" + event);
	}
}
