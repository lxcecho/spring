package com.lxcecho.service.impl;

import com.lxcecho.dao.impl.UserDaoImpl;
import com.lxcecho.entity.User;
import com.lxcecho.service.UserService;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * @author lxcecho 909231497@qq.com
 * @since 20:17 08-01-2023
 */
public class UserServiceImpl implements UserService {

	private UserDaoImpl userDao;

	private DataSourceTransactionManager transactionManager;

//	@Transactional
	@Override
	public void save(User user) {
		userDao.insert(user);
		// otherDao.other
		System.out.println("Insert Finished...");
//		int i = 10/0;
	}

	public UserDaoImpl getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDaoImpl userDaoImpl) {
		this.userDao = userDaoImpl;
	}

	public DataSourceTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(DataSourceTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
}
