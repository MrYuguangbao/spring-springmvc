package com.springtest.bean.demo.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Author: admin
 * @Description: 条件1
 * @BelongsProject: SpringLearn
 * @BelongsPackage: com.springtest.bean.demo.condition
 * @CreateTime: 2021-05-16 11:00:28
 */
public class LinuxCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Environment environment = context.getEnvironment();
		String property = environment.getProperty("os.name");
		if (property.contains("Linux")) {
			return true;
		}
		return false;
	}
}
