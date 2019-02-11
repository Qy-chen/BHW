/**
 * @filename:ProductSpecificationServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.ProductSpecification;
import com.bingsum.mapper.ProductSpecificationMapper;

/**   
 *  
 * @Description:  产品规格名称——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("productSpecificationService")
@Transactional(readOnly = true)
public class ProductSpecificationService{

    @Autowired
    private ProductSpecificationMapper productSpecificationMapper;
	
    public List<ProductSpecification> getAll(ProductSpecification productSpecification) {
        if (productSpecification.getPage() != null && productSpecification.getRows() != null) {
            PageHelper.startPage(productSpecification.getPage(), productSpecification.getRows());
        }
        return productSpecificationMapper.selectAll();
    }

    public ProductSpecification getById(Integer id) {
        return productSpecificationMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        productSpecificationMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(ProductSpecification productSpecification) {
        if (productSpecification.getId() != null) {
            productSpecificationMapper.updateByPrimaryKey(productSpecification);
        } else {
            productSpecificationMapper.insert(productSpecification);
        }
    }
}