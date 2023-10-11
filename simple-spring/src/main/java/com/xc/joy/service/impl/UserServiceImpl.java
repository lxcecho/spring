package com.xc.joy.service.impl;

import com.xc.joy.beans.User;
import com.xc.joy.dao.impl.UserDao;
import com.xc.joy.service.UserService;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * @author lxcecho 909231497@qq.com
 * @since 20:17 08-01-2023
 */
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	private DataSourceTransactionManager transactionManager;

	@Override
	public void save(User user) {
		userDao.insert(user);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public DataSourceTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(DataSourceTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
}
