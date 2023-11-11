package com.lxcecho;

import com.lxcecho.conf.TxConfig;
import com.lxcecho.entity.Dog;
import com.lxcecho.entity.User;
import com.lxcecho.service.DogService;
import com.lxcecho.service.UserService;
import com.lxcecho.service.impl.DogServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/11/11
 */
public class TxTest {

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

	@Test
	public void testTransactionByAnnotation() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
		DogService dogService = context.getBean(DogServiceImpl.class);
		dogService.save(new Dog("小黄", 3));
		context.close();
	}

}
