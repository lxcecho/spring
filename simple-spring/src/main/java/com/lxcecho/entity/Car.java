package com.lxcecho.entity;

import org.springframework.stereotype.Component;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/11/11
 */
@Component
public class Car {

	public Car() {
		System.out.println("car constructor...");
	}

	public void init() {
		System.out.println("car ... init...");
	}

	public void destroy() {
		System.out.println("car ... detory...");
	}
}
