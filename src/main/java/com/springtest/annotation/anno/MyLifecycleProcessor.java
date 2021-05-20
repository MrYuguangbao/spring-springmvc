package com.springtest.annotation.anno;

import org.springframework.context.LifecycleProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author: admin
 * @Description: 自定义LifecycleProcessor
 * @BelongsProject: SpringLearn
 * @BelongsPackage: com.springtest.annotation.anno
 * @CreateTime: 2021-05-11 09:45:58
 */
@Component
public class MyLifecycleProcessor implements LifecycleProcessor {


	@Override
	public void onRefresh() {
		System.out.println("---onRefresh");
	}

	@Override
	public void onClose() {
		System.out.println("---onClose");
	}

	@Override
	public void start() {
		System.out.println("---start");
	}

	@Override
	public void stop() {
		System.out.println("---stop");
	}

	@Override
	public boolean isRunning() {
		return false;
	}
}
