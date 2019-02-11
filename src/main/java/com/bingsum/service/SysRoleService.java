/**
 * @filename:SysRoleServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.SysRole;
import com.bingsum.mapper.SysRoleMapper;

/**   
 *  
 * @Description:  角色——SERVICE
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
@Service("sysRoleService")
@Transactional(readOnly = true)
public class SysRoleService{

    @Autowired
    private SysRoleMapper sysRoleMapper;
	
    public List<SysRole> getAll(SysRole sysRole) {
        if (sysRole.getPage() != null && sysRole.getRows() != null) {
            PageHelper.startPage(sysRole.getPage(), sysRole.getRows());
        }
        return sysRoleMapper.selectAll();
    }

    public SysRole getById(Integer id) {
        return sysRoleMapper.selectByPrimaryKey(id);
    }
    
    @Transactional(readOnly = false)
    public void deleteById(Integer id) {
        sysRoleMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false)
    public void save(SysRole sysRole) {
        if (sysRole.getId() != null) {
            sysRoleMapper.updateByPrimaryKey(sysRole);
        } else {
            sysRoleMapper.insert(sysRole);
        }
    }
}