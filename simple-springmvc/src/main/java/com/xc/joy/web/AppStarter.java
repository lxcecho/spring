package com.xc.joy.web;

import com.xc.joy.config.AppConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 只要实现了 WebApplicationInitializer 相当于配置了 SpringMVC 的 DispatcherServlet
 * 1. Tomcat 已启动就加载它
 * 	1.1 创建了容器，制定了配置类(所有 IOC、AOP 等 spring 的功能就OK)
 * 	1.2 注册一个 Servlet：DispatcherServlet
 * 	1.3 以后所有的请求都交给了 DispatcherServlet
 * 效果，访问 Tomcat 部署的则会个 Web 应用下所有请求都会被 DispatcherServlet 处理，DispatcherServlet 就会进入强大的基于注解的 mvc 处理流程(@GetMapping)
 * 必须 Servlet3.0 以上才可以；Tomcat6.0以上才支持 Servlet3.0 规范；
 * Servlet3.0 是 JavaEE 的 Web 规范标准，Tomcat 是 Servlet3.0 规范的一个实现；
 *
 * @author lxcecho 909231497@qq.com
 * @since 15:51 10-07-2022
 */
public class AppStarter implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// Load Spring web application configuration
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		// 传入配置类
		context.register(AppConfig.class);

		// 利用Servlet的初始化机制，Create and register the DispatcherServlet 以上截止，IOC 容器都没有启动
		DispatcherServlet servlet = new DispatcherServlet(context);
		ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
		registration.setLoadOnStartup(1);
		// 映射路径
		registration.addMapping("/");

		// 启动了容器？上面的 Servlet 添加到 servletContext 里面以后，Tomcat 就会对 DispatcherServlet 进行初始化
	}
}
