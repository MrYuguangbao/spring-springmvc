package com.springtest.mybatis_spring;

import com.springtest.mybatis_spring.mapper.UserMapper;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.util.Map;

/**
 * @Author: admin
 * @Description: importBeanDefinitionRegistrar
 * @BelongsProject: SpringLearn
 * @BelongsPackage: com.springtest.mybatis_spring
 * @CreateTime: 2021-05-05 21:16:27
 */
public class ArtistImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(ArtistSacn.class.getName());
		String scanPath = (String) annotationAttributes.get("value");
		System.out.println("配置的mapper扫描路径：" + scanPath);

		ArtistScanner scanner = new ArtistScanner(registry);
		scanner.addIncludeFilter(new TypeFilter() {
			@Override
			public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
				return true;
			}
		});
		scanner.scan(scanPath);

		// 注册BeanDefinition(不能在此处定义ClassPathBeanDefinitionScanner执行扫描逻辑，因为Spring的扫描逻辑是不识别接口)
		/*AbstractBeanDefinition abd = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
		abd.setBeanClass(ArtistFactoryBean.class);
		abd.getConstructorArgumentValues().addGenericArgumentValue(UserMapper.class);
		registry.registerBeanDefinition("factoryBean", abd);*/


	}
}
