package com.lxcecho;

import com.lxcecho.conf.PropertyValuesConfig;
import com.lxcecho.entity.People;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/11/11
 */
public class PropertyValueTest {
	AnnotationConfigApplicationContext applicationContext =
			new AnnotationConfigApplicationContext(PropertyValuesConfig.class);

	@Test
	public void test01() {
		printBeans(applicationContext);
		System.out.println("=============");

		People people = (People) applicationContext.getBean("people");
		System.out.println(people);


		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String property = environment.getProperty("people.nickName");
		System.out.println(property);
		applicationContext.close();
	}

	private void printBeans(AnnotationConfigApplicationContext applicationContext) {
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : definitionNames) {
			System.out.println(name);
		}
	}

}
