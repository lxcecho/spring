package com.pattern.proxy.staticproxy;

import com.pattern.proxy.MemberDao;

/**
 * 静态代理测试
 *
 * @author lxcecho 909231497@qq.com
 * @Copyright: Copyright (c) 2021
 * @since 17.04.2021
 */
public class StaticProxyTest {
	public static void main(String[] args) {
		// 静态代理测试
		MemberDao memberDao = new MemberStaticImpl();
		memberDao.query("lxcecho", 24);

		MemberDao dao = new MemberTime(new MemberDaoImpl());
		System.out.println(dao.query("lxcecho", 18));

	}

}
