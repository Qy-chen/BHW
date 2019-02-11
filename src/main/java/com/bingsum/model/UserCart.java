/**
 * @filename:UserCart 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.model;

import java.util.Date;
import java.math.BigDecimal;


/**   
 *  
 * @Description:  购物车
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */

	
public class UserCart extends BaseEntity {
	
	//用户id
	private Integer userId;
	//产品sku_id
	private Integer skuId;
	//
	private Date createTime;
	//
	private Date deleteTime;
	//该数据状态
	private Integer status;
	//购物车添加数量
	private Integer count;
	//规格详情描述
	private String specificationDetail;


	public Integer getUserId(){
	    return this.userId;
	}
	
	public void setUserId(Integer userId){
	    this.userId = userId;
	}

	public Integer getSkuId(){
	    return this.skuId;
	}
	
	public void setSkuId(Integer skuId){
	    this.skuId = skuId;
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

	public Integer getStatus(){
	    return this.status;
	}
	
	public void setStatus(Integer status){
	    this.status = status;
	}

	public Integer getCount(){
	    return this.count;
	}
	
	public void setCount(Integer count){
	    this.count = count;
	}

	public String getSpecificationDetail(){
	    return this.specificationDetail;
	}
	
	public void setSpecificationDetail(String specificationDetail){
	    this.specificationDetail = specificationDetail;
	}
}
