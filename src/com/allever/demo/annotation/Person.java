package com.allever.demo.annotation;

import java.lang.annotation.Repeatable;

/**
 * Created by allever on 18-7-4.
 */

@Repeatable(Persons.class)
public @interface Person {
    String role() default "";
}
