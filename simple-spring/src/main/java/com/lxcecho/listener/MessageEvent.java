package com.lxcecho.listener;

import org.springframework.context.ApplicationEvent;

import java.io.Serializable;

/**
 * 事件需要实现序列化接口
 *
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/5/28
 */
public class MessageEvent extends ApplicationEvent implements Serializable {

	private static final long serialVersionUID = 0L;

	/**
	 * Create a new {@code ApplicationEvent}.
	 *
	 * @param source the object on which the event initially occurred or with
	 *               which the event is associated (never {@code null})
	 */
	public MessageEvent(Object source) {
		super(source);
	}

	@Override
	public String toString() {
		return "MessageEvent{" +
				"source=" + source +
				'}';
	}
}
