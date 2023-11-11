package com.lxcecho.controller;

import com.lxcecho.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/11/11
 */
@Controller
public class BookController {

	@Autowired
	private BookService bookService;

}
