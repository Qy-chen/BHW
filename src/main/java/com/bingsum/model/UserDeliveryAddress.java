/**
 * @filename:UserDeliveryAddress 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.model;

import java.util.Date;
import java.math.BigDecimal;


/**   
 *  
 * @Description:  用户收货地址
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */

	
public class UserDeliveryAddress extends BaseEntity {
	
	//
	private String userId;
	//收件人
	private String addressee;
	//联系方式
	private String cellphone;
	//国家
	private Integer country;
	//省
	private Integer province;
	//市
	private Integer city;
	//街道信息
	private String address;
	//楼层
	private Integer floor;
	//是否有电梯
	private Integer isLift;
	//邮编
	private String zipCode;
	//座机号码
	private String telphone;
	//区
	private Integer district;
	//是否默认地址
	private Integer isDefault;
	//备用电话
	private String alternatePhone;


	public String getUserId(){
	    return this.userId;
	}
	
	public void setUserId(String userId){
	    this.userId = userId;
	}

	public String getAddressee(){
	    return this.addressee;
	}
	
	public void setAddressee(String addressee){
	    this.addressee = addressee;
	}

	public String getCellphone(){
	    return this.cellphone;
	}
	
	public void setCellphone(String cellphone){
	    this.cellphone = cellphone;
	}

	public Integer getCountry(){
	    return this.country;
	}
	
	public void setCountry(Integer country){
	    this.country = country;
	}

	public Integer getProvince(){
	    return this.province;
	}
	
	public void setProvince(Integer province){
	    this.province = province;
	}

	public Integer getCity(){
	    return this.city;
	}
	
	public void setCity(Integer city){
	    this.city = city;
	}

	public String getAddress(){
	    return this.address;
	}
	
	public void setAddress(String address){
	    this.address = address;
	}

	public Integer getFloor(){
	    return this.floor;
	}
	
	public void setFloor(Integer floor){
	    this.floor = floor;
	}

	public Integer getIsLift(){
	    return this.isLift;
	}
	
	public void setIsLift(Integer isLift){
	    this.isLift = isLift;
	}

	public String getZipCode(){
	    return this.zipCode;
	}
	
	public void setZipCode(String zipCode){
	    this.zipCode = zipCode;
	}

	public String getTelphone(){
	    return this.telphone;
	}
	
	public void setTelphone(String telphone){
	    this.telphone = telphone;
	}

	public Integer getDistrict(){
	    return this.district;
	}
	
	public void setDistrict(Integer district){
	    this.district = district;
	}

	public Integer getIsDefault(){
	    return this.isDefault;
	}
	
	public void setIsDefault(Integer isDefault){
	    this.isDefault = isDefault;
	}

	public String getAlternatePhone(){
	    return this.alternatePhone;
	}
	
	public void setAlternatePhone(String alternatePhone){
	    this.alternatePhone = alternatePhone;
	}
}
