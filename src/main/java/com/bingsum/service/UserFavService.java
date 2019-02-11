/**
 * @filename:UserFavServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.UserFav;
import com.bingsum.mapper.UserFavMapper;

/**   
 *  
 * @Description:  用户收藏产品——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("userFavService")
@Transactional(readOnly = true)
public class UserFavService{

    @Autowired
    private UserFavMapper userFavMapper;
	
    public List<UserFav> getAll(UserFav userFav) {
        if (userFav.getPage() != null && userFav.getRows() != null) {
            PageHelper.startPage(userFav.getPage(), userFav.getRows());
        }
        return userFavMapper.selectAll();
    }

    public UserFav getById(Integer id) {
        return userFavMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        userFavMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(UserFav userFav) {
        if (userFav.getId() != null) {
            userFavMapper.updateByPrimaryKey(userFav);
        } else {
            userFavMapper.insert(userFav);
        }
    }
}