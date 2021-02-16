package com.xc.jiagou.anno;

import com.xc.jiagou.config.MyProxyRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MyProxyRegistrar.class)
public @interface MyEnableAspectJAutoProxy {

}
