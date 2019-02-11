/**
 * @filename:UserStatus 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.model;

import java.util.Date;
import java.math.BigDecimal;


/**   
 *  
 * @Description:  [暂未用到]用户状态
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */

	
public class UserStatus extends BaseEntity {
	
	//
	private String name;


	public String getName(){
	    return this.name;
	}
	
	public void setName(String name){
	    this.name = name;
	}
}
