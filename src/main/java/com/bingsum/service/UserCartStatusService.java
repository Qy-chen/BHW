/**
 * @filename:UserCartStatusServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.UserCartStatus;
import com.bingsum.mapper.UserCartStatusMapper;

/**   
 *  
 * @Description:  [暂未用到] 购物车状态——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("userCartStatusService")
@Transactional(readOnly = true)
public class UserCartStatusService{

    @Autowired
    private UserCartStatusMapper userCartStatusMapper;
	
    public List<UserCartStatus> getAll(UserCartStatus userCartStatus) {
        if (userCartStatus.getPage() != null && userCartStatus.getRows() != null) {
            PageHelper.startPage(userCartStatus.getPage(), userCartStatus.getRows());
        }
        return userCartStatusMapper.selectAll();
    }

    public UserCartStatus getById(Integer id) {
        return userCartStatusMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        userCartStatusMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(UserCartStatus userCartStatus) {
        if (userCartStatus.getId() != null) {
            userCartStatusMapper.updateByPrimaryKey(userCartStatus);
        } else {
            userCartStatusMapper.insert(userCartStatus);
        }
    }
}