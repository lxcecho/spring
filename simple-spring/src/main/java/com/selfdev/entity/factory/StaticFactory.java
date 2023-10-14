package com.selfdev.entity.factory;

import com.selfdev.entity.User;

/**
 * 静态工厂调用
 *
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/10/14
 */
public class StaticFactory {
	//静态的方法，返回User对象
	public static User getUser() {
		return new User();
	}

}
