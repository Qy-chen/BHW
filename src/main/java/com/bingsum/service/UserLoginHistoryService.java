/**
 * @filename:UserLoginHistoryServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.UserLoginHistory;
import com.bingsum.mapper.UserLoginHistoryMapper;

/**   
 *  
 * @Description:  [暂未用到]用户登录记录——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("userLoginHistoryService")
@Transactional(readOnly = true)
public class UserLoginHistoryService{

    @Autowired
    private UserLoginHistoryMapper userLoginHistoryMapper;
	
    public List<UserLoginHistory> getAll(UserLoginHistory userLoginHistory) {
        if (userLoginHistory.getPage() != null && userLoginHistory.getRows() != null) {
            PageHelper.startPage(userLoginHistory.getPage(), userLoginHistory.getRows());
        }
        return userLoginHistoryMapper.selectAll();
    }

    public UserLoginHistory getById(Integer id) {
        return userLoginHistoryMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        userLoginHistoryMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(UserLoginHistory userLoginHistory) {
        if (userLoginHistory.getId() != null) {
            userLoginHistoryMapper.updateByPrimaryKey(userLoginHistory);
        } else {
            userLoginHistoryMapper.insert(userLoginHistory);
        }
    }
}