package com.xc.joy.ioc3.config;

import com.xc.joy.ioc3.aop.AopMethodInterceptor;
import com.xc.joy.ioc3.bean.MyImportBeanDefinitionRegistrar;
import com.xc.joy.ioc3.bean.MyImportSelector;
import com.xc.joy.ioc3.service.MyService;
import com.xc.joy.ioc3.service.UserService;
import org.aopalliance.aop.Advice;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
@ComponentScan("com.xc.joy.ioc3")
@Configuration  //  AppConfig  ---- AppConfig@EnchancerByCglib
@Import({MyImportBeanDefinitionRegistrar.class, MyImportSelector.class})
//@ImportResource("spring.xml")
public class AppConfig {


	/*@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}*/


	/*@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		return factoryBean.getObject();
	}*/

// 反射   method.invoke(obj,args)
//	@Bean(initMethod="init", destroyMethod="destory")
//	public Cat cat(){
//		//
//		return new Cat();
//	}


	@Bean
	public Advice aopMethodInterceptor(){
		return new AopMethodInterceptor();
	}
//
//	//使用BeanNameAutoProxyCreator来创建代理
//	@Bean
//	public BeanNameAutoProxyCreator beanNameAutoProxyCreator(){
//		BeanNameAutoProxyCreator beanNameAutoProxyCreator=new BeanNameAutoProxyCreator();
//		//设置要创建代理的 beanNames  类
//		beanNameAutoProxyCreator.setBeanNames("*Service");
//		//设置拦截链名字(有先后顺序)   通知
//		beanNameAutoProxyCreator.setInterceptorNames("aopMethodInterceptor");
//		return beanNameAutoProxyCreator;
//	}


	@Bean
	public NameMatchMethodPointcutAdvisor nameMatchMethodPointcutAdvisor(){
		NameMatchMethodPointcutAdvisor nameMatchMethodPointcutAdvisor=
				new NameMatchMethodPointcutAdvisor();
		// 方法级别
		nameMatchMethodPointcutAdvisor.setMappedNames("query*","find*");
		nameMatchMethodPointcutAdvisor.setAdvice(aopMethodInterceptor());
		return nameMatchMethodPointcutAdvisor;
	}

	@Bean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
		return new DefaultAdvisorAutoProxyCreator();
	}


//
//	@Bean
//	@Conditional(value = MyConditional.class)
//	public Fox fox(){
//		return new Fox();
//	}

    @Bean  // method bean  beanName    method.invoke
    public MyService myService() {
        return new MyService();
    }

    @Bean
	//@Primary
	public UserService userService2(){
		return new UserService(myService());
	}
}