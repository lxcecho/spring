package com.selfdev.entity.factory;

import com.selfdev.entity.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/10/14
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
