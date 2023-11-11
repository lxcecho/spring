package com.lxcecho.listener;

import org.springframework.context.ApplicationEvent;

import java.io.Serializable;

/**
 * 事件需要实现序列化接口
 *
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/5/28
 */
public class ChangedEvent extends ApplicationEvent implements Serializable {

	private static final long serialVersionUID = 0L;

	private String state;

	public ChangedEvent(Object source) {
		super(source);
	}

	public String getState() {
		return state;
	}

	@Override
	public String toString() {
		return "ChangedEvent{" +
				"state='" + state + '\'' +
				", source=" + source +
				'}';
	}
}
