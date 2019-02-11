/**
 * @filename:SysAuthServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.SysAuth;
import com.bingsum.mapper.SysAuthMapper;

/**   
 *  
 * @Description:  权限——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("sysAuthService")
@Transactional(readOnly = true)
public class SysAuthService{

    @Autowired
    private SysAuthMapper sysAuthMapper;
	
    public List<SysAuth> getAll(SysAuth sysAuth) {
        if (sysAuth.getPage() != null && sysAuth.getRows() != null) {
            PageHelper.startPage(sysAuth.getPage(), sysAuth.getRows());
        }
        return sysAuthMapper.selectAll();
    }

    public SysAuth getById(Integer id) {
        return sysAuthMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        sysAuthMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(SysAuth sysAuth) {
        if (sysAuth.getId() != null) {
            sysAuthMapper.updateByPrimaryKey(sysAuth);
        } else {
            sysAuthMapper.insert(sysAuth);
        }
    }
}