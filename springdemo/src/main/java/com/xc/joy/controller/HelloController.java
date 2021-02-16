package com.xc.joy.controller;

import com.xc.joy.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author lxcecho
 * @since 2021/1/8
 */
@Controller
public class HelloController {

	@Autowired
	private HelloService helloService;

	public void handleRequest(){
		helloService.sayHello();
		helloService.JustWantToThrowException();
	}
}
