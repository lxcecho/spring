package com.xc.joy.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.alibaba.fastjson.support.spring.messaging.MappingFastJsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
@Configuration
@ComponentScan(value = "com.xc.joy.controller")
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		//converters.add(new MappingJackson2HttpMessageConverter());
		converters.add(new FastJsonHttpMessageConverter());
	}
	

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/page/",".jsp");
	}
}
