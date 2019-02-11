/**
 * @filename:UserCartServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.UserCart;
import com.bingsum.mapper.UserCartMapper;

/**   
 *  
 * @Description:  购物车——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("userCartService")
@Transactional(readOnly = true)
public class UserCartService{

    @Autowired
    private UserCartMapper userCartMapper;
	
    public List<UserCart> getAll(UserCart userCart) {
        if (userCart.getPage() != null && userCart.getRows() != null) {
            PageHelper.startPage(userCart.getPage(), userCart.getRows());
        }
        return userCartMapper.selectAll();
    }

    public UserCart getById(Integer id) {
        return userCartMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        userCartMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(UserCart userCart) {
        if (userCart.getId() != null) {
            userCartMapper.updateByPrimaryKey(userCart);
        } else {
            userCartMapper.insert(userCart);
        }
    }
}