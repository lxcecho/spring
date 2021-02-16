package com.xc.joy.ioc.config;

import com.xc.joy.ioc.bean.Fox;
import com.xc.joy.ioc.bean.MyImportBeanDefinitionRegistrar;
import com.xc.joy.ioc.bean.MyImportSelector;
import org.springframework.context.annotation.*;

/**
 * @author lxcecho
 * @since 2021/2/16
 */
@Configuration
@Import({MyImportBeanDefinitionRegistrar.class, MyImportSelector.class})
@ComponentScan("com.xc.joy.ioc")
public class AppConfig {

	@Bean(initMethod = "initXml",destroyMethod = "destroyXml")
	// method.invoke
	//@Scope("prototype")
	public Fox fox(){
		// 多例   ---》 单例   beanFactory.getBean("fox")
		return new Fox();
	}

//	@Bean
//	//@Primary
//	public Fox fox2(){
//		// 多例   ---》 单例   beanFactory.getBean("fox")
//		return new Fox();
//	}


//	@Bean
//	public User user(){
//		//  ConfigurationClassBeanDefinition
//		return new User();
//	}
//
//	@Bean
//	public User user3(){
//		return new User(fox());
//	}

}
