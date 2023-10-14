package com.selfdev.controller;

import com.selfdev.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/10/14
 */
@Controller
public class HelloController {
	@Autowired
	private HelloService helloService;

	public void handleRequest() {
		helloService.sayHello();
		helloService.JustWantToThrowException();
	}
}
