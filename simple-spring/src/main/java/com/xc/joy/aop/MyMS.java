package com.xc.joy.aop;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @author lxcecho 909231497@qq.com
 * @since 03.05.2022
 */
//@Component
public class MyMS implements MessageSource {


	@Override
	public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
		return null;
	}

	@Override
	public String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException {
		return null;
	}

	@Override
	public String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException {
		return null;
	}
}
