package com.pattern.proxy.staticproxy;

import com.pattern.proxy.MemberDao;

/**
 * 静态代理：
 * 1 代理类（ProxyObject） 和 目标类（TargetObject） 实现同一个接口
 * 2 代理对象当中必须包含目标对象
 *
 * @author lxcecho 909231497@qq.com
 * @Copyright: Copyright (c) 2021
 * @since 17.04.2021
 */
public class MemberTime implements MemberDao {

    // TargetObject
    private MemberDao memberDao;

    public MemberTime(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public String query(String name, Integer age) {
        System.out.println("---------before-----time-------------");
        String result = memberDao.query(name, age);
        System.out.println("---------after-----time-------------");
        return result;
    }

}
