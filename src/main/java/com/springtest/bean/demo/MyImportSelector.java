package com.springtest.bean.demo;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: admin
 * @Description: import注解实现类
 * @BelongsProject: SpringLearn
 * @BelongsPackage: com.springtest.bean.demo
 * @CreateTime: 2021-05-16 09:59:44
 */
public class MyImportSelector implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{"com.springtest.bean.demo.condition.Yellow", "com.springtest.bean.demo.condition.Red"};
	}
}
