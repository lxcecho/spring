package com.xc.joy.entity.factory;

import com.xc.joy.entity.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author lxcecho
 * @since 2021/1/7
 */
public class UserFactoryBean implements FactoryBean<User> {

	@Override
	public User getObject() throws Exception {
		return new User();
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}
}
