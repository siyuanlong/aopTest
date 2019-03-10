package com.bruc.anotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//注解注在哪儿
@Target({ElementType.METHOD, ElementType.TYPE,ElementType.FIELD}) //这个注解的作用就是告诉他这个注解用的地方
@Retention(RetentionPolicy.RUNTIME) 
@Documented
public @interface Hello {
	
	public String helloDes() default "";  //属性
}
