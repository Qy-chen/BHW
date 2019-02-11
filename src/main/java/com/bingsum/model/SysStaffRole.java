/**
 * @filename:SysStaffRole 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.model;

import java.util.Date;
import java.math.BigDecimal;


/**   
 *  
 * @Description:  后台角色
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */

	
public class SysStaffRole {
	
	//员工id
	private Integer staffId;
	//角色id
	private Integer roleId;


	public Integer getStaffId(){
	    return this.staffId;
	}
	
	public void setStaffId(Integer staffId){
	    this.staffId = staffId;
	}

	public Integer getRoleId(){
	    return this.roleId;
	}
	
	public void setRoleId(Integer roleId){
	    this.roleId = roleId;
	}
}
