package com.selfdev.entity.factory;

import com.selfdev.entity.User;

/**
 * 实例工厂调用
 *
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/10/14
 */
public class UserFactory {
	//普通的方法，返回User对象
	//不能通过类名调用，需要通过对象调用
	public User getUser() {
		return new User();
	}

}
