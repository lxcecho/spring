package com.xc.joy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lxcecho 909231497@qq.com
 * @since 16:00 10-07-2022
 */
@RestController
public class HelloController {

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello controller.";
	}

}
