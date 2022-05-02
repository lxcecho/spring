package com.xc.joy.beans;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author lxcecho 909231497@qq.com
 * @since 14.06.2021
 */
//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
// 容器就应该给 Cat 再创建一个对象
@Component
public class Cat implements InitializingBean, SmartInitializingSingleton {

	private String name;

	@Value("${JAVA_HOME}") // 自动赋值功能
	public void setName(String name) {
		System.out.println("cat ... 正在赋值...");
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Cat(){
		System.out.println("Cat 对象创建...");
	}

	/**
	 * 注解怎么定义这个是初始化方法？？
	 */
	public void init() {
		System.out.println("这是初始化方法");
	}

	@Override
	public String toString() {
		return "Cat{" +
				"name='" + name + '\'' +
				'}';
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("CatInitializingBean...afterPropertiesSet...");
	}

	@Override
	public void afterSingletonsInstantiated() {
		System.out.println("所有组件创建完成后，再来执行这个方法。。。");
	}
}
