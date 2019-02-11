/**
 * @filename:ManufacturerPatentServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.ManufacturerPatent;
import com.bingsum.mapper.ManufacturerPatentMapper;

/**   
 *  
 * @Description:  [暂未用到]工厂专利——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("manufacturerPatentService")
@Transactional(readOnly = true)
public class ManufacturerPatentService{

    @Autowired
    private ManufacturerPatentMapper manufacturerPatentMapper;
	
    public List<ManufacturerPatent> getAll(ManufacturerPatent manufacturerPatent) {
        if (manufacturerPatent.getPage() != null && manufacturerPatent.getRows() != null) {
            PageHelper.startPage(manufacturerPatent.getPage(), manufacturerPatent.getRows());
        }
        return manufacturerPatentMapper.selectAll();
    }

    public ManufacturerPatent getById(Integer id) {
        return manufacturerPatentMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        manufacturerPatentMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(ManufacturerPatent manufacturerPatent) {
        if (manufacturerPatent.getId() != null) {
            manufacturerPatentMapper.updateByPrimaryKey(manufacturerPatent);
        } else {
            manufacturerPatentMapper.insert(manufacturerPatent);
        }
    }
}