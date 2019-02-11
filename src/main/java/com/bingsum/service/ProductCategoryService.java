/**
 * @filename:ProductCategoryServiceImpl 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;

import java.util.List;

import com.bingsum.model.ProductCategory;
import com.bingsum.mapper.ProductCategoryMapper;

/**   
 *  
 * @Description:  产品类型——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("productCategoryService")
@Transactional(readOnly = true)
public class ProductCategoryService{

    @Autowired
    private ProductCategoryMapper productCategoryMapper;
	
    public List<ProductCategory> getAll(ProductCategory productCategory) {
        if (productCategory.getPage() != null && productCategory.getRows() != null) {
            PageHelper.startPage(productCategory.getPage(), productCategory.getRows());
        }
        return productCategoryMapper.selectAll();
    }

    public ProductCategory getById(Integer id) {
        return productCategoryMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        productCategoryMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(ProductCategory productCategory) {
        if (productCategory.getId() != null) {
            productCategoryMapper.updateByPrimaryKey(productCategory);
        } else {
            productCategoryMapper.insert(productCategory);
        }
    }
}