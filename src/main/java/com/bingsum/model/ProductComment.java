/**
 * @filename:ProductComment 2019-02-15 11:22:39
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.model;

import java.util.Date;



/**   
 *  
 * @Description:  产品评论
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-15 11:22:39
 * @Version:      V1.0.0
 *    
 */

	
public class ProductComment extends BaseEntity {
	
	//评论内容
	private String message;
	//图片链接
	private String photoLink;
	//用户id
	private Integer userId;
	//厂家id
	private Integer manufacturerId;
	//订单id
	private Integer orderId;
	//产品id
	private Integer productId;
	//产品名称
	private String productName;
	//skuid
	private Integer skuId;
	//0:待审核 1:通过 2:不通过
	private Integer status;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;
	//删除时间
	private Date deleteTime;
	//回复id
	private Integer recoveryId;
	//创建人ID
	private Integer createBy;
	//最后修改人
	private Integer updateBy;


	public String getMessage(){
	    return this.message;
	}
	
	public void setMessage(String message){
	    this.message = message;
	}

	public String getPhotoLink(){
	    return this.photoLink;
	}
	
	public void setPhotoLink(String photoLink){
	    this.photoLink = photoLink;
	}

	public Integer getUserId(){
	    return this.userId;
	}
	
	public void setUserId(Integer userId){
	    this.userId = userId;
	}

	public Integer getManufacturerId(){
	    return this.manufacturerId;
	}
	
	public void setManufacturerId(Integer manufacturerId){
	    this.manufacturerId = manufacturerId;
	}

	public Integer getOrderId(){
	    return this.orderId;
	}
	
	public void setOrderId(Integer orderId){
	    this.orderId = orderId;
	}

	public Integer getProductId(){
	    return this.productId;
	}
	
	public void setProductId(Integer productId){
	    this.productId = productId;
	}

	public String getProductName(){
	    return this.productName;
	}
	
	public void setProductName(String productName){
	    this.productName = productName;
	}

	public Integer getSkuId(){
	    return this.skuId;
	}
	
	public void setSkuId(Integer skuId){
	    this.skuId = skuId;
	}

	public Integer getStatus(){
	    return this.status;
	}
	
	public void setStatus(Integer status){
	    this.status = status;
	}

	public Date getCreateTime(){
	    return this.createTime;
	}
	
	public void setCreateTime(Date createTime){
	    this.createTime = createTime;
	}

	public Date getUpdateTime(){
	    return this.updateTime;
	}
	
	public void setUpdateTime(Date updateTime){
	    this.updateTime = updateTime;
	}

	public Date getDeleteTime(){
	    return this.deleteTime;
	}
	
	public void setDeleteTime(Date deleteTime){
	    this.deleteTime = deleteTime;
	}

	public Integer getRecoveryId() {
		return recoveryId;
	}

	public void setRecoveryId(Integer recoveryId) {
		this.recoveryId = recoveryId;
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
