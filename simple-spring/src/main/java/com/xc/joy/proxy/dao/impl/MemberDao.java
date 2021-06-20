package com.xc.joy.proxy.dao.impl;

import com.xc.joy.proxy.dao.IndexDao;

/**
 * @author lxcecho 909231497@qq.com
 * @Copyright: Copyright (c) 2021
 * @since 17.04.2021
 */
public class MemberDao implements IndexDao {
	@Override
	public String query(String name, Integer age) {
		System.out.println("------query----------");
		return name + " " + age + "- return";
	}
}
