package com.xc.justforjoy;

import com.xc.justforjoy.controller.HelloController;
import com.xc.justforjoy.service.HelloService;
import com.xc.justforjoy.service.HiService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lxcecho
 * @since 2021/1/7
 */
@Configuration
@ComponentScan("com.xc.justforjoy")
public class Entrance {
	public static void main(String[] args) {
		System.out.println("HELLO LXCECHO.");

		// 基于XML配置方式的Bean注入
		/*ApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:spring/spring-config.xml");
		WelcomeService welcomeService = (WelcomeService) ioc.getBean("welcomeService");
		welcomeService.sayHello("IOC ... ");
		User user1 = (User) ioc.getBean("user1");
		User user11 = (User) ioc.getBean("user1");
		System.out.println(user1 + "\n" + user11);
		User user2 = (User) ioc.getBean("user2");
		User user22 = (User) ioc.getBean("user2");
		System.out.println(user2 + "\n" + user22);
		User user3 = (User) ioc.getBean("user3");
		User user33 = (User) ioc.getBean("user3");
		System.out.println(user3 + "\n" + user33);*/

		// 基于注解方式的Bean注入
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Entrance.class);

		/*HelloController helloController = (HelloController)applicationContext.getBean("helloController");
		helloController.handleRequest();*/

		HiService hiService = (HiService) applicationContext.getBean("hiServiceImpl");
		hiService.sayHi();
		HelloService helloService = (HelloService) applicationContext.getBean("helloServiceImpl");
		helloService.sayHello();


	}
}
