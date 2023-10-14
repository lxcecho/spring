package com.selfdev;

import com.selfdev.aspect.OutSide;
import com.selfdev.service.HelloService;
import com.selfdev.service.HiService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/10/14
 */
@Configuration
@EnableAspectJAutoProxy
@Import(OutSide.class)
@ComponentScan("com.selfdev")
public class Entrance {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Entrance.class);
		HiService hiService = (HiService) applicationContext.getBean("hiServiceImpl");
		hiService.sayHi();
		System.out.println("---------------------------分割线以下执行 HelloService-------------------------------");
		HelloService helloService = (HelloService) applicationContext.getBean("helloServiceImpl");
		helloService.sayHello();
	}
}
