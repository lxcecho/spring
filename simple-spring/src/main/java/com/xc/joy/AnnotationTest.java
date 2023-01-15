package com.xc.joy;

import com.xc.joy.aop.HelloService;
import com.xc.joy.conf.AppConfig;
import com.xc.joy.model.Eman;
import com.xc.joy.model.EmanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 基于注解和基于 XML 配置的 Spring Bean 在创建时机上存在唯一的不同之处：
 * 1. 基于 XML 配置的方式，Bean 对象的创建是在程序首次从工厂中获取该对象时才创建的；
 * 2. 基于注解配置的方式，Bean 对象的创建是在注解处理器解析相应的 @Bean 注解时调用了该注解所修饰的方法，当该方法执行后，相应的对象自然就已经被创建出来了，
 * 这时，Spring 就会将该对象纳入到工厂的管理范围之内，当我们首次尝试从工厂中获取到该 Bean 对象时，这时，该 Bean 对象实际上已经完成了创建并已被纳入到了
 * 工厂的管理范围之内。
 *
 * @author lxcecho 909231497@qq.com
 * @since 28.08.2021
 */
public class AnnotationTest {

    public static void main0(String[] args) {
        // 注解版 Spring 的用法，XXAware 调试
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // factoryBean 获取
        /*Hello bean = applicationContext.getBean(Hello.class);*/

		/*Person person = applicationContext.getBean(Person.class);
		System.out.println(person);*/

        // 打印所有注册到容器的 bean 实例
		/*String[] names = applicationContext.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}*/

        // 测试 单实例引用非单实例，即 @Lookup
		/*Cat bean = applicationContext.getBean(Cat.class);
		Cat bean1 = applicationContext.getBean(Cat.class);
		System.out.println(bean == bean1);// false*/

		/*Student stu1 = applicationContext.getBean(Student.class);
		Cat cat = stu1.getCat();
		Student stu2 = applicationContext.getBean(Student.class);
		Cat cat1 = stu2.getCat();
		System.out.println(cat == cat1);// true
		System.out.println(cat + "," + cat1);
		System.out.println(stu1 + "," + stu2);*/

        // 循环引用，原理测试
        // AOP，原理测试
        HelloService helloService = applicationContext.getBean(HelloService.class);
        helloService.sayHello("lxcecho");

    }

    public static void main(String[] args) {
        // debug 实现 xxxAware 接口的赋值过程
		/*AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		Person person = applicationContext.getBean(Person.class);
		ApplicationContext context = person.getContext();
		System.out.println(context == applicationContext);*/

        // 相当于xml方式的工厂，内置了reader和scanner
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        // 相当于xml的读取器要读取的位置
        annotationConfigApplicationContext.register(EmanConfig.class);
        // 刷新工厂
        annotationConfigApplicationContext.refresh();
        Eman eman = (Eman) annotationConfigApplicationContext.getBean("eman");

        System.out.println(eman.getName() + "'s age is: " + eman.getAge());

    }

}
