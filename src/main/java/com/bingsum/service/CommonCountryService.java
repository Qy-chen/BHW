/**
 * @filename:CommonCountryServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.CommonCountry;
import com.bingsum.mapper.CommonCountryMapper;

/**   
 *  
 * @Description:  国家名——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("commonCountryService")
@Transactional(readOnly = true)
public class CommonCountryService{

    @Autowired
    private CommonCountryMapper commonCountryMapper;
	
    public List<CommonCountry> getAll(CommonCountry commonCountry) {
        if (commonCountry.getPage() != null && commonCountry.getRows() != null) {
            PageHelper.startPage(commonCountry.getPage(), commonCountry.getRows());
        }
        return commonCountryMapper.selectAll();
    }

    public CommonCountry getById(Integer id) {
        return commonCountryMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        commonCountryMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(CommonCountry commonCountry) {
        if (commonCountry.getId() != null) {
            commonCountryMapper.updateByPrimaryKey(commonCountry);
        } else {
            commonCountryMapper.insert(commonCountry);
        }
    }
}