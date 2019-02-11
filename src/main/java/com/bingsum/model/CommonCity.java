/**
 * @filename:CommonCity 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.model;





/**   
 *  
 * @Description:  市级地名
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */

	
public class CommonCity extends BaseEntity {
	
	//
	private String name;
	//
	private Integer provinceId;
	//
	private Integer code;


	public String getName(){
	    return this.name;
	}
	
	public void setName(String name){
	    this.name = name;
	}

	public Integer getProvinceId(){
	    return this.provinceId;
	}
	
	public void setProvinceId(Integer provinceId){
	    this.provinceId = provinceId;
	}

	public Integer getCode(){
	    return this.code;
	}
	
	public void setCode(Integer code){
	    this.code = code;
	}
}
