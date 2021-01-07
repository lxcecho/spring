package com.xc.justforjoy;

import com.xc.justforjoy.service.WelcomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lxcecho
 * @since 2021/1/7
 */
@Configuration
public class Entrance {
	public static void main(String[] args) {
		System.out.println("HELLO LXCECHO.");

		ApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:spring/spring-config.xml");
		WelcomeService welcomeService = (WelcomeService) ioc.getBean("welcomeService");
		welcomeService.sayHello("IOC ... ");


//		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Entrance.class);
//		WelcomeService welcomeService = (WelcomeService) applicationContext.getBean("welcomeService");
//		welcomeService.sayHello("spring container...");
//		System.out.println("-----------------分割线以下执行HelloService-------------------");


	}
}
