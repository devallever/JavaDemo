package com.allever.demo.pushTest;

import java.io.Closeable;

/**
 * Created by allever on 18-8-1.
 */
public class CloseUtil {
    public static void close(Closeable closeable){
        try {
            closeable.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
