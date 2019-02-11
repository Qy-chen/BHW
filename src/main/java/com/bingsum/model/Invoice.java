/**
 * @filename:Invoice 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.model;

import java.util.Date;



/**   
 *  
 * @Description:  发票信息
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */

	
public class Invoice extends BaseEntity {
	
	//抬头
	private String title;
	//税号
	private String registrationNumber;
	//开户银行
	private String bank;
	//开户行帐号
	private String bankAccount;
	//注册地址
	private String registerAddress;
	//注册电话
	private String registerCellphone;
	//1.公司、2.个人
	private Integer isCompany;
	//
	private String email;
	//
	private Date createTime;


	public String getTitle(){
	    return this.title;
	}
	
	public void setTitle(String title){
	    this.title = title;
	}

	public String getRegistrationNumber(){
	    return this.registrationNumber;
	}
	
	public void setRegistrationNumber(String registrationNumber){
	    this.registrationNumber = registrationNumber;
	}

	public String getBank(){
	    return this.bank;
	}
	
	public void setBank(String bank){
	    this.bank = bank;
	}

	public String getBankAccount(){
	    return this.bankAccount;
	}
	
	public void setBankAccount(String bankAccount){
	    this.bankAccount = bankAccount;
	}

	public String getRegisterAddress(){
	    return this.registerAddress;
	}
	
	public void setRegisterAddress(String registerAddress){
	    this.registerAddress = registerAddress;
	}

	public String getRegisterCellphone(){
	    return this.registerCellphone;
	}
	
	public void setRegisterCellphone(String registerCellphone){
	    this.registerCellphone = registerCellphone;
	}

	public Integer getIsCompany(){
	    return this.isCompany;
	}
	
	public void setIsCompany(Integer isCompany){
	    this.isCompany = isCompany;
	}

	public String getEmail(){
	    return this.email;
	}
	
	public void setEmail(String email){
	    this.email = email;
	}

	public Date getCreateTime(){
	    return this.createTime;
	}
	
	public void setCreateTime(Date createTime){
	    this.createTime = createTime;
	}
}
