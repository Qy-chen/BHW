/**
 * @filename:ProductCategory 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.model;

import java.util.Date;
import java.math.BigDecimal;


/**   
 *  
 * @Description:  产品类型
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */

	
public class ProductCategory extends BaseEntity {
	
	//
	private String name;
	//
	private Integer productClassId;


	public String getName(){
	    return this.name;
	}
	
	public void setName(String name){
	    this.name = name;
	}

	public Integer getProductClassId(){
	    return this.productClassId;
	}
	
	public void setProductClassId(Integer productClassId){
	    this.productClassId = productClassId;
	}
}
