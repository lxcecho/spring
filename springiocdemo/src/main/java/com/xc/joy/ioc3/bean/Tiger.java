package com.xc.joy.ioc3.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
@Component
public class Tiger {

//	public Tiger(){
//		System.out.println("===Tiger()===");
//	}


	public Tiger(User user){
		System.out.println("===Tiger(User user)===");
	}


	public Tiger(User user,Fox fox){
		System.out.println("===Tiger(User user,Fox fox)===");
	}
	//
	//@Autowired
	public Tiger(User user,Cat cat){
		System.out.println("===Tiger(User user,Cat cat)===");
	}

//	public Tiger(User user,Cat cat, Monkey monkey){
//		System.out.println("===Tiger(User user,Cat cat, Monkey monkey)===");
//	}

}
