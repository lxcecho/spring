package com.xc.joy;

import com.xc.joy.aop.HelloService;
import com.xc.joy.beans.Cat;
import com.xc.joy.beans.Hello;
import com.xc.joy.beans.Person;
import com.xc.joy.beans.Student;
import com.xc.joy.conf.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lxcecho 909231497@qq.com
 * @since 28.08.2021
 */
public class AnnotationTest {

	public static void main(String[] args) {
		// 注解版 Spring 的用法，XXAware 调试
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		// factoryBean 获取
		/*Hello bean = applicationContext.getBean(Hello.class);*/

		Person person = applicationContext.getBean(Person.class);
		System.out.println(person);

		// 打印所有注册到容器的 bean 实例
		/*String[] names = applicationContext.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}*/

		// 测试 单实例引用非单实例，即 @Lookup
		/*Cat bean = applicationContext.getBean(Cat.class);
		Cat bean1 = applicationContext.getBean(Cat.class);
		System.out.println(bean == bean1);// false*/

		/*Student stu1 = applicationContext.getBean(Student.class);
		Cat cat = stu1.getCat();
		Student stu2 = applicationContext.getBean(Student.class);
		Cat cat1 = stu2.getCat();
		System.out.println(cat == cat1);// true
		System.out.println(cat + "," + cat1);
		System.out.println(stu1 + "," + stu2);*/

		// 循环引用，原理测试
		// AOP，原理测试
		/*HelloService helloService = applicationContext.getBean(HelloService.class);
		helloService.sayHello("lxcecho");*/

	}

	public static void main1(String[] args) {
		// debug 实现 xxxAware 接口的赋值过程
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		Person person = applicationContext.getBean(Person.class);
		ApplicationContext context = person.getContext();
		System.out.println(context == applicationContext);
	}

}
