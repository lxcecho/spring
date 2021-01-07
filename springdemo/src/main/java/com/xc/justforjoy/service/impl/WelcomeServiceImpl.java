package com.xc.justforjoy.service.impl;

import com.xc.justforjoy.service.WelcomeService;
import org.springframework.stereotype.Service;

/**
 * @author lxcecho
 * @since 2021/1/7
 */
@Service
public class WelcomeServiceImpl implements WelcomeService {
	@Override
	public String sayHello(String name) {
		System.out.println("欢迎你：" + name);
		return "success";
	}
}
