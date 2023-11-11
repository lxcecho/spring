package com.lxcecho;

import com.lxcecho.entity.circle.A;
import com.lxcecho.conf.AppConfig;
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
public class ApplicationEventListenerTest {

	@Test
	public void testEventListener() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		// 测试事件
		AppEventPublisher eventPublisher = applicationContext.getBean(AppEventPublisher.class);
		eventPublisher.publish(new A());
		eventPublisher.publish(new MessageEvent("hello，你好"));
		eventPublisher.publish(new ChangedEvent(eventPublisher, "sending..."));
	}

}
