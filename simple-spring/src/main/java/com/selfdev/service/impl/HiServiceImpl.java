package com.selfdev.service.impl;

import com.selfdev.service.HiService;
import org.springframework.stereotype.Service;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/10/14
 */
@Service
public class HiServiceImpl implements HiService {
	@Override
	public void sayHi() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Hi everyone");
	}

	@Override
	public String justWantToSayHi() {
		return "Just want to say hi";
	}
}
