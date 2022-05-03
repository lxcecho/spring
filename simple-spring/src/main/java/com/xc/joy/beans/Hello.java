package com.xc.joy.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * @author lxcecho 909231497@qq.com
 * @since 20.06.2021
 */
public class Hello {

	/**
	 * 为啥能注册进来，之前就保存到容器的实例缓存池了，底层组件先在：resolvableDependencies
	 * 下面的接口还可以使用 XxxAware 接口
	 */
	@Autowired
	private ApplicationContext applicationContext;

	// BeanFactoru 实例池里面有
	@Autowired
	private Environment environment;

	@Autowired // 注入环境变量信息
	private Map<String, String> systemEnvironment;

}
