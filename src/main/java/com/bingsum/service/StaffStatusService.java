/**
 * @filename:StaffStatusServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.StaffStatus;
import com.bingsum.mapper.StaffStatusMapper;

/**   
 *  
 * @Description:  [暂未用到]员工表——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("staffStatusService")
@Transactional(readOnly = true)
public class StaffStatusService{

    @Autowired
    private StaffStatusMapper staffStatusMapper;
	
    public List<StaffStatus> getAll(StaffStatus staffStatus) {
        if (staffStatus.getPage() != null && staffStatus.getRows() != null) {
            PageHelper.startPage(staffStatus.getPage(), staffStatus.getRows());
        }
        return staffStatusMapper.selectAll();
    }

    public StaffStatus getById(Integer id) {
        return staffStatusMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        staffStatusMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(StaffStatus staffStatus) {
        if (staffStatus.getId() != null) {
            staffStatusMapper.updateByPrimaryKey(staffStatus);
        } else {
            staffStatusMapper.insert(staffStatus);
        }
    }
}