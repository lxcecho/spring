package com.pattern.proxy.staticproxy;

import com.pattern.proxy.MemberDao;

/**
 * @author lxcecho 909231497@qq.com
 * @since 17.04.2021
 */
public class MemberDaoImpl implements MemberDao {
	@Override
	public String query(String name, Integer age) {
		System.out.println("------query----------");
		return name + " " + age + "- return";
	}
}
