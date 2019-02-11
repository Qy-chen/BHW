/**
 * @filename:StaffHistoryServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.StaffHistory;
import com.bingsum.mapper.StaffHistoryMapper;

/**   
 *  
 * @Description:  [暂未用到]员工表——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("staffHistoryService")
@Transactional(readOnly = true)
public class StaffHistoryService{

    @Autowired
    private StaffHistoryMapper staffHistoryMapper;
	
    public List<StaffHistory> getAll(StaffHistory staffHistory) {
        if (staffHistory.getPage() != null && staffHistory.getRows() != null) {
            PageHelper.startPage(staffHistory.getPage(), staffHistory.getRows());
        }
        return staffHistoryMapper.selectAll();
    }

    public StaffHistory getById(Integer id) {
        return staffHistoryMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        staffHistoryMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(StaffHistory staffHistory) {
        if (staffHistory.getId() != null) {
            staffHistoryMapper.updateByPrimaryKey(staffHistory);
        } else {
            staffHistoryMapper.insert(staffHistory);
        }
    }
}