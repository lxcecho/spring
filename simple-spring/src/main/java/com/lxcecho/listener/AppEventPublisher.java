package com.lxcecho.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * 事件发布器
 *
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/5/28
 */
@Component
public class AppEventPublisher implements ApplicationEventPublisherAware {

	ApplicationEventPublisher publisher;

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.publisher = applicationEventPublisher;
	}

	public void publish(ApplicationEvent event) {
		publisher.publishEvent(event);
	}

	public void publish(Object o) {
		publisher.publishEvent(o);
	}

}
