package com.AaronL.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;
import java.io.Serializable;


/**
 * product with category
 * Created by Aaron on 2018/5/17.
 */
@Data
public class ProductVO implements Serializable{

    private static final long serialVersionUID = 7097863777546530545L;

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
