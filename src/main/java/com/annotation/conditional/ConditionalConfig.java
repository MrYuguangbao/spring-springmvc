package com.annotation.conditional;

import com.annotation.factorybean.ColorFactoryBean;
import com.annotation.importanno.MyImportBeanDefinitionRegistrar;
import com.annotation.importanno.MyImportSelector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Import;

/**
 * @version 1.0
 * @project: spring
 * @package: org.springframework.demo.conditional
 * @author:admin
 * @createTime 9月 18 2021 22:42:30
 */
@ComponentScan(value = "com.annotation.conditional")
@Import({ImportBean.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class ConditionalConfig {

	@Conditional({WindowsCondition.class})
	@Bean("bill")
	public User user01() {
		return new User("bill", 50);
	}

	@Conditional({LinuxCondition.class})
	@Bean("linus")
	public User user02() {
		return new User("linus", 59);
	}

	@Bean
	public ColorFactoryBean colorFactoryBean() {
		return new ColorFactoryBean();
	}

}
