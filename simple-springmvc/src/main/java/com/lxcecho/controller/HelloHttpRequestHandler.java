package com.lxcecho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * BeanNameUrlHandlerMapping 创建好对象以后也要初始化，启动拿到容器中所有组件，看谁的名字是以 / 开始的，就把这个组件注册为处理器
 *
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/5/28
 */
@Controller("/helloReq") // BeanNameUrlHandlerMapping 就会把他注册进去
public class HelloHttpRequestHandler implements HttpRequestHandler {

	// 启用 HttpRequestHandlerAdapter

	/**
	 * 处理请求
	 *
	 * @param request current HTTP request
	 * @param response current HTTP response
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write("HelloHttpRequestHandler....");
	}
}
