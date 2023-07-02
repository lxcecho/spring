package com.xc.joy.view;

import java.util.Map;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/5/28
 */
public class MeiNvView implements View {

	/**
	 * 自定义的渲染逻辑
	 *
	 * @param model a Map with name Strings as keys and corresponding model
	 * objects as values (Map can also be {@code null} in case of empty model)
	 * @param request current HTTP request
	 * @param response he HTTP response we are building
	 * @throws Exception
	 */
	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.setContentType("text/html;charset=utf-8");
		StringBuffer stringBuffer = new StringBuffer();
		String name = request.getParameter("name");
		stringBuffer.append("<h1>" + name + "</h1>");
		stringBuffer.append("<h2>" + model.get("info") + "</h2>");
		stringBuffer.append("<img src='https://t7.baidu.com/it/u=3676218341,3686214618&fm=193&f=GIF'/>");

		response.getWriter().write(stringBuffer.toString());

	}
}

