/**
 * @filename:ManufacturerCaseServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.ManufacturerCase;
import com.bingsum.mapper.ManufacturerCaseMapper;

/**   
 *  
 * @Description:  [暂未用到]工厂案例——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("manufacturerCaseService")
@Transactional(readOnly = true)
public class ManufacturerCaseService{

    @Autowired
    private ManufacturerCaseMapper manufacturerCaseMapper;
	
    public List<ManufacturerCase> getAll(ManufacturerCase manufacturerCase) {
        if (manufacturerCase.getPage() != null && manufacturerCase.getRows() != null) {
            PageHelper.startPage(manufacturerCase.getPage(), manufacturerCase.getRows());
        }
        return manufacturerCaseMapper.selectAll();
    }

    public ManufacturerCase getById(Integer id) {
        return manufacturerCaseMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        manufacturerCaseMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(ManufacturerCase manufacturerCase) {
        if (manufacturerCase.getId() != null) {
            manufacturerCaseMapper.updateByPrimaryKey(manufacturerCase);
        } else {
            manufacturerCaseMapper.insert(manufacturerCase);
        }
    }
}