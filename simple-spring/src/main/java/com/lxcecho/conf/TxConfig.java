package com.lxcecho.conf;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 声明式事务
 * 1. 导入依赖：数据源、数据库驱动、spring-jdbc 模块
 * 2. 配置数据源、JdbcTemplate（Spring 提供的简化数据库操作工具）操作数据
 * 3. 给方法上标注 @Transactional 表示当前方法是一个事务方法
 * 4. @EnableTransactionManagement 开启基于注解的事务管理功能
 * 5. 配置事务管理器来控制事务：PlatformTransactionManager
 * <p>
 * 原理：
 * 1. @EnableTransactionManagement
 * 利用 TransactionManagementConfigurationSelector 给容器中导入两个组件：
 * 1）AutoProxyRegistrar：给容器中注册一个 InfrastructureAdvisorAutoProxyCreator 组件，SmartInstantiationAwareBeanPostProcessor ？
 * 利用后置处理器机制在对象创建以后，包装对象，返回一个代理对象【增强器】，代理对象执行方法利用拦截器链进行调用；
 * 2）ProxyTransactionManagementConfiguration 做了什么？
 * a.给容器中注册事务增强器：
 * 事务增强器要用事务注解的信息，AnnotationTransactionAttribute 解析事务注解；
 * 事务拦截器：TransactionInterceptor：保存了事务属性信息，事务管理器；
 * 它是一个 MethodInterceptor，在目标方法执行的时候，执行拦截器链；
 * 事务拦截器：
 * 1）先获取事务相关属性；
 * 2）在获取 PlatformTransactionManager，如果事先没有添加指定任何 transactionManager，最最终会从容器中按照类型获取一个 PaltformTransactionManager；
 * 3）执行目标方法：如果异常，获取到事务管理器，利用事务管理器回滚操作；如果正常，利用事务管理器，提交事务。
 *
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/11/8
 */
@EnableTransactionManagement
@Configuration
@ComponentScan("com.lxcecho")
@PropertySource("classpath:/db.properties")
public class TxConfig {

	@Autowired
	private Environment env;

	/**
	 * 注册数据源组件
	 *
	 * @return
	 */
	@Bean(name="dataSource")
	public DataSource dataSource(){
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() throws Exception {
		// Spring 会对 Configuration 类会做特殊处理：给容器中加组件的方法，多次调用都只是从容器中找组件
		return new JdbcTemplate(dataSource());
	}

	/**
	 * 注册事务管理器在容器中
	 *
	 * @return
	 * @throws Exception
	 */
	@Bean
	public PlatformTransactionManager transactionManager() throws Exception {
		return new DataSourceTransactionManager(dataSource());
	}

}
