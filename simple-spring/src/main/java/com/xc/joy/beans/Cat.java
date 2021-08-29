package com.xc.joy.beans;

import org.springframework.beans.factory.InitializingBean;
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
public class Cat implements InitializingBean {
	private String name;

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
}
