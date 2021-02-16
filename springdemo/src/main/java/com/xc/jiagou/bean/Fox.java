package com.xc.jiagou.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
public class Fox {


	@Bean
	public User getUser(){
		return new User();
	}


}
