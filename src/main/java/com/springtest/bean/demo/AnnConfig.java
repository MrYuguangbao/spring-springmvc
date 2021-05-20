package com.springtest.bean.demo;

import com.springtest.bean.demo.condition.Color;
import com.springtest.bean.demo.condition.LinuxCondition;
import com.springtest.bean.demo.condition.Red;
import com.springtest.bean.demo.condition.WindowsCondition;
import org.springframework.context.annotation.*;

/**
 * @Author: admin
 * @Description: 配置类
 * @BelongsProject: SpringLearn
 * @BelongsPackage: com.springtest.bean.demo
 * @CreateTime: 2021-05-16 10:03:07
 */
@Configuration
@Conditional({WindowsCondition.class})
@Import({Color.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
@ComponentScan("com.springtest.bean.demo")
public class AnnConfig {

	@Bean("bill gates")
	public Person person1() {
		return new Person("Bill Gates", 70);
	}

	@Conditional({LinuxCondition.class})
	@Bean("linus")
	public Person person2() {
		return new Person("Linus", 50);
	}

	@Bean
	public MyFactoryBean myFactoryBean() {
		return new MyFactoryBean();
	}

}
