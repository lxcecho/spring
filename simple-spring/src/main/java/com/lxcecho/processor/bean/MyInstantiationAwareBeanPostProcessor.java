package com.lxcecho.processor.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author lxcecho 909231497@qq.com
 * @since 20.06.2021
 */
@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
	public MyInstantiationAwareBeanPostProcessor() {
		System.out.println("MyInstantiationAwareBeanPostProcessor.......Constructor");
	}

	/**
	 * 初始化之前进行后置处理，Spring 留给我们给这个组件创建对象的回调
	 *
	 * @param beanClass the class of the bean to be instantiated
	 * @param beanName  the name of the bean
	 * @return
	 * @throws BeansException
	 */
	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
 		System.out.println("MyInstantiationAwareBeanPostProcessor...postProcessBeforeInstantiation=>" + beanClass + "--" + beanName);
		// 如果我们自己创建了对象返回。Spring 则不会帮我们创建对象，用我们自己创建的对象？ 我们创建的这个对象，Spring 会保存单实例？还是每次 getBean 都调到我们这里创建一个新的？
		/*if(beanClass.isAssignableFrom(Cat.class)) {
			return new Dog();
		}*/
		return null;
	}

	/**
	 * 初始化之后进行处理
	 *
	 * @param bean the bean instance created, with properties not having been set yet
	 * @param beanName the name of the bean
	 * @return
	 * @throws BeansException
	 */
	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		// 提前改变一些 Spring 不管的 bean 里面的属性
		System.out.println("MyInstantiationAwareBeanPostProcessor...postProcessAfterInstantiation=>" + bean + "--" + beanName);
		// 返回 false 则 bean 的赋值全部结束
		return true;
	}

	/**
	 * 解析自定义注解进行属性值注入；pvs 封装了所有的属性信息。
	 *
	 * @param pvs      the property values that the factory is about to apply (never {@code null})
	 * @param bean     the bean instance created, but whose properties have not yet been set
	 * @param beanName the name of the bean
	 * @return
	 * @throws BeansException
	 */
	@Override
	public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
			throws BeansException {
		System.out.println("MyInstantiationAwareBeanPostProcessor...postProcessProperties=>" + bean + "--" + beanName);
		return null;
	}
//	public PropertyValues postProcessPropertyValues(
//			PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
//		System.out.println("MyInstantiationAwareBeanPostProcessor...postProcessProperties");
//		return pvs;
//	}
}

