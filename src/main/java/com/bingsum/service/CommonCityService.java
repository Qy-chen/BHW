/**
 * @filename:CommonCityServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.CommonCity;
import com.bingsum.mapper.CommonCityMapper;

/**   
 *  
 * @Description:  市级地名——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("commonCityService")
@Transactional(readOnly = true)
public class CommonCityService{

    @Autowired
    private CommonCityMapper commonCityMapper;
	
    public List<CommonCity> getAll(CommonCity commonCity) {
        if (commonCity.getPage() != null && commonCity.getRows() != null) {
            PageHelper.startPage(commonCity.getPage(), commonCity.getRows());
        }
        return commonCityMapper.selectAll();
    }

    public CommonCity getById(Integer id) {
        return commonCityMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        commonCityMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(CommonCity commonCity) {
        if (commonCity.getId() != null) {
            commonCityMapper.updateByPrimaryKey(commonCity);
        } else {
            commonCityMapper.insert(commonCity);
        }
    }
}