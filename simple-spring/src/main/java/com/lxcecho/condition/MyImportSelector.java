package com.lxcecho.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义逻辑返回需要导入的组件
 *
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/11/11
 */
public class MyImportSelector implements ImportSelector {

	/**
	 * @param importingClassMetadata AnnotationMetadata:当前标注 @Import 注解的类的所有注解信息
	 * @return 返回值，就是到导入到容器中的组件全类名
	 */
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		// TODO Auto-generated method stub
		// importingClassMetadata
		// 方法不要返回 null 值
		return new String[]{"com.lxcecho.entity.Blue", "com.lxcecho.entity.Yellow"};
	}
}
