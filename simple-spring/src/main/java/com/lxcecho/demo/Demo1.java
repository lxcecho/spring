package com.lxcecho.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lxcecho
 * @since 08.04.2021
 */
@Component
public class Demo1 {

	@Autowired
	Demo2 demo2;

	public Demo1(){
		System.out.println("X created");
	}

}
