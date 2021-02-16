package com.xc.joy.ioc3.bean;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
   @Override
   public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
   		// bean --- beanDefiniton
	   // BeanDefinitionRegistry bean定义的注册器   id--- beanName   map  beanName---beanDefiniton
      //创建BeanDefinition
      RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Tiger.class);
      // 注册到容器     fox--- rootBeanDefinition
      registry.registerBeanDefinition("tiger",rootBeanDefinition);

      // 1  byName   setCat
	   // 2 byType     传参

      rootBeanDefinition.setAutowireMode(3);

	   Constructor<?>[] candidates = (rootBeanDefinition.isNonPublicAccessAllowed() ?
			   rootBeanDefinition.getBeanClass().getDeclaredConstructors() : rootBeanDefinition.getBeanClass().getConstructors());

//	   Arrays.sort(candidates, (e1, e2) -> {
//		   int result = Boolean.compare(Modifier.isPublic(e2.getModifiers()), Modifier.isPublic(e1.getModifiers()));
//		   return result != 0 ? result : Integer.compare(e2.getParameterCount(), e1.getParameterCount());
//	   });
//
//	   int minTypeDiffWeight = Integer.MAX_VALUE;
////	   int typeDiffWeight = (rootBeanDefinition.isLenientConstructorResolution() ?
////			   argsHolder.getTypeDifferenceWeight(paramTypes) : argsHolder.getAssignabilityWeight(paramTypes));




   }
}