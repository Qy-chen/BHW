/**
 * @filename:User 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.model;

import java.util.Date;
import java.math.BigDecimal;


/**   
 *  
 * @Description:  用户表
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */

	
public class User extends BaseEntity {
	
	//用户名
	private String username;
	//密码
	private String password;
	//手机号码
	private String cellphone;
	//邮箱
	private String email;
	//名称
	private String name;
	//性别
	private String gender;
	//出生日期
	private Date dob;
	//
	private Date createTime;
	//
	private Date updateTime;
	//
	private Date deleteTime;
	//用户状态
	private Integer status;
	//头像
	private String image;
	//身份证号码
	private String idNumber;
	//积分
	private Integer integral;


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

	public String getCellphone(){
	    return this.cellphone;
	}
	
	public void setCellphone(String cellphone){
	    this.cellphone = cellphone;
	}

	public String getEmail(){
	    return this.email;
	}
	
	public void setEmail(String email){
	    this.email = email;
	}

	public String getName(){
	    return this.name;
	}
	
	public void setName(String name){
	    this.name = name;
	}

	public String getGender(){
	    return this.gender;
	}
	
	public void setGender(String gender){
	    this.gender = gender;
	}

	public Date getDob(){
	    return this.dob;
	}
	
	public void setDob(Date dob){
	    this.dob = dob;
	}

	public Date getCreateTime(){
	    return this.createTime;
	}
	
	public void setCreateTime(Date createTime){
	    this.createTime = createTime;
	}

	public Date getUpdateTime(){
	    return this.updateTime;
	}
	
	public void setUpdateTime(Date updateTime){
	    this.updateTime = updateTime;
	}

	public Date getDeleteTime(){
	    return this.deleteTime;
	}
	
	public void setDeleteTime(Date deleteTime){
	    this.deleteTime = deleteTime;
	}

	public Integer getStatus(){
	    return this.status;
	}
	
	public void setStatus(Integer status){
	    this.status = status;
	}

	public String getImage(){
	    return this.image;
	}
	
	public void setImage(String image){
	    this.image = image;
	}

	public String getIdNumber(){
	    return this.idNumber;
	}
	
	public void setIdNumber(String idNumber){
	    this.idNumber = idNumber;
	}

	public Integer getIntegral(){
	    return this.integral;
	}
	
	public void setIntegral(Integer integral){
	    this.integral = integral;
	}
}
