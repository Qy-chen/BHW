/**
 * @filename:InstallationFee 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.model;





/**   
 *  
 * @Description:  [暂未用到] 安装费用
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */

	
public class InstallationFee extends BaseEntity {
	
	//价格计算方式：1.尺寸、2.个数、3.门
	private Integer calculation;
	//
	private Integer productCategoryId;
	//
	private Integer productClassId;
	//
	private Integer price;
	//是否属于常规：0.不属于常规计算、1.常规计算
	private Integer isConvention;
	//参数
	private Integer value;


	public Integer getCalculation(){
	    return this.calculation;
	}
	
	public void setCalculation(Integer calculation){
	    this.calculation = calculation;
	}

	public Integer getProductCategoryId(){
	    return this.productCategoryId;
	}
	
	public void setProductCategoryId(Integer productCategoryId){
	    this.productCategoryId = productCategoryId;
	}

	public Integer getProductClassId(){
	    return this.productClassId;
	}
	
	public void setProductClassId(Integer productClassId){
	    this.productClassId = productClassId;
	}

	public Integer getPrice(){
	    return this.price;
	}
	
	public void setPrice(Integer price){
	    this.price = price;
	}

	public Integer getIsConvention(){
	    return this.isConvention;
	}
	
	public void setIsConvention(Integer isConvention){
	    this.isConvention = isConvention;
	}

	public Integer getValue(){
	    return this.value;
	}
	
	public void setValue(Integer value){
	    this.value = value;
	}
}
