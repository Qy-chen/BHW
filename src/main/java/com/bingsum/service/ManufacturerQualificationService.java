/**
 * @filename:ManufacturerQualificationServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.ManufacturerQualification;
import com.bingsum.mapper.ManufacturerQualificationMapper;

/**   
 *  
 * @Description:  工厂资质——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("manufacturerQualificationService")
@Transactional(readOnly = true)
public class ManufacturerQualificationService{

    @Autowired
    private ManufacturerQualificationMapper manufacturerQualificationMapper;
	
    public List<ManufacturerQualification> getAll(ManufacturerQualification manufacturerQualification) {
        if (manufacturerQualification.getPage() != null && manufacturerQualification.getRows() != null) {
            PageHelper.startPage(manufacturerQualification.getPage(), manufacturerQualification.getRows());
        }
        return manufacturerQualificationMapper.selectAll();
    }

    public ManufacturerQualification getById(Integer id) {
        return manufacturerQualificationMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        manufacturerQualificationMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(ManufacturerQualification manufacturerQualification) {
        if (manufacturerQualification.getId() != null) {
            manufacturerQualificationMapper.updateByPrimaryKey(manufacturerQualification);
        } else {
            manufacturerQualificationMapper.insert(manufacturerQualification);
        }
    }
}