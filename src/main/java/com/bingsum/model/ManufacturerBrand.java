/**
 * @filename:ManufacturerBrand 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.model;

import java.util.Date;
import java.math.BigDecimal;


/**   
 *  
 * @Description:  工厂旗下品牌
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */

	
public class ManufacturerBrand extends BaseEntity {
	
	//工厂id
	private Integer manufacturerId;
	//品牌名
	private String name;
	//创建时间
	private Date createTime;
	//删除时间
	private Date deleteTime;
	//更新时间
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

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	public Integer getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}
}
