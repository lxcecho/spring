package com.xc.joy;

import com.xc.joy.beans.Cat;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lxcecho 909231497@qq.com
 * @since 28.08.2021
 */
public class AnnotationTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
		Cat bean = context.getBean(Cat.class);
		System.out.println(bean);
	}
}
