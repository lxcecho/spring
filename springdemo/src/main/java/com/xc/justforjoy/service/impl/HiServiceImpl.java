package com.xc.justforjoy.service.impl;

import com.xc.justforjoy.service.HiService;
import org.springframework.stereotype.Service;

/**
 * @author lxcecho
 * @since 2021/1/8
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
		System.out.println("打个Hi招呼...");
	}

	@Override
	public String justWantToSayHi() {
		return "Just only wants to say hi...";
	}
}
