/**
 * @filename:UserDeliveryAddressServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.UserDeliveryAddress;
import com.bingsum.mapper.UserDeliveryAddressMapper;

/**   
 *  
 * @Description:  用户收货地址——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("userDeliveryAddressService")
@Transactional(readOnly = true)
public class UserDeliveryAddressService{

    @Autowired
    private UserDeliveryAddressMapper userDeliveryAddressMapper;
	
    public List<UserDeliveryAddress> getAll(UserDeliveryAddress userDeliveryAddress) {
        if (userDeliveryAddress.getPage() != null && userDeliveryAddress.getRows() != null) {
            PageHelper.startPage(userDeliveryAddress.getPage(), userDeliveryAddress.getRows());
        }
        return userDeliveryAddressMapper.selectAll();
    }

    public UserDeliveryAddress getById(Integer id) {
        return userDeliveryAddressMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        userDeliveryAddressMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(UserDeliveryAddress userDeliveryAddress) {
        if (userDeliveryAddress.getId() != null) {
            userDeliveryAddressMapper.updateByPrimaryKey(userDeliveryAddress);
        } else {
            userDeliveryAddressMapper.insert(userDeliveryAddress);
        }
    }
}