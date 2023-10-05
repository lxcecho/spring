package com.xc.joy.aop;

import org.springframework.stereotype.Component;


/**
 * @author lxcecho 909231497@qq.com
 * @since 03.05.2022
 * <p>
 * 切面存在的话就会返回代理对象
 */
@Component // 如果切面存在的话就返回代理对象，将业务逻辑类加到容器中
public class HelloService {

    public HelloService() {
        System.out.println("HelloService Constructor...");
    }

	/**
	 * 会先调用 CglibAopProxy.intercept(); 拦截目标方法的执行
	 * org.springframework.aop.framework.CglibAopProxy.DynamicAdvisedInterceptor#intercept(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], org.springframework.cglib.proxy.MethodProxy)
	 *
	 * @param name
	 * @return
	 */
    public String sayHello(String name) {
        String result = "Hello, " + name;
        System.out.println("result: {" + result + "}");
        int length = name.length();
        return result + "---" + length;
    }

}
