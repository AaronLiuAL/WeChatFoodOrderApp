package com.AaronL.utils;

import com.google.common.math.DoubleMath;

/**
 * Created by Aaron on 2018/5/2.
 */
public class MathUtil {

    private static final Double MONEY_RANGE=0.01;
    /**
     * compare if two prices equal 
     * @param d1
     * @param d2
     * @return
     */
    public static Boolean equals(Double d1,Double d2){
        Double result=Math.abs(d1-d2);
        if(result<MONEY_RANGE){
            return true;
        }else{
            return false;
        }
    }
}
