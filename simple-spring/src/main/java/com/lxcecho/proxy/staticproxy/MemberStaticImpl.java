package com.lxcecho.proxy.staticproxy;

import com.lxcecho.dao.impl.MemberDaoImpl;

/**
 * 静态代理得缺点：
 * 1 会产生很多的代理类
 * 2 产生的代理类只能代理既定的接口
 *
 * @author lxcecho 909231497@qq.com
 * @Copyright: Copyright (c) 2021
 * @since 17.04.2021
 */
public class MemberStaticImpl extends MemberDaoImpl {
    @Override
    public String query(String name, Integer age) {
        System.out.println("==========log=============");
        return super.query(name, age);
    }
}
