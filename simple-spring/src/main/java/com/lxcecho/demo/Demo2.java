package com.lxcecho.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lxcecho
 * @since 08.04.2021
 */
@Component
public class Demo2 {

	@Autowired
	Demo1 demo1;

	public Demo2(){
		System.out.println("Y created");
	}

}
