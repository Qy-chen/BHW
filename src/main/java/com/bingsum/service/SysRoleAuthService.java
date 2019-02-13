/**
 * @filename:SysRoleAuthServiceImpl 2019-02-11 14:25:12
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

import com.bingsum.model.Staff;
import com.bingsum.model.SysRoleAuth;
import com.bingsum.util.ApiUtil;
import com.bingsum.util.ParaData;
import com.bingsum.util.StrUtil;
import com.bingsum.annotation.Api;
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
    
    /**
     * 查询角色的权限列表
     * @param pd
     * @return
     */
    @Api(notNullPara="roleId")
    @Transactional(readOnly = false)
    public Object getRoleAuthList(ParaData pd) {
    	List<ParaData> list = this.sysRoleAuthMapper.selectAuthByRole(pd.getInteger("roleId"));
    	return ApiUtil.returnOK(pd, list);
    }
    
    /**
     * 设置角色权限
     * @param pd
     * @return
     */
    @Api(notNullPara="roleId,authIds")
    @Transactional(readOnly = false)
    public Object setRoleAuthList(ParaData pd) {
    	SysRoleAuth record = pd.toBean(SysRoleAuth.class);
    	this.sysRoleAuthMapper.delete(record);
    	String authArr = pd.getString("authIds");
    	if(StringUtils.isNoneBlank(authArr)) {
        	List<SysRoleAuth> recordList = new ArrayList<SysRoleAuth>();
        	String[] arr = authArr.split(",");
        	for(String authId : arr) {
        		SysRoleAuth sra = new SysRoleAuth();
        		sra.setAuthId(StrUtil.toInteger(authId));
        		sra.setRoleId(record.getRoleId());
        		recordList.add(sra);
        	}
        	this.sysRoleAuthMapper.insertList(recordList);
    	}
    	return ApiUtil.returnOK();
    }
}