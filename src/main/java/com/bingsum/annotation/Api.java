package com.bingsum.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;

@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.METHOD})
@Documented
@Inherited 
public @interface Api {
	int api() default 1;
	
	String notNullPara() default "";

	String noAuth() default "";
}
