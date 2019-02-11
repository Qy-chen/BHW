/**
 * @filename:UserOrderDetail 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.model;

import java.util.Date;
import java.math.BigDecimal;


/**   
 *  
 * @Description:  用户订单
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */

	
public class UserOrderDetail extends BaseEntity {
	
	//
	private String uid;
	//商品sku_id
	private Long skuId;
	//订单id
	private Long orderId;
	//购买数量
	private Integer count;
	//商品标题
	private String title;
	//单价
	private Float price;
	//总价
	private Long totalFee;
	//图片地址
	private String picPath;
	//
	private Long userId;
	//
	private Date createTime;
	//
	private String specification;


	public String getUid(){
	    return this.uid;
	}
	
	public void setUid(String uid){
	    this.uid = uid;
	}

	public Long getSkuId(){
	    return this.skuId;
	}
	
	public void setSkuId(Long skuId){
	    this.skuId = skuId;
	}

	public Long getOrderId(){
	    return this.orderId;
	}
	
	public void setOrderId(Long orderId){
	    this.orderId = orderId;
	}

	public Integer getCount(){
	    return this.count;
	}
	
	public void setCount(Integer count){
	    this.count = count;
	}

	public String getTitle(){
	    return this.title;
	}
	
	public void setTitle(String title){
	    this.title = title;
	}

	public Float getPrice(){
	    return this.price;
	}
	
	public void setPrice(Float price){
	    this.price = price;
	}

	public Long getTotalFee(){
	    return this.totalFee;
	}
	
	public void setTotalFee(Long totalFee){
	    this.totalFee = totalFee;
	}

	public String getPicPath(){
	    return this.picPath;
	}
	
	public void setPicPath(String picPath){
	    this.picPath = picPath;
	}

	public Long getUserId(){
	    return this.userId;
	}
	
	public void setUserId(Long userId){
	    this.userId = userId;
	}

	public Date getCreateTime(){
	    return this.createTime;
	}
	
	public void setCreateTime(Date createTime){
	    this.createTime = createTime;
	}

	public String getSpecification(){
	    return this.specification;
	}
	
	public void setSpecification(String specification){
	    this.specification = specification;
	}
}
