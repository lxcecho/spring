package com.xc.joy.listener;

import org.springframework.context.ApplicationEvent;

import java.io.Serializable;

/**
 * 事件需要实现序列化接口
 *
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/5/28
 */
public class ChangedEvent extends ApplicationEvent implements Serializable {

	private static final Long serialVersionUID = 0L;

	private String state;

	/**
	 * Create a new {@code ApplicationEvent}.
	 *
	 * @param source the object on which the event initially occurred or with
	 *               which the event is associated (never {@code null})
	 */
	public ChangedEvent(Object source) {
		super(source);
	}

	public ChangedEvent(Object source, String state) {
		super(source);
		this.state = state;
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
