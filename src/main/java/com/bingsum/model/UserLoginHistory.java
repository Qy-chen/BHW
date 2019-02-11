/**
 * @filename:UserLoginHistory 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.model;

import java.util.Date;
import java.math.BigDecimal;


/**   
 *  
 * @Description:  [暂未用到]用户登录记录
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */

	
public class UserLoginHistory extends BaseEntity {
	
	//
	private Integer userId;
	//
	private Integer isLogin;
	//
	private Integer isLogout;
	//
	private Date createTime;


	public Integer getUserId(){
	    return this.userId;
	}
	
	public void setUserId(Integer userId){
	    this.userId = userId;
	}

	public Integer getIsLogin(){
	    return this.isLogin;
	}
	
	public void setIsLogin(Integer isLogin){
	    this.isLogin = isLogin;
	}

	public Integer getIsLogout(){
	    return this.isLogout;
	}
	
	public void setIsLogout(Integer isLogout){
	    this.isLogout = isLogout;
	}

	public Date getCreateTime(){
	    return this.createTime;
	}
	
	public void setCreateTime(Date createTime){
	    this.createTime = createTime;
	}
}
