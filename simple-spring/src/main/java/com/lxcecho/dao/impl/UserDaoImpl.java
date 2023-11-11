package com.lxcecho.dao.impl;

import com.lxcecho.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/10/11
 */
public class UserDaoImpl {

	private JdbcTemplate jdbcTemplate;

	public User findById(Integer id) {
		String sql = "select * from user where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<User>(User.class));
	}

	public Integer insert(User user) {
		String sql = "insert into user(name,age)values(?,?)";
		return jdbcTemplate.update(sql, user.getName(), user.getAge());
	}

	public Integer update(User user) {
		String sql = "update user set name=?, age=? where id=?";
		return jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getId());
	}

	public Integer delete(Integer id) {
		String sql = "delete from user where id=?";
		return jdbcTemplate.update(sql, id);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
