/**
 * @filename:UserInvoice 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.model;

import java.util.Date;
import java.math.BigDecimal;


/**   
 *  
 * @Description:  用户关联发票
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */

	
public class UserInvoice extends BaseEntity {
	
	//发票id
	private Integer invoiceId;
	//
	private Integer userId;
	//
	private Date createTime;
	//0:正在关联 1:已无关联
	private Integer isRelevance;


	public Integer getInvoiceId(){
	    return this.invoiceId;
	}
	
	public void setInvoiceId(Integer invoiceId){
	    this.invoiceId = invoiceId;
	}

	public Integer getUserId(){
	    return this.userId;
	}
	
	public void setUserId(Integer userId){
	    this.userId = userId;
	}

	public Date getCreateTime(){
	    return this.createTime;
	}
	
	public void setCreateTime(Date createTime){
	    this.createTime = createTime;
	}

	public Integer getIsRelevance(){
	    return this.isRelevance;
	}
	
	public void setIsRelevance(Integer isRelevance){
	    this.isRelevance = isRelevance;
	}
}
