package com.xc.joy;

import com.xc.joy.beans.User;
import com.xc.joy.dao.impl.UserDao;
import com.xc.joy.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/10/6
 */
public class JdbcTest {

	@Test
	public void testQuery() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
		UserDao userDao = context.getBean(UserDao.class);
		User user = userDao.findById(3);
		System.out.println(user);
	}

	@Test
	public void testInsert() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
		UserDao userDao = context.getBean(UserDao.class);
		User user = new User();
		user.setName("eman");
		user.setAge(2);
		Integer count = userDao.insert(user);
		System.out.println(count);
	}

	@Test
	public void testUpdate() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
		UserDao userDao = context.getBean(UserDao.class);
		User user = new User();
		user.setId(2);
		user.setName("eman000000000000000");
		user.setAge(3);
		Integer count = userDao.update(user);
		System.out.println(count);
	}

	@Test
	public void testDelete() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
		UserDao userDao = context.getBean(UserDao.class);
		Integer count = userDao.delete(1);
		System.out.println(count);
	}

	@Test
	public void testTransaction() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
		// todo 断点处
		UserService peopleService = (UserService) context.getBean("userServiceProxy");

		User user = new User();
		user.setName("lxcecho");
		user.setAge(110);

		peopleService.save(user);
	}

}
