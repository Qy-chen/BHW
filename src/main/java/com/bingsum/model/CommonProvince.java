/**
 * @filename:CommonProvince 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.model;





/**   
 *  
 * @Description:  省级地名
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */

	
public class CommonProvince extends BaseEntity {
	
	//
	private String name;
	//
	private Integer countryId;
	//
	private Integer code;


	public String getName(){
	    return this.name;
	}
	
	public void setName(String name){
	    this.name = name;
	}

	public Integer getCountryId(){
	    return this.countryId;
	}
	
	public void setCountryId(Integer countryId){
	    this.countryId = countryId;
	}

	public Integer getCode(){
	    return this.code;
	}
	
	public void setCode(Integer code){
	    this.code = code;
	}
}
