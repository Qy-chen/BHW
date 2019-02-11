/**
 * @filename:UserStatusServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.UserStatus;
import com.bingsum.mapper.UserStatusMapper;

/**   
 *  
 * @Description:  [暂未用到]用户状态——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("userStatusService")
@Transactional(readOnly = true)
public class UserStatusService{

    @Autowired
    private UserStatusMapper userStatusMapper;
	
    public List<UserStatus> getAll(UserStatus userStatus) {
        if (userStatus.getPage() != null && userStatus.getRows() != null) {
            PageHelper.startPage(userStatus.getPage(), userStatus.getRows());
        }
        return userStatusMapper.selectAll();
    }

    public UserStatus getById(Integer id) {
        return userStatusMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        userStatusMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(UserStatus userStatus) {
        if (userStatus.getId() != null) {
            userStatusMapper.updateByPrimaryKey(userStatus);
        } else {
            userStatusMapper.insert(userStatus);
        }
    }
}