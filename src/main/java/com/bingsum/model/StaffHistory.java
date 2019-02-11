/**
 * @filename:StaffHistory 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.model;

import java.util.Date;
import java.math.BigDecimal;


/**   
 *  
 * @Description:  [暂未用到]员工表
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */

	
public class StaffHistory extends BaseEntity {
	
	//
	private Integer staffId;
	//
	private String name;
	//
	private Date createTime;


	public Integer getStaffId(){
	    return this.staffId;
	}
	
	public void setStaffId(Integer staffId){
	    this.staffId = staffId;
	}

	public String getName(){
	    return this.name;
	}
	
	public void setName(String name){
	    this.name = name;
	}

	public Date getCreateTime(){
	    return this.createTime;
	}
	
	public void setCreateTime(Date createTime){
	    this.createTime = createTime;
	}
}
