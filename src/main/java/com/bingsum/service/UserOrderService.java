/**
 * @filename:UserOrderServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.UserOrder;
import com.bingsum.mapper.UserOrderMapper;

/**   
 *  
 * @Description:  用户订单——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("userOrderService")
@Transactional(readOnly = true)
public class UserOrderService{

    @Autowired
    private UserOrderMapper userOrderMapper;
	
    public List<UserOrder> getAll(UserOrder userOrder) {
        if (userOrder.getPage() != null && userOrder.getRows() != null) {
            PageHelper.startPage(userOrder.getPage(), userOrder.getRows());
        }
        return userOrderMapper.selectAll();
    }

    public UserOrder getById(Integer id) {
        return userOrderMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        userOrderMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(UserOrder userOrder) {
        if (userOrder.getId() != null) {
            userOrderMapper.updateByPrimaryKey(userOrder);
        } else {
            userOrderMapper.insert(userOrder);
        }
    }
}