package com.selfdev.service.impl;

import com.selfdev.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/10/14
 */
@Service
public class HelloServiceImpl implements HelloService {
	@Override
	public void sayHello() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Hello everybody");
	}

	@Override
	public void JustWantToThrowException() {
		throw new RuntimeException("hello exception");
	}
}
