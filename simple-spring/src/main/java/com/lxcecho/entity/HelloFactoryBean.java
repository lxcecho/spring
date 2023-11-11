package com.lxcecho.entity;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * 工厂 bean & 普通 bean
 * 区别：
 * 1、Person = 普通 bean，注册的组件对象就是 Person 对象，类型就是 Person
 * 2、工厂 bean = 实现了 FactoryBean 接口的组件。注册的不是 HelloFactory，
 * 而是 HelloFactory 这个工厂调用了 getObject() 返回的对象，类型是 getObjectType 指定的类型
 * MyBatis 和 Spring 的整合	SqlSessionFactoryBean
 *
 * @author lxcecho 909231497@qq.com
 * @since 20.06.2021
 */
@Component // 也可以实现 SmartFactoryBean 指定提前加载
public class HelloFactoryBean implements FactoryBean<Hello> {

	@Override
	public Hello getObject() throws Exception {
		return new Hello(); // 这是最终获取到的对象
	}

	@Override
	public Class<?> getObjectType() {
		return Hello.class;
	}
}
