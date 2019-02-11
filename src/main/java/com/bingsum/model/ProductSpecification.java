/**
 * @filename:ProductSpecification 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.model;

import java.util.Date;
import java.math.BigDecimal;


/**   
 *  
 * @Description:  产品规格名称
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */

	
public class ProductSpecification extends BaseEntity {
	
	//
	private String value;


	public String getValue(){
	    return this.value;
	}
	
	public void setValue(String value){
	    this.value = value;
	}
}
