/**
 * @filename:Product 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.model;

import java.util.Date;
import java.math.BigDecimal;


/**   
 *  
 * @Description:  产品表
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */

	
public class Product extends BaseEntity {
	
	//
	private String productNo;
	//名称
	private String name;
	//
	private Date createTime;
	//上架时间
	private Date onSaleTime;
	//下架时间
	private Date offSaleTime;
	//工厂id
	private Integer manufacturerId;
	//
	private String shape;
	//
	private String epGrade;
	//
	private String baseMaterial;
	//
	private String planeMaterial;
	//
	private String surfaceTechnics;
	//
	private String hardwareFitting;
//	///**
//     * 0 : 下架，
//     * 1 : 上架,
//     * 2 : 审核
//     */
	private Integer status;
	//富文本描述
	private String description;
	//
	private Float discount;
	//
	private Integer isGuarantee;
	//
	private Integer isReturns;
	//
	private Integer isExchange;
	//
	private String returnMethod;
	//
	private String exchangeMethod;
	//
	private Integer isOldForNew;
	//
	private Integer isOfflineShowcase;
	//
	private String offlineShowcaseLocation;
	//
	private Integer transportMethod;
	//主图
	private String imageMain;
	//多张详情图片
	private String imageDetails;
	//类型
	private Integer classId;
	//主要类别
	private Integer categoryId;
	//产品型号
	private String serialNumber;
	//
	private String productcol;
	//品牌id
	private Integer brandId;
	//产品介绍
	private String detail;
	//是否需要安装：0.需要安装、1.不需要安装
	private Integer isInstallation;
	//0.不包邮
//1.包邮
	private Integer isExpressFree;
	//0，全部
//1，只支持电子发票
	private Integer invoiceType;
	//包装件数
	private Integer packageCount;
	//
	private Integer soldCount;


	public String getProductNo(){
	    return this.productNo;
	}
	
	public void setProductNo(String productNo){
	    this.productNo = productNo;
	}

	public String getName(){
	    return this.name;
	}
	
	public void setName(String name){
	    this.name = name;
	}

	public Date getCreateTime(){
	    return this.createTime;
	}
	
	public void setCreateTime(Date createTime){
	    this.createTime = createTime;
	}

	public Date getOnSaleTime(){
	    return this.onSaleTime;
	}
	
	public void setOnSaleTime(Date onSaleTime){
	    this.onSaleTime = onSaleTime;
	}

	public Date getOffSaleTime(){
	    return this.offSaleTime;
	}
	
	public void setOffSaleTime(Date offSaleTime){
	    this.offSaleTime = offSaleTime;
	}

	public Integer getManufacturerId(){
	    return this.manufacturerId;
	}
	
	public void setManufacturerId(Integer manufacturerId){
	    this.manufacturerId = manufacturerId;
	}

	public String getShape(){
	    return this.shape;
	}
	
	public void setShape(String shape){
	    this.shape = shape;
	}

	public String getEpGrade(){
	    return this.epGrade;
	}
	
	public void setEpGrade(String epGrade){
	    this.epGrade = epGrade;
	}

	public String getBaseMaterial(){
	    return this.baseMaterial;
	}
	
	public void setBaseMaterial(String baseMaterial){
	    this.baseMaterial = baseMaterial;
	}

	public String getPlaneMaterial(){
	    return this.planeMaterial;
	}
	
	public void setPlaneMaterial(String planeMaterial){
	    this.planeMaterial = planeMaterial;
	}

	public String getSurfaceTechnics(){
	    return this.surfaceTechnics;
	}
	
	public void setSurfaceTechnics(String surfaceTechnics){
	    this.surfaceTechnics = surfaceTechnics;
	}

	public String getHardwareFitting(){
	    return this.hardwareFitting;
	}
	
	public void setHardwareFitting(String hardwareFitting){
	    this.hardwareFitting = hardwareFitting;
	}

	public Integer getStatus(){
	    return this.status;
	}
	
	public void setStatus(Integer status){
	    this.status = status;
	}

	public String getDescription(){
	    return this.description;
	}
	
