package com.allever.demo.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by allever on 18-7-4.
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface MyFieldAnnotation {
    int fieldId();
}
