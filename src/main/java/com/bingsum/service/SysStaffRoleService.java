/**
 * @filename:SysStaffRoleServiceImpl 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;

import java.util.ArrayList;
import java.util.List;

import com.bingsum.model.SysStaffRole;
import com.bingsum.model.SysStaffRole;
import com.bingsum.util.ApiUtil;
import com.bingsum.util.ParaData;
import com.bingsum.util.StrUtil;
import com.bingsum.annotation.Api;
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
    
    /**
     * 查询用户的角色列表
     * @param pd
     * @return
     */
    @Api(notNullPara="staffId")
    @Transactional(readOnly = false)
    public Object getStaffRoleList(ParaData pd) {
    	List<ParaData> list = this.sysStaffRoleMapper.selectRoleListByStaff(pd.getInteger("staffId"));
    	return ApiUtil.returnOK(pd, list);
    }
    
    /**
     * 设置用户角色
     * @param pd
     * @return
     */
    @Api(notNullPara="roleIds,staffId")
    @Transactional(readOnly = false)
    public Object setStaffRoleList(ParaData pd) {
    	SysStaffRole record = pd.toBean(SysStaffRole.class);
    	this.sysStaffRoleMapper.delete(record);
    	String roleIds = pd.getString("roleIds");
    	if(StringUtils.isNoneBlank(roleIds)) {
        	List<SysStaffRole> recordList = new ArrayList<SysStaffRole>();
        	String[] arr = roleIds.split(",");
        	for(String roleId : arr) {
        		SysStaffRole sra = new SysStaffRole();
        		sra.setRoleId(StrUtil.toInteger(roleId));
        		sra.setStaffId(record.getStaffId());
        		recordList.add(sra);
        	}
        	this.sysStaffRoleMapper.insertList(recordList);
    	}
    	return ApiUtil.returnOK();
    }
}