package com.xc.justforjoy.service.impl;

import com.xc.justforjoy.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author lxcecho
 * @since 2021/1/8
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
		System.out.println("打个Hello招呼...");
	}

	@Override
	public void JustWantToThrowException() {
		throw new RuntimeException("hello exception...");
	}
}
