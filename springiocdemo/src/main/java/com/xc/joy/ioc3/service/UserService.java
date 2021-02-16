package com.xc.joy.ioc3.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;


/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
@Component
//@Lazy
//@Scope(scopeName = "prototype")
public class UserService{



	public UserService(MyService myService) {
		System.out.println("=====UserService Constructor======");
	}

	public void find(){

		System.out.println("====find====");
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
