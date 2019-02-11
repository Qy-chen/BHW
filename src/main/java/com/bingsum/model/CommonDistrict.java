/**
 * @filename:CommonDistrict 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.model;





/**   
 *  
 * @Description:  区级地名
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */

	
public class CommonDistrict extends BaseEntity {
	
	//
	private String name;
	//
	private Integer cityId;
	//
	private Integer code;


	public String getName(){
	    return this.name;
	}
	
	public void setName(String name){
	    this.name = name;
	}

	public Integer getCityId(){
	    return this.cityId;
	}
	
	public void setCityId(Integer cityId){
	    this.cityId = cityId;
	}

	public Integer getCode(){
	    return this.code;
	}
	
	public void setCode(Integer code){
	    this.code = code;
	}
}
