package com.xc.jiagou.config;

import com.xc.jiagou.anno.MyEnableAspectJAutoProxy;
import com.xc.jiagou.bean.Cat;
import com.xc.jiagou.bean.Fox;
import org.springframework.context.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
@ComponentScan("com.xc.jiagou")
@Configuration
//@EnableAspectJAutoProxy
@MyEnableAspectJAutoProxy
//@Import(value = {MyImportBeanDefinitionRegistrar.class,MyImportSelector.class})
public class AppConfig {

//	@Bean
//	public User user(){
//		System.out.println("------return user -----");
//		return new User();
//	}

//	@Bean
//	public UserService userServiceImpl(){
//		return new UserServiceImpl();
//	}

	@Bean
	public Cat cat(){
		return new Cat();
	}

	@Bean
	@Conditional(value = MyConditional.class)
	public Fox fox(){
		return new Fox();
	}

}
