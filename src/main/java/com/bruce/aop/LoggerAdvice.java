package com.bruce.aop;

import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.bruc.anotation.LoggerManage;

/**
 * 日志切面类
 * 
 * @author apple
 */
@Aspect
@Component
public class LoggerAdvice {

	private Logger logger = Logger.getLogger(this.getClass());

	// 这句话表示的意思是:所有方法如果具有@LoggingManager注解的都会被选中
	@Before("@annotation(loggerManage)")
	public void addBeforeLogger(JoinPoint joinPoint, LoggerManage loggerManage) {
		LocalDateTime now = LocalDateTime.now();
		logger.info(now.toString() + "执行[" + loggerManage.logDescription() + "]开始");
		System.out.println(now.toString() + "执行[" + loggerManage.logDescription() + "]开始");
		logger.info("方法名:"+joinPoint.getSignature().toString());
		logger.info("方法参数:"+parseParames(joinPoint.getArgs()));
	}

	@AfterReturning("@annotation(loggerManage)")
	public void addAfterReturningLogger(JoinPoint joinPoint, LoggerManage loggerManage) {
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now.toString() + "执行 [" + loggerManage.logDescription() + "] 结束");
	}
	

	@AfterThrowing(pointcut = "@annotation(loggerManage)", throwing = "ex")
	public void addAfterThrowingLogger(JoinPoint joinPoint, LoggerManage loggerManage, Exception ex) {
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now.toString() + "执行 [" + loggerManage.logDescription() + "] 异常");
	}

	//解析方法中的参数 获取一个方法列表字符串
	private String parseParames(Object[] parames) {
		if (null == parames || parames.length <= 0) {
			return "";

		}
		StringBuffer param = new StringBuffer("传入参数 # 个:[ ");
		int i = 0;
		for (Object obj : parames) {
			i++;
			if (i == 1) {
				param.append(obj.toString());
				continue;
			}
			param.append(" ,").append(obj.toString());
		}
		return param.append(" ]").toString().replace("#", String.valueOf(i));
	}
}
