package com.allever.demo.annotation.practice;

import java.lang.reflect.Method;

/**
 * Created by allever on 18-7-4.
 */
public class ButTestTool {

    public static void main(String[] args){
        NoBug noBug = new NoBug();

        Class clz = noBug.getClass();

        Method[] methods = clz.getMethods();

        int errorCount = 0;

        StringBuilder log = new StringBuilder();

        for (Method method: methods){
            if (method.isAnnotationPresent(ButTest.class)){
                try {
                    method.setAccessible(true);
                    method.invoke(noBug, null);
                }catch (Exception e){
                    errorCount ++;
                    log.append(method.getName() + " has error");
                    log.append("\ncause by: " + e.getCause().getClass().getSimpleName());
                    log.append("\nmsg: " + e.getCause().getMessage());
                    log.append("\n");
                }
            }
        }

        log.append("\n"  + clz.getSimpleName() + " has "+ errorCount + " errors");
        System.out.println(log.toString());
    }
}
