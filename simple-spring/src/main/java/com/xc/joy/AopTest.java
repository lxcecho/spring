package com.xc.joy;

import com.xc.joy.proxy.dao.IndexDao;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 关于 spring AOP 代理的生成过程:
 * 1. 通过 ProxyFactoryBean (FactoryBean 接口的实现)来去配置相应的代理对象相关的信息。
 * 2. 在获取 ProxyFactoryBean 实例时，本质上并不是获取到 ProxyFactoryBean 的对象，而是获取到了由 ProxyFactoryBean 所返回的那个对象实例。
 * 3. 在整个 ProxyFactoryBean 实例的构建与缓存的过程中，其流程与普通的 Bean 对象完全一致。
 * 4. 差别在于，当创建了 ProxyFactoryBean 对象后，Spring 会判断当前所创建的对象是否是一 个FactoryBean 实例。
 * 5. 如果不是，那么 spring 就直接将所创建的对象返回。
 * 6. 如果是，spring 则会进入到一个新的流程分支当中。
 * 7. Spring 会根据我们在配置信息中所指定的各种元素，如目标对象是否实现了接口以及 Advisor 等信息，使用动态代理或是CGLIB等方式来为目标对象创建相应的代理对象。
 * 8. 当相应的代理对象创建完毕后，Spring 就会通过 ProxyFactoryBean 的 getObject 方法，将所创建的对象返回。
 * 9. 对象返回到调用端(客户端)，它本质上是一个代理对象，可以代理对目标对象的访问与调用，这个代理对象对用户来说，就好像一个目标对象一样。
 * 10，客户在使用代理对象时，可以正常调用目标对象的方法，同时在执行过程中，会根据我们在配置文件中所配置的信息来在调用前后执行额外的附加逻辑。
 *
 * @author lxcecho 909231497@qq.com
 * @since 22:19 02-01-2023
 */
public class AopTest {

    public static void main(String[] args) {
        Resource resource = new ClassPathResource("aop-test.xml");
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        beanDefinitionReader.loadBeanDefinitions(resource);

        IndexDao indexDao = (IndexDao) defaultListableBeanFactory.getBean("myAop");
        indexDao.query("lxcecho", 111);

        for (int i = 0; i < indexDao.getClass().getInterfaces().length; i++) {
            System.out.println(indexDao.getClass().getInterfaces()[i]);
        }


    }

}
