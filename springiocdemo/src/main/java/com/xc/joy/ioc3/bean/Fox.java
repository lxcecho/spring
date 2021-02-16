package com.xc.joy.ioc3.bean;

import com.xc.joy.ioc3.service.MyService;
import org.springframework.stereotype.Component;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
public class Fox {

	private Cat cat;

	public Fox() {
	}

	public Fox(Cat cat) {
		System.out.println(cat+"===Fox(Cat cat)=====");
	}

	public Fox(Cat cat,Tiger tiger) {
		System.out.println(cat+"===Fox(Cat cat,Tiger tiger)=====");
	}
//
	public Fox(Cat cat, MyService myService) {
		System.out.println(cat+"=== Fox(Cat cat, MyService myService) =====");
	}

	public Cat getCat() {
		return cat;
	}


	public void setCat(Cat cat) {
		System.out.println(cat+"======setCat(Cat cat)");
		this.cat = cat;
	}

	@Override
	public String toString() {
		return "Fox{" +
				"cat=" + cat +
				'}';
	}

	//	public Fox(User user,Cat cat) {
//		System.out.println(user+"===Fox(User user,Cat cat) =====");
//	}
}
