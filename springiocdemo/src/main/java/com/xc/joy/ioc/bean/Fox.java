package com.xc.joy.ioc.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author lxcecho
 * @since 2021/2/16
 */
@Component
public class Fox implements InitializingBean, DisposableBean {

	public Fox(){
		System.out.println("new fox()");
	}

	@PostConstruct
	public void init(){
		// before   Todo
		System.out.println("PostConstruct init");
	}

	public void initXml(){
		System.out.println("xml init");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean init");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean destroy");
	}


	public void destroyXml(){
		//
		System.out.println("xml destroy");
	}

	@PreDestroy
	public void destroy2()  {
		System.out.println("PreDestroy  destroy");
	}

}
