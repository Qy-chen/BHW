/**
 * @filename:ManufacturerBrandServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.ManufacturerBrand;
import com.bingsum.mapper.ManufacturerBrandMapper;

/**   
 *  
 * @Description:  工厂旗下品牌——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("manufacturerBrandService")
@Transactional(readOnly = true)
public class ManufacturerBrandService{

    @Autowired
    private ManufacturerBrandMapper manufacturerBrandMapper;
	
    public List<ManufacturerBrand> getAll(ManufacturerBrand manufacturerBrand) {
        if (manufacturerBrand.getPage() != null && manufacturerBrand.getRows() != null) {
            PageHelper.startPage(manufacturerBrand.getPage(), manufacturerBrand.getRows());
        }
        return manufacturerBrandMapper.selectAll();
    }

    public ManufacturerBrand getById(Integer id) {
        return manufacturerBrandMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        manufacturerBrandMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(ManufacturerBrand manufacturerBrand) {
        if (manufacturerBrand.getId() != null) {
            manufacturerBrandMapper.updateByPrimaryKey(manufacturerBrand);
        } else {
            manufacturerBrandMapper.insert(manufacturerBrand);
        }
    }
}