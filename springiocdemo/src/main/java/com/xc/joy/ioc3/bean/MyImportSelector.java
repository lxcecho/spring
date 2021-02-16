package com.xc.joy.ioc3.bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
public class MyImportSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		// beanName="bat.ke.qq.com.bean.Fox"
		return new String[]{Fox.class.getName()};
}
}
