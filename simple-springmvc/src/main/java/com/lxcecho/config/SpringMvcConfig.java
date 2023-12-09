package com.lxcecho.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * SpringMVC 只扫描 controller 组件，可以不指定父容器类，让 MVC 扫所有。@Component + @RequestMapping 就生效了
 * useDefaultFilters=false 禁用默认的过滤规则；
 *
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/5/28
 */
@ComponentScan(value = "com.xc.joy", includeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)
}, useDefaultFilters = false)
@EnableWebMvc
public class SpringMvcConfig {
	// SpringMVC 的子容器，能扫描的 Spring 容器中的组件

	/**
	 * DEBUG sayHi 接口，需要将 MvcExtendConfiguration 注释掉
	 *
	 * @return
	 */
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}

}
