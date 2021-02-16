package com.xc.joy.controller;

import com.xc.joy.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author lxcecho
 * @since 2021/1/8
 */
@Controller
public class HiController {

	@Autowired
	private HiService hiService;

	public void handleRequest(){
		hiService.sayHi();
		hiService.justWantToSayHi();
	}
}
