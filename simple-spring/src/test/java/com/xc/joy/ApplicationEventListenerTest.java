package com.xc.joy;

import com.xc.joy.beans.circle.A;
import com.xc.joy.conf.AppConfig;
import com.xc.joy.listener.AppEventPublisher;
import com.xc.joy.listener.ChangedEvent;
import com.xc.joy.listener.MessageEvent;
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
