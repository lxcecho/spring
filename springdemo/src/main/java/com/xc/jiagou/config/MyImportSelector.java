package com.xc.jiagou.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
public class MyImportSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{"com.xc.jiagou.bean.Cat"};
	}
}
