package com.selfdev.controller;

import com.selfdev.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/10/14
 */
@Controller
public class HiController {
	@Autowired
	private HiService hiService;

	public void handleRequest() {
		hiService.sayHi();
		hiService.justWantToSayHi();
	}
}
