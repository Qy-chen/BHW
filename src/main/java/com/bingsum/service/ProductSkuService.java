/**
 * @filename:ProductSkuServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.ProductSku;
import com.bingsum.mapper.ProductSkuMapper;

/**   
 *  
 * @Description:  产品sku——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("productSkuService")
@Transactional(readOnly = true)
public class ProductSkuService{

    @Autowired
    private ProductSkuMapper productSkuMapper;
	
    public List<ProductSku> getAll(ProductSku productSku) {
        if (productSku.getPage() != null && productSku.getRows() != null) {
            PageHelper.startPage(productSku.getPage(), productSku.getRows());
        }
        return productSkuMapper.selectAll();
    }

    public ProductSku getById(Integer id) {
        return productSkuMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        productSkuMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(ProductSku productSku) {
        if (productSku.getId() != null) {
            productSkuMapper.updateByPrimaryKey(productSku);
        } else {
            productSkuMapper.insert(productSku);
        }
    }
}