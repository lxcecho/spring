package com.xc.joy.ioc2.core;


import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(MyImportBeanDefinitionRegistrar.class)
public @interface MyMapperScan {

	String[] value() default {};
}
