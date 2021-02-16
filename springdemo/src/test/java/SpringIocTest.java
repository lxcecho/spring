import com.xc.jiagou.config.AppConfig;
import org.junit.Test;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
public class SpringIocTest {
	@Test
	public void test(){
		BeanDefinitionRegistry registry = new DefaultListableBeanFactory();
		//BeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
		BeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);

		reader.loadBeanDefinitions("spring.xml");

		//System.out.println(registry.getBeanDefinition("user"));
		//System.out.println(Arrays.toString(registry.getBeanDefinitionNames()));

		//System.out.println(((DefaultListableBeanFactory) registry).getBean("a"));
		//System.out.println(((DefaultListableBeanFactory) registry).getBean("&myFactoryBean"));

		//registry.registerBeanDefinition("fox",new RootBeanDefinition(Fox.class));

		//((DefaultListableBeanFactory) registry).getBean("")
		((DefaultListableBeanFactory) registry).getBean("myFactoryBean");

		//registry.registerBeanDefinition("myFactoryBean", BeanDefinition);

		//DefaultListableBeanFactory factoryBean = new DefaultListableBeanFactory();

		//factoryBean.registerBeanDefinition("user",new RootBeanDefinition(User.class));
		//System.out.println(((DefaultListableBeanFactory) registry).getBean("user"));

		//AbstractBeanDefinition beanDefinition = (AbstractBeanDefinition) registry.getBeanDefinition("user");
//		MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
//		mutablePropertyValues.addPropertyValue(new PropertyValue("name","foxxxxx"));
//		mutablePropertyValues.addPropertyValue(new PropertyValue("age",10));
//		beanDefinition.setPropertyValues(mutablePropertyValues);

		//beanDefinition.setAutowireMode(2);
		//System.out.println(((DefaultListableBeanFactory) registry).getBean("user"));

		// 设置属性
		//beanDefinition.getPropertyValues().add("name","xxxx");

		//registry.removeBeanDefinition("user");
		//System.out.println(((DefaultListableBeanFactory) registry).getBean("user"));

		// 抽象类不会被容器实例化
		//RootBeanDefinition beanDefinition2 = new RootBeanDefinition(Animal.class);
		//registry.registerBeanDefinition("animal",beanDefinition2);
		//System.out.println(((DefaultListableBeanFactory) registry).getBean("animal"));

		// create and configure beans
		//ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		//System.out.println(context.getBean("user"));

	}

	@Test
	public void test2(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		context.getBean("b");

		System.out.println(context.getBeanFactory());

		System.out.println(context.getBeanDefinitionNames());


		//UserService userService = (UserService) context.getBean("userServiceImpl");
		//userService.query();

		//context.getBean("animal");

		//关闭容器，销毁bean
		//context.close();
	}

	@Test
	public void test3(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		context.getBean("user");
	}
}
