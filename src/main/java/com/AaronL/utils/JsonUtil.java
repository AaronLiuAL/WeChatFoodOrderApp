package com.AaronL.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Jason wrappers
 * Created by Aaron on 2018/5/4.
 */
public class JsonUtil {

    public static String toJson(Object object){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
