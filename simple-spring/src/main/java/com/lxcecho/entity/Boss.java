package com.lxcecho.entity;

import org.springframework.stereotype.Component;

/**
 * 默认加在 ioc 容器中的组件，容器启动会调用无参构造器创建对象，再进行初始化赋值等操作
 *
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/11/11
 */
@Component
public class Boss {

	private Car car;

	/**
	 * 构造器要用的组件，都是从容器中获取
	 *
	 * @param car
	 */
	public Boss(Car car) {
		this.car = car;
		System.out.println("Boss...有参构造器");
	}

	public Car getCar() {
		return car;
	}

	//@Autowired
	// 标注在方法，Spring 容器创建当前对象，就会调用方法，完成赋值；
	// 方法使用的参数，自定义类型的值从 ioc 容器中获取
	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Boss [car=" + car + "]";
	}

}
