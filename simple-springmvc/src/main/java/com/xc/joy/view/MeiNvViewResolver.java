package com.xc.joy.view;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/5/28
 */
//@Order // SpringBoot 整合的时候，自定义视图解析器需要制定好顺序
//@Component
public class MeiNvViewResolver implements ViewResolver {
	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		//我们只解析 meinv
		if (viewName.startsWith("meinv:")) {
			return new MeiNvView();
		}
		return null;
	}
}
