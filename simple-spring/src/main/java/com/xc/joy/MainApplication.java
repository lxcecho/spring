package com.xc.joy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lxcecho 909231497@qq.com
 * @Copyright: Copyright (c) 2021
 * @since 07.04.2021
 */
public class MainApplication {
	public static void main(String[] args) {
		System.out.println("Hello,lxcecho.");

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(IndexDao.class);
		context.refresh();
		IndexDao dao = context.getBean(IndexDao.class);
		dao.query();
	}
}
