package com.allever.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by allever on 18-7-4.
 */

@Target({ElementType.TYPE,
        ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    int id() default -1;
    String name() default "";
}
