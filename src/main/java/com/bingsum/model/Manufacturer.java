/**
 * @filename:Manufacturer 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.model;

import java.util.Date;
import java.math.BigDecimal;


/**   
 *  
 * @Description:  工厂信息
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */

	
public class Manufacturer extends BaseEntity {
	
	//工厂名称
	private String name;
	//主营业务
	private String mainMarket;
	//
	private Date createTime;
	//国家
	private String country;
	//省
	private String province;
	//市
	private String city;
	//区、
	private String address;
	//工厂位置
	private String factoryAddress;
	//联系人姓名
	private String contact;
	//联系地址
	private String contactPosition;
	//联系座机号码
	private String contactTelphone;
	//联系人手机号码
	private String contactCellphone;
	//联系人邮箱
	private String contactEmail;
	//工厂面积
	private Integer factoryArea;
	//员工人数
	private Integer factoryEmployeeCount;
	//年产值
	private BigDecimal factoryAnnualProduction;
	//年纳税
	private BigDecimal annualPaidTax;
	//公司简介
	private String intro;
	//公司网站地址
	private String website;
	//税点
	private String taxPoint;
	//付款方式：预付百分数、
	private String paymentMethod;
	//交货周期
	private String deliveryTime;
	//纳税识别号
	private String tfn;
	//开户银行
	private String bank;
	//银行账户
	private Long bankAccount;
	//行号
	private Long bankCode;
	//专利号
	private Integer patent;
	//返点
	private String rebates;
	//删除时间
	private Date deleteTime;
	//最后修改时间
	private Date updateTime;
	//创建人
	private Integer createBy;
	//最后修改人
	private Integer updateBy;


	public String getName(){
	    return this.name;
	}
	
	public void setName(String name){
	    this.name = name;
	}

	public String getMainMarket(){
	    return this.mainMarket;
	}
	
	public void setMainMarket(String mainMarket){
	    this.mainMarket = mainMarket;
	}

	public Date getCreateTime(){
	    return this.createTime;
	}
	
	public void setCreateTime(Date createTime){
	    this.createTime = createTime;
	}

	public String getCountry(){
	    return this.country;
	}
	
	public void setCountry(String country){
	    this.country = country;
	}

	public String getProvince(){
	    return this.province;
	}
	
	public void setProvince(String province){
	    this.province = province;
	}

	public String getCity(){
	    return this.city;
	}
	
	public void setCity(String city){
	    this.city = city;
	}

	public String getAddress(){
	    return this.address;
	}
	
	public void setAddress(String address){
	    this.address = address;
	}

	public String getFactoryAddress(){
	    return this.factoryAddress;
	}
	
	public void setFactoryAddress(String factoryAddress){
	    this.factoryAddress = factoryAddress;
	}

	public String getContact(){
	    return this.contact;
	}
	
	public void setContact(String contact){
	    this.contact = contact;
	}

	public String getContactPosition(){
	    return this.contactPosition;
	}
	
	public void setContactPosition(String contactPosition){
	    this.contactPosition = contactPosition;
	}

	public String getContactTelphone(){
	    return this.contactTelphone;
	}
	
	public void setContactTelphone(String contactTelphone){
	    this.contactTelphone = contactTelphone;
	}

	public String getContactCellphone(){
	    return this.contactCellphone;
	}
	
	public void setContactCellphone(String contactCellphone){
	    this.contactCellphone = contactCellphone;
	}

	public String getContactEmail(){
	    return this.contactEmail;
	}
	
	public void setContactEmail(String contactEmail){
	    this.contactEmail = contactEmail;
	}

	public Integer getFactoryArea(){
	    return this.factoryArea;
	}
	
	public void setFactoryArea(Integer factoryArea){
	    this.factoryArea = factoryArea;
	}

	public Integer getFactoryEmployeeCount(){
	    return this.factoryEmployeeCount;
	}
	
	public void setFactoryEmployeeCount(Integer factoryEmployeeCount){
	    this.factoryEmployeeCount = factoryEmployeeCount;
	}

	public BigDecimal getFactoryAnnualProduction(){
	    return this.factoryAnnualProduction;
	}
	
	public void setFactoryAnnualProduction(BigDecimal factoryAnnualProduction){
	    this.factoryAnnualProduction = factoryAnnualProduction;
	}

	public BigDecimal getAnnualPaidTax(){
	    return this.annualPaidTax;
	}
	
	public void setAnnualPaidTax(BigDecimal annualPaidTax){
	    this.annualPaidTax = annualPaidTax;
	}

	public String getIntro(){
	    return this.intro;
	}
	
	public void setIntro(String intro){
	    this.intro = intro;
	}

	public String getWebsite(){
	    return this.website;
	}
	
	public void setWebsite(String website){
	    this.website = website;
	}

	public String getTaxPoint(){
	    return this.taxPoint;
	}
	
	public void setTaxPoint(String taxPoint){
	    this.taxPoint = taxPoint;
	}

	public String getPaymentMethod(){
	    return this.paymentMethod;
	}
	
	public void setPaymentMethod(String paymentMethod){
	    this.paymentMethod = paymentMethod;
	}

	public String getDeliveryTime(){
	    return this.deliveryTime;
	}
	
	public void setDeliveryTime(String deliveryTime){
	    this.deliveryTime = deliveryTime;
	}

	public String getTfn(){
	    return this.tfn;
	}
	
	public void setTfn(String tfn){
	    this.tfn = tfn;
	}

	public String getBank(){
	    return this.bank;
	}
	
	public void setBank(String bank){
	    this.bank = bank;
	}

	public Long getBankAccount(){
	    return this.bankAccount;
	}
	
	public void setBankAccount(Long bankAccount){
	    this.bankAccount = bankAccount;
	}

	public Long getBankCode(){
	    return this.bankCode;
	}
	
	public void setBankCode(Long bankCode){
	    this.bankCode = bankCode;
	}

	public Integer getPatent(){
	    return this.patent;
	}
	
	public void setPatent(Integer patent){
	    this.patent = patent;
	}
	
	public String getRebates(){
	    return this.rebates;
	}
	
	public void setRebates(String rebates){
	    this.rebates = rebates;
	}

	public Date getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	public Integer getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}
}
