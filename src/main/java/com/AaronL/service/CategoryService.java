package com.AaronL.service;

import com.AaronL.dataobject.ProductCategory;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by Aaron on 2018/5/8.
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);

}
