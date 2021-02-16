package com.xc.joy;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

/**
 * @author lxcecho 909231497@qq.com
 * @since 2021/2/16
 */
public class Main {
	public static void main(String[] args) {
		try {
			SpringApplication.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
