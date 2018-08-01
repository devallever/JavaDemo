package com.allever.otherTest;

/**
 * Created by allever on 18-7-25.
 */
public class OtherTest {

    public static void main(String[] args){
        int sum;
        sum = addTo100(0, 1);
        System.out.println(sum);
    }

    private static int addTo100(int preSum, int b){
        if (b > 100){
            return preSum;
        }
        return addTo100(preSum + b, ++b);
    }
}
