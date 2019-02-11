/**
 * @filename:ProductClassServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.ProductClass;
import com.bingsum.mapper.ProductClassMapper;

/**   
 *  
 * @Description:  产品类别——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("productClassService")
@Transactional(readOnly = true)
public class ProductClassService{

    @Autowired
    private ProductClassMapper productClassMapper;
	
    public List<ProductClass> getAll(ProductClass productClass) {
        if (productClass.getPage() != null && productClass.getRows() != null) {
            PageHelper.startPage(productClass.getPage(), productClass.getRows());
        }
        return productClassMapper.selectAll();
    }

    public ProductClass getById(Integer id) {
        return productClassMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        productClassMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(ProductClass productClass) {
        if (productClass.getId() != null) {
            productClassMapper.updateByPrimaryKey(productClass);
        } else {
            productClassMapper.insert(productClass);
        }
    }
}