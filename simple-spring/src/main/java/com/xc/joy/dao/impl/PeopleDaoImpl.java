package com.xc.joy.dao.impl;

import com.xc.joy.dao.PeopleDao;
import com.xc.joy.model.People;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author lxcecho 909231497@qq.com
 * @since 20:12 08-01-2023
 */
public class PeopleDaoImpl implements PeopleDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void savePeople(People people) {
        String sql = "insert into people(username, age) values(?, ?)";
        this.jdbcTemplate.update(sql, people.getUsername(), people.getAge());
    }
}
