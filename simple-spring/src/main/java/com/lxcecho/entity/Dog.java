package com.lxcecho.entity;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/11/8
 */
public class Dog {

	private Integer id;

	private String name;

	private Integer age;

	public Dog() {
	}

	public Dog(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
