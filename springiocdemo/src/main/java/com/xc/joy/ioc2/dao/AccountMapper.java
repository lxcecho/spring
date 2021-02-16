package com.xc.joy.ioc2.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
public interface AccountMapper {

	@Select("select * from account")
	public List<Map<String,String>> query();
}
