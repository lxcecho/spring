package com.lxcecho.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Spring 5 以后的顺序就一切正常：
 * 正常：前置通知--目标方法--返回通知--后置通知
 * 异常：前置通知--目标方法--异常通知--后置通知
 * try {
 * 	前置通知
 * 	目标方法
 * 	返回通知
 * } catch (Exception e) {
 * 	异常通知
 * } finally {
 * 	后置通知
 * }
 * <p>
 * 案例结果输出：
 * 	logStart(): {sayHello}, args: [{[lxcecho]}]
 * 	result: {Hello, lxcecho}
 * 	logReturn(): {sayHello}, args: [{[lxcecho]}], result: {Hello, lxcecho---7}
 * 	logEnd(): {sayHello}, args: [{[lxcecho]}]
 * <p>
 * <a href="https://www.eclipse.org/aspectj/doc/released/progguide/index.html">...</a>
 *
 * @author lxcecho 909231497@qq.com
 * @since 03.05.2022
 */
@Component // 切面也是容器中的组件，也需要将切面类加入到容器中
@Aspect // 说明这是切面
public class LogAspect {

    /**
	 * 抽取公共的切入点表达式：
	 * 	1.本类引用
	 * 	2.其他的切面引用
	 *
     * 配置切入点：该方法无方法体，主要为方便同类中其他方法使用此处配置的切入点
     */
    @Pointcut("execution(* com.lxcecho.aop.HelloService.sayHello(..))")
    public void aspect() {

    }

    public LogAspect() {
        System.out.println("LogAspect...");
    }

	// TODO JoinPoint 一定要出现在参数的第一位

    /**
     * 前置通知：在目标方法之前切入，切入点表达式（指定在哪个方法切入）
     *
     * @param joinPoint
     */
//	@Before("execution(* com.lxcecho.aop.HelloService.sayHello(..))")
    @Before("aspect()")
    public void logStart(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("logStart(): {" + name + "}, args: [{" + Arrays.asList(joinPoint.getArgs()) + "}]");
    }

    /**
     * 返回通知：在目标方法正常返回之后执行；
     *
     * @param joinPoint
     * @param result
     */
//	@AfterReturning(value = "execution(* com.lxcecho.aop.HelloService.sayHello(..))", returning = "result")
    @AfterReturning(value = "aspect()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) { // JoinPoint一定要出现在参数表的第一位，否则报错
        String name = joinPoint.getSignature().getName();
        System.out.println("logReturn(): {" + name + "}, args: [{" + Arrays.asList(joinPoint.getArgs()) + "}], result: {" + result + "}");
    }

    /**
     * 后置通知：在目标方法运行结束之后运行；无论方法是正常结束还是异常结束，都会调用。
     *
     * @param joinPoint
     */
//	@After("execution(* com.lxcecho.aop.HelloService.sayHello(..))")
    @After("aspect()")
    public void logEnd(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("logEnd(): {" + name + "}, args: [{" + Arrays.asList(joinPoint.getArgs()) + "}]");
    }

    /**
     * 异常通知：在目标方法出现异常之后运行；
     */
//	@AfterThrowing(value = "execution(* com.lxcecho.aop.HelloService.sayHello(..))", throwing = "e")
    @AfterThrowing(value = "aspect()", throwing = "e")
    public void logError(JoinPoint joinPoint, Exception e) {
        String name = joinPoint.getSignature().getName();
        System.out.println("logError(): {" + name + "}, args: [{" + Arrays.asList(joinPoint.getArgs()) + "}], exception: {" + e + "}");
    }

    /**
     * 环绕通知：动态代理，手动推进目标方法运行（JoinPoint.proceed()）.
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    /*@Around("aspect()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        // start stopwatch
        Object retVal = pjp.proceed();
        // stop stopwatch
        return retVal;
    }*/

}
