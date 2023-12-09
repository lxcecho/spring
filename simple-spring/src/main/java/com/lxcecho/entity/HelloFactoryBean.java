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

	/**
	 * 1. FactoryBean和BeanFactory区别
	 *     FactoryBean 是 Spring 中一种特殊的 bean，可以在 getObject() 工厂方法自定义的逻辑创建Bean！是一种能够生产其他 Bean 的 Bean。FactoryBean 在容器启动时被创建，而在实际使用时则是通过调用 getObject() 方法来得到其所生产的 Bean。因此，FactoryBean 可以自定义任何所需的初始化逻辑，生产出一些定制化的 bean。
	 *     一般情况下，整合第三方框架，都是通过定义FactoryBean实现！！！
	 *     BeanFactory 是 Spring 框架的基础，其作为一个顶级接口定义了容器的基本行为，例如管理 bean 的生命周期、配置文件的加载和解析、bean 的装配和依赖注入等。BeanFactory 接口提供了访问 bean 的方式，例如 getBean() 方法获取指定的 bean 实例。它可以从不同的来源（例如 Mysql 数据库、XML 文件、Java 配置类等）获取 bean 定义，并将其转换为 bean 实例。同时，BeanFactory 还包含很多子类（例如，ApplicationContext 接口）提供了额外的强大功能。
	 *     总的来说，FactoryBean 和 BeanFactory 的区别主要在于前者是用于创建 bean 的接口，它提供了更加灵活的初始化定制功能，而后者是用于管理 bean 的框架基础接口，提供了基本的容器功能和 bean 生命周期管理。
	 */
	@Override
	public Hello getObject() throws Exception {
		return new Hello(); // 这是最终获取到的对象
	}

	@Override
	public Class<?> getObjectType() {
		return Hello.class;
	}
}
