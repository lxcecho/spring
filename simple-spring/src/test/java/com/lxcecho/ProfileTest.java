package com.lxcecho;

import com.lxcecho.conf.MainConfigOfProfile;
import com.lxcecho.entity.Yellow;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/11/11
 */
public class ProfileTest {

	/**
	 * 1、使用命令行动态参数: 在虚拟机参数位置加载 -Dspring.profiles.active=test
	 * 2、代码的方式激活某种环境；
	 */
	@Test
	public void test01() {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext();
		// 1、创建一个 applicationContext
		// 2、设置需要激活的环境
		applicationContext.getEnvironment().setActiveProfiles("dev");
		// 3、注册主配置类
		applicationContext.register(MainConfigOfProfile.class);
		// 4、启动刷新容器
		applicationContext.refresh();


		String[] namesForType = applicationContext.getBeanNamesForType(DataSource.class);
		for (String string : namesForType) {
			System.out.println(string);
		}

		Yellow bean = applicationContext.getBean(Yellow.class);
		System.out.println(bean);
		applicationContext.close();
	}

}
