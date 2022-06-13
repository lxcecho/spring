package com.xc.joy.aop;

import org.springframework.stereotype.Component;


/**
 * @author lxcecho 909231497@qq.com
 * @since 03.05.2022
 * <p>
 * 切面存在的话就会返回代理对象
 */
@Component // 如果切面存在的话就返回代理对象
public class HelloService {

	public HelloService() {
		System.out.println("HelloService Constructor...");
	}

	public String sayHello(String name) {
		String result = "Hello, " + name;
		System.out.println("result: {" + result + "}");
		int length = name.length();
		return result + "---" + length;
	}

}
