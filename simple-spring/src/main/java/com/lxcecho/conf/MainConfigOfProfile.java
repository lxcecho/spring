package com.lxcecho.conf;

import com.alibaba.druid.pool.DruidDataSource;
import com.lxcecho.entity.Yellow;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

/**
 * Profile：
 * 		Spring 为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能；
 *
 * 开发环境、测试环境、生产环境；
 * 数据源：(/A)(/B)(/C)；
 *
 *
 * @Profile：指定组件在哪个环境的情况下才能被注册到容器中，不指定，任何环境下都能注册这个组件
 *
 * 1）、加了环境标识的 bean，只有这个环境被激活的时候才能注册到容器中。默认是 default 环境
 * 2）、写在配置类上，只有是指定的环境的时候，整个配置类里面的所有配置才能开始生效
 * 3）、没有标注环境标识的 bean 在，任何环境下都是加载的；
 *
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/11/11
 */

@PropertySource("classpath:/db.properties")
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware {

	@Value("${jdbc.username}")
	private String username;

	private StringValueResolver valueResolver;

	private String driverClass;


	@Bean
	public Yellow yellow() {
		return new Yellow();
	}

	@Profile("test")
	@Bean("testDataSource")
	public DataSource dataSourceTest(@Value("${db.password}") String pwd) throws Exception {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUsername(username);
		dataSource.setPassword(pwd);
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setDriverClassName(driverClass);
		return dataSource;
	}


	@Profile("dev")
	@Bean("devDataSource")
	public DataSource dataSourceDev(@Value("${db.password}") String pwd) throws Exception {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUsername(username);
		dataSource.setPassword(pwd);
		dataSource.setUrl("jdbc:mysql://localhost:3306/ssm_crud");
		dataSource.setDriverClassName(driverClass);
		return dataSource;
	}

	@Profile("prod")
	@Bean("prodDataSource")
	public DataSource dataSourceProd(@Value("${db.password}") String pwd) throws Exception {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUsername(username);
		dataSource.setPassword(pwd);
		dataSource.setUrl("jdbc:mysql://localhost:3306/demo");
		dataSource.setDriverClassName(driverClass);
		return dataSource;
	}

	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		// TODO Auto-generated method stub
		this.valueResolver = resolver;
		driverClass = valueResolver.resolveStringValue("${db.driverClass}");
	}

}

