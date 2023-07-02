package com.xc.joy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 自定义异常上有注解的
 *
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/5/28
 */
@ResponseStatus(value = HttpStatus.CONFLICT, reason = "非法用户")
public class InvalidUserException extends RuntimeException {

	private static final long serialVersionUID = -7034897190745766222L;

}
