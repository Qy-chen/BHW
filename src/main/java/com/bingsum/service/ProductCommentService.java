/**
 * @filename:ProductCommentServiceImpl 2019-02-15 11:22:39
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.service;

import com.bingsum.annotation.Api;
import com.bingsum.model.Staff;
import com.bingsum.util.ApiUtil;
import com.bingsum.util.ParaData;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;

import java.util.List;

import com.bingsum.model.ProductComment;
import com.bingsum.mapper.ProductCommentMapper;
import tk.mybatis.mapper.entity.Example;

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

    /**
     *
     * @param pd
     * @return
     */
    @Api
    public Object getProductCommentInfoList(ParaData pd){
        Example example = new Example(ProductComment.class);
        Example.Criteria criteria = example.createCriteria();
        Staff staff = pd.getLoginStaff();
        if (staff.getManufacturer_id() != null){
            criteria.andEqualTo("manufacturerId",staff.getManufacturer_id());
        }
        Page<?> page = PageHelper.startPage(pd.getInteger("currentPage"), 20);
        productCommentMapper.selectByExample(example);
        return ApiUtil.returnObject(pd, page);
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api(notNullPara="id")
    public Object getProductCommentInfo(ParaData pd) {
        Example example = new Example(ProductComment.class);
        Example.Criteria criteria = example.createCriteria();
        Staff staff = pd.getLoginStaff();
        if (staff.getManufacturer_id() != null){
            criteria.andEqualTo("manufacturerId",staff.getManufacturer_id());
        }
        criteria.andEqualTo("id", pd.getString("id"));
        ProductComment productComment = productCommentMapper.selectOneByExample(example);

        if (productComment == null){
            return ApiUtil.returnDescFail(pd,"没有该数据！");
        }
        return ApiUtil.returnOK(pd,productComment);
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api
    @Transactional(readOnly = false)
    public Object newProductCommentInfo(ParaData pd) {
        ProductComment productComment = pd.toAddBean(ProductComment.class);
        Staff staff = pd.getLoginStaff();
        if (staff.getManufacturer_id() != null){
            productComment.setStatus(0);
            productComment.setCreateBy(pd.getLoginStaff().getId());
            productComment.setManufacturerId(staff.getManufacturer_id());
        }
        this.productCommentMapper.insert(productComment);
        return ApiUtil.returnOK(pd,productComment);
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api(notNullPara="id")
    @Transactional(readOnly = false)
    public Object setProductCommentInfo(ParaData pd) {
        ProductComment productComment = pd.toUpdateBean(ProductComment.class);
        Staff staff = pd.getLoginStaff();
        productComment.setUpdateBy(pd.getLoginStaff().getId());
        //厂家无法审核
        if (staff.getManufacturer_id() != null){
            return ApiUtil.returnDescFail(pd,"没有审核权！");
        }
        this.productCommentMapper.updateByPrimaryKeySelective(productComment);
        return ApiUtil.returnOK(pd,productComment);
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api(notNullPara="id")
    @Transactional(readOnly = false)
    public Object delProductComment(ParaData pd) {
        ProductComment productComment = pd.toDeleteBean(ProductComment.class);
        productCommentMapper.updateByPrimaryKeySelective(productComment);
        return ApiUtil.returnOK(pd,productComment);
    }
}