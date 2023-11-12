package com.lxcecho.listener;

import com.lxcecho.entity.circle.A;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 事件监听器：为什么一个注解就能监听事件？？？
 * Datasource、TransactionManager(切面)===DBService
 *
 * @author lxcecho azaki0426@gmail.com
 * @EnableTransactionManager
 * @since 2023/5/28
 */
@Component
public class AppEventListener {

	public AppEventListener() {
		System.out.println("AppEventListener ...");
	}

	/**
	 * 监听事件
	 *
	 * @param event
	 */
	@EventListener(MessageEvent.class)
	public void listenMessage(MessageEvent event) {
		System.out.println("Message 事件到达..." + event + "; 已发送邮件...");
	}

	@EventListener(ChangedEvent.class)
	public void listenChange(ChangedEvent event) {
		System.out.println("Change 事件到达..." + event + "; 已同步状态...");
	}

	@EventListener(PayloadApplicationEvent.class)
	public void listenPayload(PayloadApplicationEvent<A> event) {
		System.out.println("Payload 事件到达..." + event.getPayload() + "; 已进行处理");
	}

	@EventListener(classes = {ApplicationEvent.class})
	public void listen(ApplicationEvent event) {
		System.out.println("Test。。监听到的事件：" + event);
	}

}
