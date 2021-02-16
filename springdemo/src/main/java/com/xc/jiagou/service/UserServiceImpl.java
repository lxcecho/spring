package com.xc.jiagou.service;

import com.xc.jiagou.bean.Person;
import com.xc.jiagou.bean.User;
import com.xc.jiagou.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
@Component
public class UserServiceImpl implements UserService {

	//@Autowired
	UserDao userDao;

	/*public UserServiceImpl() {
		System.out.println("---constructer---");
	}*/

	//@Autowired
	public UserServiceImpl(UserDao userDao) {
		System.out.println("---constructer---"+userDao);
		this.userDao = userDao;
	}

	public UserServiceImpl(UserDao userDao, Person person) {
		System.out.println("---constructer---"+userDao+","+person);
		this.userDao = userDao;
	}
	public UserServiceImpl(UserDao userDao, User user) {
		System.out.println("---constructer---"+userDao+","+user);
		this.userDao = userDao;
	}
	//@Autowired
	public void setUserDaoxxxx(UserDao userDao){
		System.out.println("---setUserDaoxxxx---"+userDao);
		this.userDao = userDao;
	}

	public void setUserDao(UserDao userDao){
		System.out.println("---setUserDao---"+userDao);
		this.userDao = userDao;
	}

	public void setxxxxUserDao(UserDao userDao){
		System.out.println("---setxxxxxxUserDao---"+userDao);
		this.userDao = userDao;
	}


	@Override
	public void query() {
		System.out.println(userDao);
	}
}
