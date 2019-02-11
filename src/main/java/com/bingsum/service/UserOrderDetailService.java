/**
 * @filename:UserOrderDetailServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.UserOrderDetail;
import com.bingsum.mapper.UserOrderDetailMapper;

/**   
 *  
 * @Description:  用户订单——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("userOrderDetailService")
@Transactional(readOnly = true)
public class UserOrderDetailService{

    @Autowired
    private UserOrderDetailMapper userOrderDetailMapper;
	
    public List<UserOrderDetail> getAll(UserOrderDetail userOrderDetail) {
        if (userOrderDetail.getPage() != null && userOrderDetail.getRows() != null) {
            PageHelper.startPage(userOrderDetail.getPage(), userOrderDetail.getRows());
        }
        return userOrderDetailMapper.selectAll();
    }

    public UserOrderDetail getById(Integer id) {
        return userOrderDetailMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        userOrderDetailMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(UserOrderDetail userOrderDetail) {
        if (userOrderDetail.getId() != null) {
            userOrderDetailMapper.updateByPrimaryKey(userOrderDetail);
        } else {
            userOrderDetailMapper.insert(userOrderDetail);
        }
    }
}