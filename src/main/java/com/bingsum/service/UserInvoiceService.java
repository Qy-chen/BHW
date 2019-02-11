/**
 * @filename:UserInvoiceServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.UserInvoice;
import com.bingsum.mapper.UserInvoiceMapper;

/**   
 *  
 * @Description:  用户关联发票——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("userInvoiceService")
@Transactional(readOnly = true)
public class UserInvoiceService{

    @Autowired
    private UserInvoiceMapper userInvoiceMapper;
	
    public List<UserInvoice> getAll(UserInvoice userInvoice) {
        if (userInvoice.getPage() != null && userInvoice.getRows() != null) {
            PageHelper.startPage(userInvoice.getPage(), userInvoice.getRows());
        }
        return userInvoiceMapper.selectAll();
    }

    public UserInvoice getById(Integer id) {
        return userInvoiceMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        userInvoiceMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(UserInvoice userInvoice) {
        if (userInvoice.getId() != null) {
            userInvoiceMapper.updateByPrimaryKey(userInvoice);
        } else {
            userInvoiceMapper.insert(userInvoice);
        }
    }
}