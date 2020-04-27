package com.mydemo.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author hz
 * @Description:
 * @create 2020-04-27
 */
@Configuration
@ComponentScan("com.mydemo.aop")
@EnableAspectJAutoProxy(proxyTargetClass=false)
public class AspectJConfig {
}
