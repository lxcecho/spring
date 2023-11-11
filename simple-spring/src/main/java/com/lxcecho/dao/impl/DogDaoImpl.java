package com.lxcecho.dao.impl;

import com.lxcecho.dao.DogDao;
import com.lxcecho.entity.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/11/8
 */
@Transactional(rollbackFor = Exception.class)
@Repository
public class DogDaoImpl implements DogDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(Dog dog) {
		String sql = "insert into dog(name,age)values(?,?)";
		return jdbcTemplate.update(sql, dog.getName(), dog.getAge());
	}

}
