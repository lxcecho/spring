package com.lxcecho.service.impl;

import com.lxcecho.dao.DogDao;
import com.lxcecho.entity.Dog;
import com.lxcecho.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/11/8
 */
@Service
public class DogServiceImpl implements DogService {

	@Autowired
	private DogDao dogDao;

	@Override
	public int save(Dog dog) {
		return dogDao.insert(dog);
	}

}
