/**
 * @filename:ProductCommentServiceImpl 2019-02-15 11:22:39
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

import com.bingsum.model.ProductComment;
import com.bingsum.mapper.ProductCommentMapper;

/**   
 *  
 * @Description:  产品评论——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-15 11:22:39
 * @Version:      V1.0.0
 *    
 */
@Service("productCommentService")
@Transactional(readOnly = true)
public class ProductCommentService{

    @Autowired
    private ProductCommentMapper productCommentMapper;
	
    public List<ProductComment> getAll(ProductComment productComment) {
        if (productComment.getPage() != null && productComment.getRows() != null) {
            PageHelper.startPage(productComment.getPage(), productComment.getRows());
        }
        return productCommentMapper.selectAll();
    }

    public ProductComment getById(Integer id) {
        return productCommentMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        productCommentMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(ProductComment productComment) {
        if (productComment.getId() != null) {
            productCommentMapper.updateByPrimaryKey(productComment);
        } else {
            productCommentMapper.insert(productComment);
        }
    }
}