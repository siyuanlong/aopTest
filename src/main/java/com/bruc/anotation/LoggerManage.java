package com.bruc.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * �Զ���ע�� ����ȡ��־
 * @author apple
 */
/*@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoggerManage {

	// ��ʾ���Ƕ�����һ������ ��������������� String Ĭ���ǿ�
	public String logDescription() default "";
	
}*/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoggerManage{
	//��ʾ���Ƕ�����һ������ ��������������� String Ĭ��Ϊ��
	public String logDescription() default "";
}
