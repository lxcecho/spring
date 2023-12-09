package com.junit;

import com.lxcecho.conf.EmanConfig;
import com.lxcecho.entity.Boss;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/12/9
 */
//@SpringJUnitConfig(locations = {"classpath:spring-context.xml"})  //指定配置文件xml
@SpringJUnitConfig(value = {EmanConfig.class})  //指定配置类
public class MyJunitTest {

	@Autowired
	private Boss boss;

	@Test
	public void testJunit5() {
		System.out.println(boss);
	}
}
