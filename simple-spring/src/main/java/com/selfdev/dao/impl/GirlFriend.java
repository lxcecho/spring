package com.selfdev.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/10/14
 */
@Repository
public class GirlFriend {
	@Autowired
	private BoyFriend boyFriend;
}
