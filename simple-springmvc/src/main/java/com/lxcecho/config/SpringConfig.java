package com.lxcecho.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * Spring 不扫描 controller 组件，AOP 咋实现的???
 * Spring 的容器不扫描 controller; 父容器
 *
 * @author lxcecho 909231497@qq.com
 * @since 15:53 10-07-2022
 */
@ComponentScan(value = "com.lxcecho", excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)
})
@Configuration
public class SpringConfig {
	// Spring 的父容器
}
