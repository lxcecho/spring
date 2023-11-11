package com.lxcecho.service.impl;

import com.lxcecho.dao.BookDao;
import com.lxcecho.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * 名字默认是类名首字母小写
 *
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/11/11
 */
@Service
public class BookServiceImpl implements BookService {

//	 @Qualifier("bookDao")
//	 @Autowired(required=false)
//	 @Resource(name="bookDao2")
	@Inject
	private BookDao bookDao;

	@Override
	public void print() {
		System.out.println(bookDao);
	}

	@Override
	public String toString() {
		return "BookService [bookDao=" + bookDao + "]";
	}
}
