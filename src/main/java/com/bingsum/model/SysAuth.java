/**
 * @filename:SysAuth 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.model;

import java.util.Date;
import java.math.BigDecimal;


/**   
 *  
 * @Description:  权限
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */

	
public class SysAuth extends BaseEntity {
	
	//权限标识
	private String tag;
	//包含接口，用逗号分隔
	private String api;
	//创建时间
	private Date createTime;
	//删除时间
	private Date deleteTime;
	//更新时间
	private Date updateTime;


	public String getTag(){
	    return this.tag;
	}
	
	public void setTag(String tag){
	    this.tag = tag;
	}

	public String getApi(){
	    return this.api;
	}
	
	public void setApi(String api){
	    this.api = api;
	}

	public Date getCreateTime(){
	    return this.createTime;
	}
	
	public void setCreateTime(Date createTime){
	    this.createTime = createTime;
	}

	public Date getDeleteTime(){
	    return this.deleteTime;
	}
	
	public void setDeleteTime(Date deleteTime){
	    this.deleteTime = deleteTime;
	}

	public Date getUpdateTime(){
	    return this.updateTime;
	}
	
	public void setUpdateTime(Date updateTime){
	    this.updateTime = updateTime;
	}
}
