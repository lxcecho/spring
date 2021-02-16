package com.xc.joy.ioc3.bean;

import com.xc.joy.ioc3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
@Component
public class User {

	@Autowired
	private Fox fox;  //field.set(obj,value)

	@Autowired  // byType  ---- byName
	//@Qualifier("userService2")
	private UserService userService;

	public User() {

		System.out.println("=====User()====");
	}


	public Fox getFox() {
		return fox;
	}

	//@Autowired   //autowireMode=1 2
	public void setFox(Fox fox) {
		System.out.println(fox+"=======setFox(Fox fox)======");
		this.fox = fox;
	}


	@Override
	public String toString() {
		return "User{" +
				"fox=" + fox +
				", userService=" + userService +
				'}';
	}

}
