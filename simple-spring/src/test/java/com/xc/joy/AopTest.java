package com.xc.joy;

import com.xc.joy.aop.HelloService;
import com.xc.joy.conf.AopOpenConfig;
import com.xc.joy.conf.AppConfig;
import com.xc.joy.dao.IndexDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
 * @since 21:44 16-04-2023
 */
public class AopTest {

    /**
     * Spring AOP:【动态代理】
     * 		指在程序运行期间【动态】的将某段代码切入到指定方法指定位置进行运行的编程方式。
     * 1）导入 AOP 模块：spring-aop：spring-aspects 包
     * 2）定义一个业务逻辑（HelloService），在业务逻辑运行的时候将日志进行打印（方法之前、方法运行结束、方法出现异常、XXX）
     * 3）定义一个日志切面类（LogAspects），切面类里面的方法要动态感知 HelloService#sayHello 运行到那里然后执行。
     * 		通知方法：
     * 			前置通知(@Before)：logStart();在目标方法（div）之前运行；
     * 			后置通知(@After)：logEnd();在目标方法运行结束之后运行；无论方法是正常结束还是异常结束，都会调用。
     * 			返回通知(@AfterReturning)：logReturning();在目标方法正常返回之后执行；
     * 			异常通知(@AfterThrowing)：logException();在目标方法出现异常之后运行；
     *  		环绕通知(@Around)：动态代理，手动推进目标方法运行（JoinPoint.proceed()）.
     * 4）给切面类的目标方法标注何时何地运行（通知注解）;
     * 5）将切面类 LogAspect 和业务逻辑类 HelloService（目标方法所在类）都加入到容器中；
     * 6）告诉 Spring 哪个类是切面类，给切面类加上一个注解 @Aspect；
     * 【7】给配置类中加 @EnableAspectJAutoProxy【开启基于注解的 AOP 模式】；在 Spring 中很多的 @EnableXXX 注解；
     * 	XML: <aop:aspectj-autoproxy></aop:aspectj-autoproxy> // 开启基于注解版的切面功能
     *
     * 三步：
     * 	1.将【业务逻辑组件】和【切面类】加入到容器中，告诉 Spring 哪个是切面类（@Aspect）；
     * 	2.在切面类上每一个通知方法上标注注解，告诉 Spring 何时何地运行（切入点表达式 Pointcut）
     * 	3.开启基于注解的 AOP 模式（@EnableAspectJAutoProxy）。
     *
     * AOP原理：********【TODO 给容器中注册了什么组件，这个组件什么时候工作，包括这个组件工作时候的功能？？？】***********
     *        @EnableAspectJAutoProxy
     * 1.@EnableAspectJAutoProxy 是什么？
     *    @Import(AspectJAutoProxyRegistrar.class) 给容器中导入 AspectJAutoProxyRegistrar；
     *        利用 AspectJAutoProxyRegistrar 自定义给容器中注册 bean：BeanDefinition
     * 		internalAutoProxyCreator = AnnotationAwareAspectJAutoProxyCreator
     * 	给容器中注册一个 AnnotationAwareAspectJAutoProxyCreator
     *
     * 2.AnnotationAwareAspectJAutoProxyCreator：父类继承关系
     * 		-->AspectJAwareAdvisorAutoProxyCreator
     * 			-->AbstractAdvisorAutoProxyCreator
     * 				-->AbstractAutoProxyCreator implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware
     * 			TODO 关注后置处理器（在 bean 初始化完成前后做事情），自动装配 BeanFactory；
     *
     * AbstractAutoProxyCreator.setBeanFactory()
     *
     * AbstractAutoProxyCreator.postProcessBeforeInstantiation(): 有后置处理器的逻辑
     *
     * AbstractAdvisorAutoProxyCreator.setBeanFactory()-->initBeanFactory()
     *
     * AspectJAwareAdvisorAutoProxyCreator
     *
     * AnnotationAwareAspectJAutoProxyCreator.initBeanFactory()
     *
     * 流程：
     * 	1）传入配置类，创建 IOC 容器；
     * 	2）注册配置类，调用 refresh() 方法刷新容器；
     * 	3）registerBeanPostProcessors(beanFactory)：注册 bean 的后置处理器来方便拦截 bean 的创建；
     * 		1.先获取 IOC 容器已定义了的需要创建对象的所有 BeanPostProcessor；
     * 		2.给容器中添加别的 BeanPostProcessor
     * 		3.优先注册实现了 PriorityOrdered 接口的 BeanPostProcessor；
     * 		4.再给容器中注册实现 Ordered 接口的 BeanPostProcessor；
     * 		5.注册没实现优先级接口的 BeanPostProcessor；
     * 		6.注册 BeanPostProcessor，实际上就是创建 BeanPostProcessor 对象，保存在容器中；
     * 			创建 internalAutoProxyCreator 的 BeanPostProcessor【AnnotationAwareAspectJAutoProxyCreator 为例】
     * 			①创建 Bean 的实例；
     * 			②populateBean() 给 Bean 各种属性赋值；
     * 			③initializeBean：初始化 Bean；
     * 				（1）invokeAwareMethod()：处理 Aware 接口的方法回调；
     * 				（2）applyBeanPostProcessorsBeforeInitialization()：应用后置处理器的 postProcessorsBeforeInitialization()；
     * 				（3）invokeInitMethods() 执行自定义的初始化方法；
     * 				（4）applyBeanPostProcessorsAfterInitialization()：执行后置处理器的 postProcessorsAfterInitialization()；
     * 			④BeanPostProcessor(AnnotationAwareAspectJAutoProxyCreator) 创建成功；-->aspectJAdvisorsBuilder
     * 		7.把 BeanPostProcessor 注册到 BeanFactory 中；
     * 			BeanFactory.addBeanPostProcessor(postProcessor);
     *
     * 	=============以上是创建 AnnotationAwareAspectJAutoProxyCreator 的过程==================
     *
     * 		AnnotationAwareAspectJAutoProxyCreator => InstantiationAwareBeanPostProcessor
     * 	4）finishBeanFactoryInitialization(beanFactory);完成 BeanFactory 初始化工作，创建剩下的单实例 Bean；
     * 		1.遍历获取容器中所有的 Bean，依次创建对象；
     * 			getBean()-->doGetBean()-->getSingleton()-->
     * 		2.创建 Bean；
     * 		【AnnotationAwareAspectJAutoProxyCreator 在所有 Bean 创建之前都有一个拦截，InstantiationAwareBeanPostProcessor 会调用 postProcessBeforeInstantiation()】
     * 			①先从缓存中获取当前 Bean，如果能获取到说明 Bean 是之前被创建过的，直接使用；否则再创建；只要创建好的 Bean 都会被缓存起来；
     * 			②createBean():创建 Bean；AnnotationAwareAspectJAutoProxyCreator 会在任何 Bean 创建之前先尝试返回 Bean 的实例；
     * 			【BeanPostProcessor 是在 Bean 对象创建完成初始化前后调用的】
     * 			【InstantiationAwareBeanPostProcessor 是在创建 Bean 实例之前先尝试用后置处理器返回对象的】
     * 				（1）resolveBeforeInstantiation(beanName,mbdToUse): 解析 BeforeInstantiation；
     * 				    希望后置处理器在此返回一个代理对象，如果能返回代理对象就使用，如果不能就继续；
     * 					——后置处理器先尝试返回对象；
     * 						bean=applyBeanProcessorsBeforeInstantiation();
     * 						拿到所有后置处理器如果是 InstantiationAwareBeanPostProcessor；就执行后置处理器的 postProcessorBeforeInstantiation
     * 						if(bean != null){
     * 						    bean = applyBeanProcessorsBeforeInstantiation(bean,beanName);
     *                      }
     *
     * 				（2）doCreateBean(beanName,mbdToUse,args): 真正的去创建一个 bean 实例，和 3.6 流程一样；
     *
     * AnnotationAwareAspectJAutoProxyCreator【InstantiationAwareBeanPostProcessor】的作用：
     * 1）每一个 bean 创建之前，调用 postProcessBeforeInstantiation();
     * 	    关心 HelloService 和 LogAspects 的创建；
     * 	1.判断当前 bean 是否在 adviseBean 中（保存了所有需要增强 bean）；
     * 	2.判断当前本是否是基础类型的 Advice、Pointcut、Advisor、AopInfrastructureBean 或者是否是切面（@Aspect）；
     * 	3.是否需要跳过：
     * 		①获取候选的增强器（切面里面的通知方法）【List<Advisor> candidateAdvisors】
     * 		 每一个封装的通知方法的增强器是 InstantiationModelAwarePointcutAdvisor,
     * 		 判断每一个增强是否是 AspectJPointcutAdvisor 类型的，返回 true；
     * 		②永远返回 false；
     * 2）创建对象
     * 	postProcessAfterInitialization：
     * 	return wrapIfNecessary(bean,beanName,cacheKey); // 包装如果需要的情况下；
     * 	1.获取当前 bean 的所有增强器（通知方法）；Object[] specificInterceptors
     * 		①找到候选的所有增强器（找哪些通知方法是需要切入当前 bean 方法的）；
     * 		②获取到能在 bean 使用的增强器；
     * 		③给增强器排序；
     * 	2.保存当前 bean 在 advisedBeans 中；
     * 	3.如果当前 bean 需要增强，创建当前 bean 的代理对象；
     * 		①获取所有增强（通知方法）；
     * 		②保存到 ProxyFactory；
     * 		③创建代理对象，Spring 自动决定;
     * 			JdkDynamicAopProxy(config); jdk 动态代理；
     * 			ObjenesisCglibAopProxy(config); cglib 的动态代理；
     * 	4.给容器中返回当前组件使用 cglib 增强了的代理对象；
     * 	5.以后容器中获取到的就是这个组件的代理对象，执行目标方法的时候，代理对象就会执行通知方法的流程。
     *
     * 3）目标方法执行：
     * 	容器中把保存了组件的代理对象（CgLib 增强后的对象），这个对象里面保存了详细信息（比如增强器，目标对象，XXX）；
     * 	1.CglibAopProxy.intercept(); 拦截目标方法的执行；
     * 	2.根据 ProxyFactory 对象获取将要执行的目标方法拦截器链；
     * 		List<Object> chain=this.advised.getInterceptorsAndDynamicInterceptionAdvice(method,targetClass);
     * 		①List<Object> interceptorList 保存所有拦截器；（5个）
     * 		 一个默认的 ExposeInvocationInterceptor 和 4 个增强器；
     * 		②遍历所有的增强器，将其转为 Interceptor:
     * 			registry.getInterceptors(advisor);
     * 		③将增强器转为 List<MethodInterceptor>;
     * 		 如果是 MethodInterceptor，直接加入到集合中；
     * 		 如果不是，使用；AdvisorAdapter 将增强器转为 MethodInterceptor；
     * 		 转换完成返回 MethodInterceptor 数组；
     * 	3.如果没有拦截器，直接执行目标方法；
     * 		拦截器链（每一个通知方法又被包装为方法拦截器，利用 MethodInterceptor 机制）
     * 	4.如果有拦截器，把需要执行的目标方法，拦截器等信息传入创建一个 CglibMethodInvocation 对象，
     * 	  并调用 Object retVal = mi.proceed();
     * 	5.拦截器链的触发过程：
     * 		①如果没有拦截器执行执行目标方法，或者拦截器的索引和拦截器数组-1 大小一样（指定到了最后一个拦截器）执行目标方法；
     * 		②链式获取每一个拦截器，拦截器执行 invoke 方法，每一个拦截器等待下一个拦截器执行完成返回以后再来执行；
     * 		  拦截器链的机制，保证通知方法与目标方法的执行。
     *
     * 总结：
     * 	1.@EnableAspectJAutoProxy 开启 AOP 功能；
     * 	2.@EnableAspectJAutoProxy 会给容器中注册一个组件 AnnotationAwareAspectJAutoProxyCreator；
     * 	3.AnnotationAwareAspectJAutoProxyCreator 是一个后置处理器；
     * 	4.容器的创建流程：
     * 		1）registerBeanPostProcessor() 注册后置处理器，创建 AnnotationAwareAspectJAutoProxyCreator；
     * 		2）finishBeanFactoryInitialization() 初始化剩下的单实例 bean；
     * 			①创建业务逻辑组件和切面组件；
     * 			②AnnotationAwareAspectJAutoProxyCreator 拦截器组件的创建过程；
     * 			③组件创建完成后，判断组件是否需要增强：
     * 				是：切面的通知方法，包装成增强器（Advisor）；给业务逻辑组件创建一个代理对象（Cglib);
     * 	5.执行目标方法：
     * 		1）代理对象执行目标方法；
     * 		2）CglibAopProxy.intercept();
     * 			①得到目标方法的拦截器链（增强器包装成拦截器 MethodInterceptor);
     * 			②利用拦截器的链式机制，依次进入每一个拦截器进行执行；
     * 			③效果：
     * 				正常执行：前置通知-->目标方法-->后置通知-->返回通知
     * 				出现异常：前置通知-->目标方法-->后置通知-->异常通知
     */

    @Test
    public void testAopByXml() {
        String file = "aop-test.xml";
        ClassPathXmlApplicationContext  ac = new ClassPathXmlApplicationContext(file);
        // Get Proxy Object
        IndexDao myAop = ac.getBean("myAop", IndexDao.class);
        ac.close();
        String lxcecho = myAop.query("lxcecho", 18);
    }

    @Test
    public void testAopByAnnotation() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopOpenConfig.class);
        // 循环引用，原理测试
        // AOP，原理测试
        HelloService helloService = applicationContext.getBean(HelloService.class); // 对象不要自己创建
        helloService.sayHello("lxcecho");
        applicationContext.close();
    }

}
