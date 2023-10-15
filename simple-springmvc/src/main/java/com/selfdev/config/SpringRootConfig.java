package com.selfdev.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * SpringContext 中相关的 bean
 *
 * @author lxcecho azaki0426@gmail.com
 * @since 2023/10/15
 */
@Configuration
@ComponentScan("com.selfdev.service")
public class SpringRootConfig {
}
