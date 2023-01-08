package com.xc.joy;

import com.xc.joy.beans.Cat;
import com.xc.joy.beans.Person;
import com.xc.joy.conf.AppConfig;
import com.xc.joy.dao.TestDao;
import com.xc.joy.beans.Users;
import com.xc.joy.service.Demo1;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author lxcecho 909231497@qq.com
 * @Copyright: Copyright (c) 2021
 * @since 07.04.2021
 */
public class MainApplicationTest {

	/**
	 * 关于 spring 容器管理 Bean 的过程及加载模式
	 * 1. 需要将 bean 的定义信息声明在 spring 的配置文件当中
	 * 2. 需要通过 spring 抽象出的各种 resource 来制定对应的配置文件
	 * 3. 需要显式声明一个 spring 工厂，用来掌控在配置文件
	 * 中所声明的的各种 bean 以及 bean 之间的依赖关系和注入关系
	 * 4. 需要定义一个配置信息读取器，用来读取之前定义的 bean 配置文件信息
	 * 5. 读取器租用：读取声明的配置信息，并且将读取信息装配到声明的工厂中
	 * 6. 将读取器与工厂以及资源对象进行关联处理
	 * 7. 工厂所管理的全部对象封装完毕，可以供客户端直接调用。
	 *
	 * Spring 对于 Bean 管理的核心组件
	 * 1. 资源抽象
	 * 2. 工厂
	 * 3. 配置信息读取器
	 *
	 * BeanFactory 是 spring 最顶层的抽象
	 *
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		Resource resource = new ClassPathResource("beans.xml");
		DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
		BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
		beanDefinitionReader.loadBeanDefinitions(resource);

		Person person = (Person)defaultListableBeanFactory.getBean("person");
		System.out.println(person);

		// bring in some property values from a Properties file
//		PropertySourcesPlaceholderConfigurer cfg = new PropertySourcesPlaceholderConfigurer();
//		cfg.setLocation(new FileSystemResource("jdbc.properties"));

		// now actually do the replacement
//		cfg.postProcessBeanFactory(defaultListableBeanFactory);
	}

	public static void main0(String[] args) {
		/**
		 * xml 版 Spring 的用法，beanDefinitionMap 调试 —— beans.xml
		 * AbstractApplicationContext 构造器 和 registerBean 断点
		 */
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
		// 多个资源文件路径可以用 ,;\t\n 等分隔
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml, beans2.xml");
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"beans.xml, beans2.xml"});

//		Person bean = context.getBean(Person.class);
		// 生命周期 cat
		Cat bean = context.getBean(Cat.class);
		System.out.println(bean);
	}


	public static void main1(String[] args) {
		System.out.println("Hello, lxcecho.");

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(TestDao.class);
		context.refresh();
		TestDao dao = context.getBean(TestDao.class);
		dao.query();
	}

	public static void main2(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println(context.getBean(Demo1.class));
	}

	public static void main3(String[] args) {
		// 定义一个 BeanDefinition
		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
		// 当前 Bean 对象的类型
		beanDefinition.setBeanClass(Users.class);

		// 设置  Bean 的其他属性

		/*// 设置作用域
		beanDefinition.setScope("prototype");
		// 设置初始化方法
		beanDefinition.setInitMethodName("init");
		// 设置自动装配类型
		beanDefinition.setAutowireMode(AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE);*/

		// 将 BeanDefinition 注册到 BeanFactory
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		beanFactory.registerBeanDefinition("user", beanDefinition);
		// 获取 Bean
		System.out.println(beanFactory.getBean("user"));
	}

	public static void main4(String[] args) {
		/*DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader = new AnnotatedBeanDefinitionReader(beanFactory);
		// 将 Users.class 解析为 BeanDefinition
		annotatedBeanDefinitionReader.register(Users.class);
		System.out.println(beanFactory.getBean(Users.class));*/

		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
		int i = xmlBeanDefinitionReader.loadBeanDefinitions("beans.xml");
		System.out.println(beanFactory.getBean("user"));

		/**
		 * ClassPathBeanDefinitionScanner
		 * 这个并不是BeanDefinitionReader，但是它的作用和BeanDefinitionReader类似，它可以进行扫描，扫描某个包路径，
		 * 对扫描到的类进行解析，比如，扫描到的类上如果存在@Component注解，那么就会把这个类解析为一个BeanDefinition。
		 */
	}

	public static void main5(String[] args) {
		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
		beanDefinition.setBeanClass(Users.class);

		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		// 注册 BeanDefinition
		beanFactory.registerBeanDefinition("user", beanDefinition);
		// 注册别名
		beanFactory.registerAlias("user", "user11");
		// now register any needed BeanPostProcessor instances
		// 注册 BeanPostProcessor
		beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
			@Override
			public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
				return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
			}

			@Override
			public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
				return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
			}
		});
		// now start using the factory
		// 获取 Bean 对象
		System.out.println(beanFactory.getBean("user11"));
		// 根据类型获取 beanNames
		String[] beanNamesForType = beanFactory.getBeanNamesForType(Users.class);
		for (String s : beanNamesForType) {
			System.out.println(s);
		}
		System.out.println(beanFactory.getBeanNamesForType(Users.class));
	}


}
