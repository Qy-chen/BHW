/**
 * @filename:ManufacturerServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.Manufacturer;
import com.bingsum.mapper.ManufacturerMapper;

/**   
 *  
 * @Description:  工厂信息——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("manufacturerService")
@Transactional(readOnly = true)
public class ManufacturerService{

    @Autowired
    private ManufacturerMapper manufacturerMapper;
	
    public List<Manufacturer> getAll(Manufacturer manufacturer) {
        if (manufacturer.getPage() != null && manufacturer.getRows() != null) {
            PageHelper.startPage(manufacturer.getPage(), manufacturer.getRows());
        }
        return manufacturerMapper.selectAll();
    }

    public Manufacturer getById(Integer id) {
        return manufacturerMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        manufacturerMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(Manufacturer manufacturer) {
        if (manufacturer.getId() != null) {
            manufacturerMapper.updateByPrimaryKey(manufacturer);
        } else {
            manufacturerMapper.insert(manufacturer);
        }
    }
}