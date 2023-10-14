package com.selfdev.service.impl;

import com.selfdev.service.WelcomeService;
import org.springframework.stereotype.Service;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/10/14
 */
@Service
public class WelcomeServiceImpl implements WelcomeService {

	@Override
	public String sayHello(String name) {
		System.out.println("欢迎你：" + name);
		return "success";
	}
}
