/**
 * @filename:SearchBody 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.model;

import java.util.Date;
import java.math.BigDecimal;


/**   
 *  
 * @Description:  用户搜索内容
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */

	
public class SearchBody extends BaseEntity {
	
	//
	private String value;
	//
	private Date createTime;


	public String getValue(){
	    return this.value;
	}
	
	public void setValue(String value){
	    this.value = value;
	}

	public Date getCreateTime(){
	    return this.createTime;
	}
	
	public void setCreateTime(Date createTime){
	    this.createTime = createTime;
	}
}
