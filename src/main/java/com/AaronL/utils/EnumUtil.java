package com.AaronL.utils;

import com.AaronL.enums.CodeEnum;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by Aaron on 2018/5/4.
 */
 
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){
        for (T each:enumClass.getEnumConstants()){
            if(code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
