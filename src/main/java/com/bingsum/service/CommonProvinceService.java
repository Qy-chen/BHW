/**
 * @filename:CommonProvinceServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.CommonProvince;
import com.bingsum.mapper.CommonProvinceMapper;

/**   
 *  
 * @Description:  省级地名——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("commonProvinceService")
@Transactional(readOnly = true)
public class CommonProvinceService{

    @Autowired
    private CommonProvinceMapper commonProvinceMapper;
	
    public List<CommonProvince> getAll(CommonProvince commonProvince) {
        if (commonProvince.getPage() != null && commonProvince.getRows() != null) {
            PageHelper.startPage(commonProvince.getPage(), commonProvince.getRows());
        }
        return commonProvinceMapper.selectAll();
    }

    public CommonProvince getById(Integer id) {
        return commonProvinceMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        commonProvinceMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(CommonProvince commonProvince) {
        if (commonProvince.getId() != null) {
            commonProvinceMapper.updateByPrimaryKey(commonProvince);
        } else {
            commonProvinceMapper.insert(commonProvince);
        }
    }
}