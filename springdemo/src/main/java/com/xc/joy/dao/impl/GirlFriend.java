package com.xc.joy.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GirlFriend {
	@Autowired
	private BoyFriend boyFriend;
}
