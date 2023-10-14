package com.lxcecho.proxy.staticproxy;

import com.lxcecho.dao.IndexDao;

/**
 * 静态代理：
 * 1 代理类（ProxyObject） 和 目标类（TargetObject） 实现同一个接口
 * 2 代理对象当中必须包含目标对象
 *
 * @author lxcecho 909231497@qq.com
 * @Copyright: Copyright (c) 2021
 * @since 17.04.2021
 */
public class MemberTime implements IndexDao {

    // TargetObject
    private IndexDao indexDao;

    public MemberTime(IndexDao indexDao) {
        this.indexDao = indexDao;
    }

    @Override
    public String query(String name, Integer age) {
        System.out.println("---------before-----time-------------");
        String result = indexDao.query(name, age);
        System.out.println("---------after-----time-------------");
        return result;
    }

}
