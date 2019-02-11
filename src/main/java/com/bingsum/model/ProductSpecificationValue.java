/**
 * @filename:ProductSpecificationValue 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.model;

import java.util.Date;
import java.math.BigDecimal;


/**   
 *  
 * @Description:  产品规格参数
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */

	
public class ProductSpecificationValue extends BaseEntity {
	
	//规格名id
	private Integer productSpecificationId;
	//参数
	private String name;
	//该参数绑定的产品图片
	private String imageUrl;
	//产品ID
	private Integer productId;


	public Integer getProductSpecificationId(){
	    return this.productSpecificationId;
	}
	
	public void setProductSpecificationId(Integer productSpecificationId){
	    this.productSpecificationId = productSpecificationId;
	}

	public String getName(){
	    return this.name;
	}
	
	public void setName(String name){
	    this.name = name;
	}

	public String getImageUrl(){
	    return this.imageUrl;
	}
	
	public void setImageUrl(String imageUrl){
	    this.imageUrl = imageUrl;
	}

	public Integer getProductId(){
	    return this.productId;
	}
	
	public void setProductId(Integer productId){
	    this.productId = productId;
	}
}
