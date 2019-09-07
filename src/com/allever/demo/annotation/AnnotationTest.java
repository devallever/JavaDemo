package com.allever.demo.annotation;

import java.lang.reflect.Field;

/**
 * Created by allever on 18-7-4.
 */

@MyAnnotation(id = 1, name = "Allever")
public class AnnotationTest {

    @MyFieldAnnotation(fieldId = 1)
    private int a;

    @MyAnnotation
    public static void main(String[] args){
        Class clazz = AnnotationTest.class;

        if (clazz.isAnnotationPresent(MyAnnotation.class)){
            MyAnnotation myAnnotation = (MyAnnotation) clazz.getAnnotation(MyAnnotation.class);
            System.out.println("id = " + myAnnotation.id());
            System.out.println("name = " + myAnnotation.name());
        }

        try {

            Field field = clazz.getDeclaredField("a");
            field.setAccessible(true);
            if (field.isAnnotationPresent(MyFieldAnnotation.class)){
                MyFieldAnnotation myFieldAnnotation = field.getAnnotation(MyFieldAnnotation.class);
                System.out.println("myField fieldID = " + myFieldAnnotation.fieldId());
            }else {
                System.out.println("no field");
            }
        }catch (NoSuchFieldException e){
            e.printStackTrace();
        }

    }
}
