/**
 * @filename:Staff 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.model;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.bingsum.util.MD5Util;

import java.math.BigDecimal;


/**   
 *  
 * @Description:  [暂未用到]员工表
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */

	
public class Staff extends BaseEntity {
	
	//
	private String username;
	//
	private String password;
	//
	private Date createTime;
	//
	private Date hireTime;
	//
	private Date resignedTime;
	//
	private Integer status;
	//
	private String name;
	//
	private Date dob;
	//
	private String gender;
	//
	private String position;
	//
	private String department;
	//
	private String cellphone;
	//
	private String bankAccount;
	//
	private String bankName;
	//
	private String email;
	//
	private String homeAddress;
	//
	private Integer homeCity;
	//
	private Integer homeProvince;
	//
	private Integer homeCountry;
	//
	private String emergencyContact;
	//
	private String emergencyContactRelation;
	//
	private String emergencyContactCellphone;
	//登录token
	private String token;
	//所属厂商
	private Integer manufacturer_id;

	public String getUsername(){
	    return this.username;
	}
	
	public void setUsername(String username){
	    this.username = username;
	}

	public String getPassword(){
	    return this.password;
	}
	
	public void setPassword(String password){
	    this.password = password;
	}

	public Date getCreateTime(){
	    return this.createTime;
	}
	
	public void setCreateTime(Date createTime){
	    this.createTime = createTime;
	}

	public Date getHireTime(){
	    return this.hireTime;
	}
	
	public void setHireTime(Date hireTime){
	    this.hireTime = hireTime;
	}

	public Date getResignedTime(){
	    return this.resignedTime;
	}
	
	public void setResignedTime(Date resignedTime){
	    this.resignedTime = resignedTime;
	}

	public Integer getStatus(){
	    return this.status;
	}
	
	public void setStatus(Integer status){
	    this.status = status;
	}

	public String getName(){
	    return this.name;
	}
	
	public void setName(String name){
	    this.name = name;
	}

	public Date getDob(){
	    return this.dob;
	}
	
	public void setDob(Date dob){
	    this.dob = dob;
	}

	public String getGender(){
	    return this.gender;
	}
	
	public void setGender(String gender){
	    this.gender = gender;
	}

	public String getPosition(){
	    return this.position;
	}
	
	public void setPosition(String position){
	    this.position = position;
	}

	public String getDepartment(){
	    return this.department;
	}
	
	public void setDepartment(String department){
	    this.department = department;
	}

	public String getCellphone(){
	    return this.cellphone;
	}
	
	public void setCellphone(String cellphone){
	    this.cellphone = cellphone;
	}

	public String getBankAccount(){
	    return this.bankAccount;
	}
	
	public void setBankAccount(String bankAccount){
	    this.bankAccount = bankAccount;
	}

	public String getBankName(){
	    return this.bankName;
	}
	
	public void setBankName(String bankName){
	    this.bankName = bankName;
	}

	public String getEmail(){
	    return this.email;
	}
	
	public void setEmail(String email){
	    this.email = email;
	}

	public String getHomeAddress(){
	    return this.homeAddress;
	}
	
	public void setHomeAddress(String homeAddress){
	    this.homeAddress = homeAddress;
	}

	public Integer getHomeCity(){
	    return this.homeCity;
	}
	
	public void setHomeCity(Integer homeCity){
	    this.homeCity = homeCity;
	}

	public Integer getHomeProvince(){
	    return this.homeProvince;
	}
	
	public void setHomeProvince(Integer homeProvince){
	    this.homeProvince = homeProvince;
	}

	public Integer getHomeCountry(){
	    return this.homeCountry;
	}
	
	public void setHomeCountry(Integer homeCountry){
	    this.homeCountry = homeCountry;
	}

	public String getEmergencyContact(){
	    return this.emergencyContact;
	}
	
	public void setEmergencyContact(String emergencyContact){
	    this.emergencyContact = emergencyContact;
	}

	public String getEmergencyContactRelation(){
	    return this.emergencyContactRelation;
	}
	
	public void setEmergencyContactRelation(String emergencyContactRelation){
	    this.emergencyContactRelation = emergencyContactRelation;
	}

	public String getEmergencyContactCellphone(){
	    return this.emergencyContactCellphone;
	}
	
	public void setEmergencyContactCellphone(String emergencyContactCellphone){
	    this.emergencyContactCellphone = emergencyContactCellphone;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	/**
	 * 加密密码明文
	 */
	public void enPwd() {
		if(StringUtils.isNotBlank(this.getPassword())) {
			String enPwd = MD5Util.MD5Encode(this.getPassword(), "UTF-8");
			this.setPassword(enPwd);
		}
	}

	public Integer getManufacturer_id() {
		return manufacturer_id;
	}

	public void setManufacturer_id(Integer manufacturer_id) {
		this.manufacturer_id = manufacturer_id;
	}
}
