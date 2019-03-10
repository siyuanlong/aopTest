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
 * ��־������
 * 
 * @author apple
 */
@Aspect
@Component
public class LoggerAdvice {

	private Logger logger = Logger.getLogger(this.getClass());

	// ��仰��ʾ����˼��:���з����������@LoggingManagerע��Ķ��ᱻѡ��
	@Before("@annotation(loggerManage)")
	public void addBeforeLogger(JoinPoint joinPoint, LoggerManage loggerManage) {
		LocalDateTime now = LocalDateTime.now();
		logger.info(now.toString() + "ִ��[" + loggerManage.logDescription() + "]��ʼ");
		System.out.println(now.toString() + "ִ��[" + loggerManage.logDescription() + "]��ʼ");
		logger.info("������:"+joinPoint.getSignature().toString());
		logger.info("��������:"+parseParames(joinPoint.getArgs()));
	}

	@AfterReturning("@annotation(loggerManage)")
	public void addAfterReturningLogger(JoinPoint joinPoint, LoggerManage loggerManage) {
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now.toString() + "ִ�� [" + loggerManage.logDescription() + "] ����");
	}
	

	@AfterThrowing(pointcut = "@annotation(loggerManage)", throwing = "ex")
	public void addAfterThrowingLogger(JoinPoint joinPoint, LoggerManage loggerManage, Exception ex) {
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now.toString() + "ִ�� [" + loggerManage.logDescription() + "] �쳣");
	}

	//���������еĲ��� ��ȡһ�������б��ַ���
	private String parseParames(Object[] parames) {
		if (null == parames || parames.length <= 0) {
			return "";

		}
		StringBuffer param = new StringBuffer("������� # ��:[ ");
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
