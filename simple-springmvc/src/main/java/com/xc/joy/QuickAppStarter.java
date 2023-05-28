package com.xc.joy;

import com.xc.joy.config.SpringConfig;
import com.xc.joy.config.SpringMvcConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletRegistration;

/**
 * 最快速的整合注解版 SpringMVC 和 Spring 的
 *
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/5/28
 */
public class QuickAppStarter extends AbstractAnnotationConfigDispatcherServletInitializer {
	/**
	 * 根容器的配置（Spring的配置文件===Spring的配置类）
	 *
	 * @return
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{SpringConfig.class};
	}

	/**
	 * web容器的配置（SpringMVC的配置文件===SpringMVC的配置类）
	 *
	 * @return
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{SpringMvcConfig.class};
	}

	/**
	 * Servlet的映射，DispatcherServlet的映射路径
	 *
	 * @return
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
//		super.customizeRegistration(registration);

//		registration.addMapping("");//
	}
}
