package com.xc.joy.entity;

/**
 * @author lxcecho
 * @since 2021/1/7
 */
public class User {

	private String name;

	private String value;

	public void init() {
		System.out.println("init...");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
