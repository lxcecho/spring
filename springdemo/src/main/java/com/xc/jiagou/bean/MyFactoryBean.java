package com.xc.jiagou.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
public class MyFactoryBean implements FactoryBean {

	@Override
	public Object getObject() throws Exception {
		return new Fox();
	}

	@Override
	public Class<?> getObjectType() {
		return Fox.class;
	}


	@Override
	public boolean isSingleton() {
		return true;
	}

}
