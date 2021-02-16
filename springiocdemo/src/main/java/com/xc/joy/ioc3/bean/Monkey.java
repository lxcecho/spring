package com.xc.joy.ioc3.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
@Component
public class Monkey  {

	private String name;

	private Fox fox;



	public Monkey(){
		System.out.println("======Monkey======");
	}

	public Monkey(String name) {
		System.out.println("======Monkey(String name)======");
		this.name = name;
	}

	public  Monkey(Fox fox){
		System.out.println("======Monkey(Fox fox)======");
		this.fox = fox;
	}
	//@Autowired
	public Monkey(Cat cat,Tiger tiger) {
		System.out.println("===Monkey(Cat cat,Tiger tiger)=====");
	}

	public Monkey(Cat cat, User user) {
		System.out.println("=== Monkey(Cat cat, User user) =====");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Monkey{" +
				"name='" + name + '\'' +
				'}';
	}
}
