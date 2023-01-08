package com.xc.joy.service.impl;

import com.xc.joy.dao.PeopleDao;
import com.xc.joy.model.People;
import com.xc.joy.service.PeopleService;

/**
 * @author lxcecho 909231497@qq.com
 * @since 20:17 08-01-2023
 */
public class PeopleServiceImpl implements PeopleService {

    private PeopleDao peopleDao;

    public void setPeopleDao(PeopleDao peopleDao) {
        this.peopleDao = peopleDao;
    }

    @Override
    public void savePeople(People people) {
        this.peopleDao.savePeople(people);
    }
}
