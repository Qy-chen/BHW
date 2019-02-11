/**
 * @filename:CommonDistrictServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.CommonDistrict;
import com.bingsum.mapper.CommonDistrictMapper;

/**   
 *  
 * @Description:  区级地名——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("commonDistrictService")
@Transactional(readOnly = true)
public class CommonDistrictService{

    @Autowired
    private CommonDistrictMapper commonDistrictMapper;
	
    public List<CommonDistrict> getAll(CommonDistrict commonDistrict) {
        if (commonDistrict.getPage() != null && commonDistrict.getRows() != null) {
            PageHelper.startPage(commonDistrict.getPage(), commonDistrict.getRows());
        }
        return commonDistrictMapper.selectAll();
    }

    public CommonDistrict getById(Integer id) {
        return commonDistrictMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        commonDistrictMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(CommonDistrict commonDistrict) {
        if (commonDistrict.getId() != null) {
            commonDistrictMapper.updateByPrimaryKey(commonDistrict);
        } else {
            commonDistrictMapper.insert(commonDistrict);
        }
    }
}