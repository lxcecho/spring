package com.lxcecho.conf;

import com.lxcecho.entity.Person;
import org.springframework.context.annotation.*;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/11/11
 */
//@Import({Person.class, AppConfig.MyImportRegister.class})
@Configuration
@ComponentScan("com.lxcecho")
public class ListenerConfig {

	//	@Bean // @Bean 这种方式注册的Bean，@Lookup 不生效
	public Person person() {
		Person person = new Person();
		person.setName("lxcecho");
		return person;
	}

}
