/**
 * @filename:SysStaffRoleServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.SysStaffRole;
import com.bingsum.mapper.SysStaffRoleMapper;

/**   
 *  
 * @Description:  后台角色——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("sysStaffRoleService")
@Transactional(readOnly = true)
public class SysStaffRoleService{

    @Autowired
    private SysStaffRoleMapper sysStaffRoleMapper;
	

    @Transactional(readOnly = false)
    public void save(SysStaffRole sysStaffRole) {
    	sysStaffRoleMapper.insert(sysStaffRole);
    }
}