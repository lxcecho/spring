package com.lxcecho.conf;

import com.lxcecho.entity.People;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 使用 @PropertySource 读取外部配置文件中的 k/v 保存到运行的环境变量中；加载完外部的配置文件以后使用 ${} 取出配置文件的值
 *
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/11/11
 */
@PropertySource(value={"classpath:/people.properties"})
@Configuration
public class PropertyValuesConfig {

	@Bean
	public People people(){
		return new People();
	}

}

