/**
 * @filename:UserProductHistoryServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.UserProductHistory;
import com.bingsum.mapper.UserProductHistoryMapper;

/**   
 *  
 * @Description:  用户浏览记录——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("userProductHistoryService")
@Transactional(readOnly = true)
public class UserProductHistoryService{

    @Autowired
    private UserProductHistoryMapper userProductHistoryMapper;
	
    public List<UserProductHistory> getAll(UserProductHistory userProductHistory) {
        if (userProductHistory.getPage() != null && userProductHistory.getRows() != null) {
            PageHelper.startPage(userProductHistory.getPage(), userProductHistory.getRows());
        }
        return userProductHistoryMapper.selectAll();
    }

    public UserProductHistory getById(Integer id) {
        return userProductHistoryMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        userProductHistoryMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(UserProductHistory userProductHistory) {
        if (userProductHistory.getId() != null) {
            userProductHistoryMapper.updateByPrimaryKey(userProductHistory);
        } else {
            userProductHistoryMapper.insert(userProductHistory);
        }
    }
}