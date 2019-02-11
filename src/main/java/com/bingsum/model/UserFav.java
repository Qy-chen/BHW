/**
 * @filename:UserFav 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.model;

import java.util.Date;
import java.math.BigDecimal;


/**   
 *  
 * @Description:  用户收藏产品
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */

	
public class UserFav extends BaseEntity {
	
	//
	private Integer userId;
	//
	private Integer productId;
	//
	private Date createTime;
	//0: 取消收藏 1: 收藏中
	private Integer status;
	//
	private Date updateTime;


	public Integer getUserId(){
	    return this.userId;
	}
	
	public void setUserId(Integer userId){
	    this.userId = userId;
	}

	public Integer getProductId(){
	    return this.productId;
	}
	
	public void setProductId(Integer productId){
	    this.productId = productId;
	}

	public Date getCreateTime(){
	    return this.createTime;
	}
	
	public void setCreateTime(Date createTime){
	    this.createTime = createTime;
	}

	public Integer getStatus(){
	    return this.status;
	}
	
	public void setStatus(Integer status){
	    this.status = status;
	}

	public Date getUpdateTime(){
	    return this.updateTime;
	}
	
	public void setUpdateTime(Date updateTime){
	    this.updateTime = updateTime;
	}
}
