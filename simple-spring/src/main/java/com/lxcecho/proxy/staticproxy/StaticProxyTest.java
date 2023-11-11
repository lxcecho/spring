package com.lxcecho.proxy.staticproxy;

import com.lxcecho.dao.IndexDao;
import com.lxcecho.dao.impl.MemberDaoImpl;

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
		IndexDao indexDao = new MemberStaticImpl();
		indexDao.query("lxcecho", 24);

		IndexDao dao = new MemberTime(new MemberDaoImpl());
		System.out.println(dao.query("lxcecho", 18));

	}

}
