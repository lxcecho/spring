package com.xc.joy.controller;

import com.xc.joy.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

/**
 * @author lxcecho
 * @since 2021/1/7
 */
@Controller
public class WelcomeController {

	private String myName;

	private ApplicationContext myContainer;

	@Autowired
	private WelcomeService welcomeService;

	public void handleRequest() {
		welcomeService.sayHello("来自Controller的问候...");
		System.out.println("我是谁？" + myName);
		String[] beanDefinitionNames = myContainer.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println("通过容器获得：" + beanDefinitionName);
		}
	}


}
