package com.xc.joy.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author lxcecho 909231497@qq.com
 * @since 03.05.2022
 */
@EnableAspectJAutoProxy // 开启自动代理
@Configuration
@ComponentScan("com.xc.joy.aop")
public class AopOpenConfig {
}
