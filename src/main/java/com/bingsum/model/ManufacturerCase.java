/**
 * @filename:ManufacturerCase 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.model;

import java.util.Date;
import java.math.BigDecimal;


/**   
 *  
 * @Description:  [暂未用到]工厂案例
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */

	
public class ManufacturerCase extends BaseEntity {
	
	//
	private Integer manufacturerId;
	//标题
	private String name;
	//富文本详情
	private String details;
	//状态 0未审核1审核通过2审核拒绝
	private String status;
	
	private Date createTime;
	
	private Date deleteTime;

	private Date updateTime;

	//创建人ID
	private Integer createBy;
	//最后修改人
	private Integer updateBy;

	public Integer getManufacturerId(){
	    return this.manufacturerId;
	}
	
	public void setManufacturerId(Integer manufacturerId){
	    this.manufacturerId = manufacturerId;
	}

	public String getName(){
	    return this.name;
	}
	
	public void setName(String name){
	    this.name = name;
	}

	public String getDetails(){
	    return this.details;
	}
	
	public void setDetails(String details){
	    this.details = details;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}

	public Integer getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	public Integer getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}
}
