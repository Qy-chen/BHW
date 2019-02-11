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
}
