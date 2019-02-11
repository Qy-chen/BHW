/**
 * @filename:SysRoleAuth 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.model;

import java.util.Date;
import java.math.BigDecimal;


/**   
 *  
 * @Description:  角色权限关联
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */

	
public class SysRoleAuth {
	
	//角色id
	private Integer roleId;
	//权限id
	private Integer authId;


	public Integer getRoleId(){
	    return this.roleId;
	}
	
	public void setRoleId(Integer roleId){
	    this.roleId = roleId;
	}

	public Integer getAuthId(){
	    return this.authId;
	}
	
	public void setAuthId(Integer authId){
	    this.authId = authId;
	}
}
