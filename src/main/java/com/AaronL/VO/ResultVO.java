package com.AaronL.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.io.Serializable;


/**
 * http请求返回的最外层对象
 * Created by Aaron on 2018/5/17.
 */
@Data
public class ResultVO<T> implements Serializable{

    private static final long serialVersionUID = 3068837394742385883L;
    /**error code**/
    private Integer code;

    /**tip msg**/
    private String msg;

    /**detail msg**/
    private T data;
}
