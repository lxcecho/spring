package com.lxcecho.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/11/11
 */
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {

	/**
	 * 当容器中发布此事件以后，方法触发
	 *
	 * @param event the event to respond to
	 */
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		// TODO Auto-generated method stub
		System.out.println("收到事件：" + event);
	}

}

