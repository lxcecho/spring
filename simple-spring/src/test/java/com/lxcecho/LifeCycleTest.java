package com.lxcecho;

import com.lxcecho.conf.LifeCycleConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/11/11
 */
public class LifeCycleTest {

	@Test
	public void test01(){
		// 1、创建 ioc 容器
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(LifeCycleConfig.class);
		System.out.println("容器创建完成...");

		// applicationContext.getBean("car");
		// 关闭容器
		applicationContext.close();
	}

}
