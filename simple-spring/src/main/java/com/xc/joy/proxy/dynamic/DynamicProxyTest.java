package com.xc.joy.proxy.dynamic;

import com.xc.joy.dao.IndexDao;
import com.xc.joy.dao.impl.MemberDao;

import java.lang.reflect.Proxy;

/**
 * 动态代理测试
 *
 * 可以使用 jvm 参数：-Dsun.misc.ProxyGenerator.saveGeneratedFiles=true 来生成对应的 class 文件
 *
 * @author lxcecho 909231497@qq.com
 * @since 14:41 08-01-2023
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        IndexDao target = new MemberDao();

        /**
         * public static Object newProxyInstance(ClassLoader loader,
         *                                           Class<?>[] interfaces,
         *                                           InvocationHandler h)
         *
         * 1 它会产生一段字符串，代理类的源码
         * 2 把这个字符串输出到一个 .java 文件中（$Proxy.java）
         * 3 会把这个 $Proxy.java 动态编译成一个 $Proxy.class
         * 4 会通过一个类加载器把这个 $Proxy.class 加载到 JVM 中
         * 5 Class.forName("xxx").newInstance 反射实例化这个对象 proxyObject
         * 6 直接产生了在内存中的字节码
         */
        IndexDao proxy = (IndexDao) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new CustomInvocationHandler(target));
        proxy.query("proxy", 111);

    }
}
