package com.lxcecho;

import com.lxcecho.conf.ListenerConfig;
import com.lxcecho.entity.Person;
import com.lxcecho.listener.AppEventPublisher;
import com.lxcecho.listener.ChangedEvent;
import com.lxcecho.listener.MessageEvent;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/5/28
 */
public class ListenerTest {

	@Test
	public void testEventListener() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ListenerConfig.class);
		// 测试事件
		AppEventPublisher eventPublisher = applicationContext.getBean(AppEventPublisher.class);
		// 发布事件
		eventPublisher.publish(new Person());
		eventPublisher.publish(new MessageEvent("hello，你好"));
		eventPublisher.publish(new ChangedEvent("sending..."));
	}

}