	public void setDescription(String description){
	    this.description = description;
	}

	public Float getDiscount(){
	    return this.discount;
	}
	
	public void setDiscount(Float discount){
	    this.discount = discount;
	}

	public Integer getIsGuarantee(){
	    return this.isGuarantee;
	}
	
	public void setIsGuarantee(Integer isGuarantee){
	    this.isGuarantee = isGuarantee;
	}

	public Integer getIsReturns(){
	    return this.isReturns;
	}
	
	public void setIsReturns(Integer isReturns){
	    this.isReturns = isReturns;
	}

	public Integer getIsExchange(){
	    return this.isExchange;
	}
	
	public void setIsExchange(Integer isExchange){
	    this.isExchange = isExchange;
	}

	public String getReturnMethod(){
	    return this.returnMethod;
	}
	
	public void setReturnMethod(String returnMethod){
	    this.returnMethod = returnMethod;
	}

	public String getExchangeMethod(){
	    return this.exchangeMethod;
	}
	
	public void setExchangeMethod(String exchangeMethod){
	    this.exchangeMethod = exchangeMethod;
	}

	public Integer getIsOldForNew(){
	    return this.isOldForNew;
	}
	
	public void setIsOldForNew(Integer isOldForNew){
	    this.isOldForNew = isOldForNew;
	}

	public Integer getIsOfflineShowcase(){
	    return this.isOfflineShowcase;
	}
	
	public void setIsOfflineShowcase(Integer isOfflineShowcase){
	    this.isOfflineShowcase = isOfflineShowcase;
	}

	public String getOfflineShowcaseLocation(){
	    return this.offlineShowcaseLocation;
	}
	
	public void setOfflineShowcaseLocation(String offlineShowcaseLocation){
	    this.offlineShowcaseLocation = offlineShowcaseLocation;
	}

	public Integer getTransportMethod(){
	    return this.transportMethod;
	}
	
	public void setTransportMethod(Integer transportMethod){
	    this.transportMethod = transportMethod;
	}

	public String getImageMain(){
	    return this.imageMain;
	}
	
	public void setImageMain(String imageMain){
	    this.imageMain = imageMain;
	}

	public String getImageDetails(){
	    return this.imageDetails;
	}
	
	public void setImageDetails(String imageDetails){
	    this.imageDetails = imageDetails;
	}

	public Integer getClassId(){
	    return this.classId;
	}
	
	public void setClassId(Integer classId){
	    this.classId = classId;
	}

	public Integer getCategoryId(){
	    return this.categoryId;
	}
	
	public void setCategoryId(Integer categoryId){
	    this.categoryId = categoryId;
	}

	public String getSerialNumber(){
	    return this.serialNumber;
	}
	
	public void setSerialNumber(String serialNumber){
	    this.serialNumber = serialNumber;
	}

	public String getProductcol(){
	    return this.productcol;
	}
	
	public void setProductcol(String productcol){
	    this.productcol = productcol;
	}

	public Integer getBrandId(){
	    return this.brandId;
	}
	
	public void setBrandId(Integer brandId){
	    this.brandId = brandId;
	}

	public String getDetail(){
	    return this.detail;
	}
	
	public void setDetail(String detail){
	    this.detail = detail;
	}

	public Integer getIsInstallation(){
	    return this.isInstallation;
	}
	
	public void setIsInstallation(Integer isInstallation){
	    this.isInstallation = isInstallation;
	}

	public Integer getIsExpressFree(){
	    return this.isExpressFree;
	}
	
	public void setIsExpressFree(Integer isExpressFree){
	    this.isExpressFree = isExpressFree;
	}

	public Integer getInvoiceType(){
	    return this.invoiceType;
	}
	
	public void setInvoiceType(Integer invoiceType){
	    this.invoiceType = invoiceType;
	}

	public Integer getPackageCount(){
	    return this.packageCount;
	}
	
	public void setPackageCount(Integer packageCount){
	    this.packageCount = packageCount;
	}

	public Integer getSoldCount(){
	    return this.soldCount;
	}
	
	public void setSoldCount(Integer soldCount){
	    this.soldCount = soldCount;
	}
}
