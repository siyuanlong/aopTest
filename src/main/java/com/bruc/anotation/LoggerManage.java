package com.bruc.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解 来获取日志
 * @author apple
 */
/*@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoggerManage {

	// 表示的是定义了一个变量 这个变量的类型是 String 默认是空
	public String logDescription() default "";
	
}*/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoggerManage{
	//表示的是定义了一个变量 这个变量的类型是 String 默认为空
	public String logDescription() default "";
}
