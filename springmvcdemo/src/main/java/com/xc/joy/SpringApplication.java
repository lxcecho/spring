package com.xc.joy;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
public class SpringApplication {
	public static void run() throws  Exception {
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8080);
		// 告诉tomcat  web项目
		tomcat.addWebapp("/","D:\\code\\java_learn\\spring-framework\\web");

		tomcat.start();

		tomcat.getServer().await();
		//Thread.currentThread().join();
	}

}
