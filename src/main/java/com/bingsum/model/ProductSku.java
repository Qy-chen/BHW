/**
 * @filename:ProductSku 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.model;

import java.util.Date;
import java.math.BigDecimal;


/**   
 *  
 * @Description:  产品sku
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */

	
public class ProductSku extends BaseEntity {
	
	//
	private Integer productId;
	//sku编码
	private String skuCode;
	//成本
	private String costPrice;
	//优惠价
	private String salePrice;
	//售价
	private String actualPrice;
	//库存
	private Integer quantity;
	//规格id，逗号分隔
	private String spGroupId;
	//交付周期
	private Integer deliveryCycle;
	//包装尺寸
	private String packageSize;
	//安装费用
	private Integer installationFee;


	public Integer getProductId(){
	    return this.productId;
	}
	
	public void setProductId(Integer productId){
	    this.productId = productId;
	}

	public String getSkuCode(){
	    return this.skuCode;
	}
	
	public void setSkuCode(String skuCode){
	    this.skuCode = skuCode;
	}

	public String getCostPrice(){
	    return this.costPrice;
	}
	
	public void setCostPrice(String costPrice){
	    this.costPrice = costPrice;
	}

	public String getSalePrice(){
	    return this.salePrice;
	}
	
	public void setSalePrice(String salePrice){
	    this.salePrice = salePrice;
	}

	public String getActualPrice(){
	    return this.actualPrice;
	}
	
	public void setActualPrice(String actualPrice){
	    this.actualPrice = actualPrice;
	}

	public Integer getQuantity(){
	    return this.quantity;
	}
	
	public void setQuantity(Integer quantity){
	    this.quantity = quantity;
	}

	public String getSpGroupId(){
	    return this.spGroupId;
	}
	
	public void setSpGroupId(String spGroupId){
	    this.spGroupId = spGroupId;
	}

	public Integer getDeliveryCycle(){
	    return this.deliveryCycle;
	}
	
	public void setDeliveryCycle(Integer deliveryCycle){
	    this.deliveryCycle = deliveryCycle;
	}

	public String getPackageSize(){
	    return this.packageSize;
	}
	
	public void setPackageSize(String packageSize){
	    this.packageSize = packageSize;
	}

	public Integer getInstallationFee(){
	    return this.installationFee;
	}
	
	public void setInstallationFee(Integer installationFee){
	    this.installationFee = installationFee;
	}
}
