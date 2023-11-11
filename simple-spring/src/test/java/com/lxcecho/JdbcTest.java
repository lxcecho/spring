package com.lxcecho;

import com.lxcecho.dao.impl.UserDaoImpl;
import com.lxcecho.entity.Dog;
import com.lxcecho.entity.User;
import com.lxcecho.conf.TxConfig;
import com.lxcecho.service.DogService;
import com.lxcecho.service.UserService;
import com.lxcecho.service.impl.DogServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/10/6
 */
public class JdbcTest {

	@Test
	public void testQuery() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
		UserDaoImpl userDaoImpl = context.getBean(UserDaoImpl.class);
		User user = userDaoImpl.findById(3);
		System.out.println(user);
	}

	@Test
	public void testInsert() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
		UserDaoImpl userDaoImpl = context.getBean(UserDaoImpl.class);
		User user = new User();
		user.setName("eman");
		user.setAge(2);
		Integer count = userDaoImpl.insert(user);
		System.out.println(count);
	}

	@Test
	public void testUpdate() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
		UserDaoImpl userDaoImpl = context.getBean(UserDaoImpl.class);
		User user = new User();
		user.setId(2);
		user.setName("eman000000000000000");
		user.setAge(3);
		Integer count = userDaoImpl.update(user);
		System.out.println(count);
	}

	@Test
	public void testDelete() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc.xml");
		UserDaoImpl userDaoImpl = context.getBean(UserDaoImpl.class);
		Integer count = userDaoImpl.delete(1);
		System.out.println(count);
	}

}
