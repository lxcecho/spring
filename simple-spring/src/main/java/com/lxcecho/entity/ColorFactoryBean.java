package com.lxcecho.entity;

import org.springframework.beans.factory.FactoryBean;

/**
 * 创建一个 Spring 定义的 FactoryBean
 *
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/11/11
 */
public class ColorFactoryBean implements FactoryBean<Color> {

	/**
	 * 返回一个 Color 对象，这个对象会添加到容器中
	 *
	 * @return
	 * @throws Exception
	 */
	@Override
	public Color getObject() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ColorFactoryBean...getObject...");
		return new Color();
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Color.class;
	}

	/**
	 * 是单例？
	 * true：这个 bean 是单实例，在容器中保存一份
	 * false：多实例，每次获取都会创建一个新的 bean；
	 *
	 * @return
	 */
	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}
}
