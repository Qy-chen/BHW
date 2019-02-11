/**
 * @filename:ManufacturerPaymentMethodServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.ManufacturerPaymentMethod;
import com.bingsum.mapper.ManufacturerPaymentMethodMapper;

/**   
 *  
 * @Description:  [暂未用到]厂家支付模式——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("manufacturerPaymentMethodService")
@Transactional(readOnly = true)
public class ManufacturerPaymentMethodService{

    @Autowired
    private ManufacturerPaymentMethodMapper manufacturerPaymentMethodMapper;
	
    public List<ManufacturerPaymentMethod> getAll(ManufacturerPaymentMethod manufacturerPaymentMethod) {
        if (manufacturerPaymentMethod.getPage() != null && manufacturerPaymentMethod.getRows() != null) {
            PageHelper.startPage(manufacturerPaymentMethod.getPage(), manufacturerPaymentMethod.getRows());
        }
        return manufacturerPaymentMethodMapper.selectAll();
    }

    public ManufacturerPaymentMethod getById(Integer id) {
        return manufacturerPaymentMethodMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        manufacturerPaymentMethodMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(ManufacturerPaymentMethod manufacturerPaymentMethod) {
        if (manufacturerPaymentMethod.getId() != null) {
            manufacturerPaymentMethodMapper.updateByPrimaryKey(manufacturerPaymentMethod);
        } else {
            manufacturerPaymentMethodMapper.insert(manufacturerPaymentMethod);
        }
    }
}