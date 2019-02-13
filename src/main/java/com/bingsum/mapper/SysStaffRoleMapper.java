/**
 * @filename:SysStaffRoleDao 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.mapper;

import com.bingsum.util.MyMapper;
import com.bingsum.util.ParaData;

import java.util.List;

import com.bingsum.model.SysStaffRole;

/**   
 *  
 * @Description:  后台角色——Mapper
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */
public interface SysStaffRoleMapper extends MyMapper<SysStaffRole> {
	
	/**
	 * 查询后台人员角色列表
	 * @param staffId
	 * @return
	 */
	public List<ParaData> selectRoleListByStaff(Integer staffId);
}
