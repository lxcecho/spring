package com.xc.joy.proxy.staticproxy;

import com.xc.joy.proxy.dao.impl.MemberDao;

/**
 * @author lxcecho 909231497@qq.com
 * @Copyright: Copyright (c) 2021
 * @since 17.04.2021
 * <p>
 * 静态代理得缺点：
 * 1 会产生很多的代理类
 * 2 产生的代理类只能代理既定的接口
 */
public class MemberStatic extends MemberDao {
	@Override
	public String query(String name, Integer age) {
		System.out.println("==========log=============");
		return super.query(name, age);
	}
}
