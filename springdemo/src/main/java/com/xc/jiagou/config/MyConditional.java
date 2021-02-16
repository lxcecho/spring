package com.xc.jiagou.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
public class MyConditional implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		if(context.getBeanFactory().containsBean("cat"))
			return true;
		return false;
	}
}
