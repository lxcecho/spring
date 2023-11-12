package com.lxcecho;

import com.lxcecho.conf.AutowiredConfig;
import com.lxcecho.entity.Boss;
import com.lxcecho.entity.Car;
import com.lxcecho.entity.Color;
import com.lxcecho.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/11/11
 */
public class AutowiredTest {

	@Test
	public void test01(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutowiredConfig.class);

		BookService bookService = applicationContext.getBean(BookService.class);
		System.out.println(bookService);

		//BookDao bean = applicationContext.getBean(BookDao.class);
		//System.out.println(bean);

		Boss boss = applicationContext.getBean(Boss.class);
		System.out.println(boss);
		Car car = applicationContext.getBean(Car.class);
		System.out.println(car);

		Color color = applicationContext.getBean(Color.class);
		System.out.println(color);
		System.out.println(applicationContext);
		applicationContext.close();
	}

}
