/**
 * @filename:ProductServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.Product;
import com.bingsum.mapper.ProductMapper;
import tk.mybatis.mapper.entity.Example;

/**   
 *  
 * @Description:  产品表——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("productService")
@Transactional(readOnly = true)
public class ProductService{

    @Autowired
    private ProductMapper productMapper;
	
    public List<Product> getAll(Product product) {
        if (product.getPage() != null && product.getRows() != null) {
            PageHelper.startPage(product.getPage(), product.getRows());
        }
        return productMapper.selectAll();
    }

    public Product getById(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        productMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(Product product) {
        if (product.getId() != null) {
            productMapper.updateByPrimaryKey(product);
        } else {
            productMapper.insert(product);
        }
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api
    public Object getProductInfoList(ParaData pd){
        Page<?> page = PageHelper.startPage(pd.getInteger("currentPage"), 20);
        Example example = new Example(Product.class);
        Example.Criteria criteria = example.createCriteria();
        Staff staff = pd.getLoginStaff();
        if (staff.getManufacturer_id() != null){
            criteria.andEqualTo("manufacturerId",staff.getManufacturer_id());
        }
        example.orderBy("createTime").desc();
        productMapper.selectByExample(example);
        return ApiUtil.returnObject(pd, page);
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api(notNullPara="id")
    public Object getProductInfo(ParaData pd) {
        Example example = new Example(Product.class);
        Example.Criteria criteria = example.createCriteria();
        Staff staff = pd.getLoginStaff();
        if (staff.getManufacturer_id() != null){
            criteria.andEqualTo("manufacturerId",staff.getManufacturer_id());
        }
        criteria.andEqualTo("id", pd.getString("id"));
        Product product = productMapper.selectOneByExample(example);

        if (product == null){
            return ApiUtil.returnDescFail(pd,"没有该数据！");
        }
        return ApiUtil.returnOK(pd,product);
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api
    @Transactional(readOnly = false)
    public Object newProductInfo(ParaData pd) {
        Product product = pd.toAddBean(Product.class);
        product.setStatus(2);
        product.setCreateBy(pd.getLoginStaff().getId());
        Staff staff = pd.getLoginStaff();
        if (staff.getManufacturer_id() != null){
            product.setManufacturerId(staff.getManufacturer_id());
        }
        this.productMapper.insert(product);
        return ApiUtil.returnOK(pd,product);
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api(notNullPara="id")
    @Transactional(readOnly = false)
    public Object setProductInfo(ParaData pd) {
        Product product = pd.toUpdateBean(Product.class);
        product.setUpdateBy(pd.getLoginStaff().getId());
        this.productMapper.updateByPrimaryKeySelective(product);
        return ApiUtil.returnOK(pd,product);
    }

    /**
     *
     * @param pd
     * @return
     */
    @Api(notNullPara="id")
    @Transactional(readOnly = false)
    public Object delProduct(ParaData pd) {
        Product product = pd.toDeleteBean(Product.class);
        productMapper.updateByPrimaryKeySelective(product);
        return ApiUtil.returnOK(pd,product);
    }

}