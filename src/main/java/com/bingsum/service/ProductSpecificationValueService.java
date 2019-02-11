/**
 * @filename:ProductSpecificationValueServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.ProductSpecificationValue;
import com.bingsum.mapper.ProductSpecificationValueMapper;

/**   
 *  
 * @Description:  产品规格参数——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("productSpecificationValueService")
@Transactional(readOnly = true)
public class ProductSpecificationValueService{

    @Autowired
    private ProductSpecificationValueMapper productSpecificationValueMapper;
	
    public List<ProductSpecificationValue> getAll(ProductSpecificationValue productSpecificationValue) {
        if (productSpecificationValue.getPage() != null && productSpecificationValue.getRows() != null) {
            PageHelper.startPage(productSpecificationValue.getPage(), productSpecificationValue.getRows());
        }
        return productSpecificationValueMapper.selectAll();
    }

    public ProductSpecificationValue getById(Integer id) {
        return productSpecificationValueMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        productSpecificationValueMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(ProductSpecificationValue productSpecificationValue) {
        if (productSpecificationValue.getId() != null) {
            productSpecificationValueMapper.updateByPrimaryKey(productSpecificationValue);
        } else {
            productSpecificationValueMapper.insert(productSpecificationValue);
        }
    }
}