package com.AaronL.utils;

import java.util.Random;

/**
 * Created by Aaron on 2018/5/4.
 */
public class KeyUtil {

    /**
     * generate uqunie key
     * format: time + random number
     * @return
     */
    public static synchronized String genUniqueKey(){
        Random random=new Random();
        Integer number=random.nextInt(900000)+100000;

        return System.currentTimeMillis()+String.valueOf(number);
    }
}
