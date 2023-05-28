package com.xc.joy.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 容器中会拿到所有的事件监听器，挨个遍历调用 onApplicationEvent()
 *
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/5/28
 */
@Component
public class App implements ApplicationListener<ApplicationEvent> {
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("azaki");
	}
}
