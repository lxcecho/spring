package com.xc.joy.service;

import org.springframework.stereotype.Service;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/5/28
 */
@Service
public class HelloService {
	public HelloService() {
		System.out.println("HelloService.....");
	}

	public String say(String name) {
		return "Hello, " + name;
	}
}
