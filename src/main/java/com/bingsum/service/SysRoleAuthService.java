/**
 * @filename:SysRoleAuthServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.SysRoleAuth;
import com.bingsum.mapper.SysRoleAuthMapper;

/**   
 *  
 * @Description:  角色权限关联——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("sysRoleAuthService")
@Transactional(readOnly = true)
public class SysRoleAuthService{

    @Autowired
    private SysRoleAuthMapper sysRoleAuthMapper;
	


    @Transactional(readOnly = false)
    public void save(SysRoleAuth sysRoleAuth) {
    	sysRoleAuthMapper.insert(sysRoleAuth);
    }
}