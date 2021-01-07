package com.xc.justforjoy.entity.factory;

import com.xc.justforjoy.entity.User;

/**
 * @author lxcecho
 * @since 2021/1/7
 *
 * 静态工厂调用
 */
public class StaticFactory {

	/**
	 * 静态的方法，返回User对象
	 * @return
	 */
	public static User getUser(){
		return new User();
	}

}
