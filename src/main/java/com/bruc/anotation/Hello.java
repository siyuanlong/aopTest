package com.bruc.anotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//ע��ע���Ķ�
@Target({ElementType.METHOD, ElementType.TYPE,ElementType.FIELD}) //���ע������þ��Ǹ��������ע���õĵط�
@Retention(RetentionPolicy.RUNTIME) 
@Documented
public @interface Hello {
	
	public String helloDes() default "";  //����
}
