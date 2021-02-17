package com.xc.joy.ioc.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Role;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * @author lxcecho
 * @since 2021/2/16
 */
@Component  //GenericBeanDefinition
//@Scope("prototype")
public class User{

	private String name;

	private int age;

	@Autowired   //  1.primary  2.fallback   fox
	private Fox fox;


	public  User(){
		System.out.println("new User()");
	}
	// NoSuchBeanDefinitionException

	//@Autowired
	public User(Fox fox){
		this.fox = fox;
		System.out.println("new User(Fox fox)");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Fox getFox() {
		return fox;
	}

	public void setFox(Fox fox) {
		this.fox = fox;
		System.out.println("setFox(Fox fox)");
	}



	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", age=" + age +
				", fox=" + fox +
				'}';
	}
}
