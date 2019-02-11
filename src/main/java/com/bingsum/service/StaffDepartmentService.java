/**
 * @filename:StaffDepartmentServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.StaffDepartment;
import com.bingsum.mapper.StaffDepartmentMapper;

/**   
 *  
 * @Description:  [暂未用到]员工表——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("staffDepartmentService")
@Transactional(readOnly = true)
public class StaffDepartmentService{

    @Autowired
    private StaffDepartmentMapper staffDepartmentMapper;
	
    public List<StaffDepartment> getAll(StaffDepartment staffDepartment) {
        if (staffDepartment.getPage() != null && staffDepartment.getRows() != null) {
            PageHelper.startPage(staffDepartment.getPage(), staffDepartment.getRows());
        }
        return staffDepartmentMapper.selectAll();
    }

    public StaffDepartment getById(Integer id) {
        return staffDepartmentMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        staffDepartmentMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(StaffDepartment staffDepartment) {
        if (staffDepartment.getId() != null) {
            staffDepartmentMapper.updateByPrimaryKey(staffDepartment);
        } else {
            staffDepartmentMapper.insert(staffDepartment);
        }
    }
}