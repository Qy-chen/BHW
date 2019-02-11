/**
 * @filename:StaffServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.Staff;
import com.bingsum.mapper.StaffMapper;

/**   
 *  
 * @Description:  [暂未用到]员工表——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("staffService")
@Transactional(readOnly = true)
public class StaffService{

    @Autowired
    private StaffMapper staffMapper;
	
    public List<Staff> getAll(Staff staff) {
        if (staff.getPage() != null && staff.getRows() != null) {
            PageHelper.startPage(staff.getPage(), staff.getRows());
        }
        return staffMapper.selectAll();
    }

    public Staff getById(Integer id) {
        return staffMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        staffMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(Staff staff) {
        if (staff.getId() != null) {
            staffMapper.updateByPrimaryKey(staff);
        } else {
            staffMapper.insert(staff);
        }
    }
}