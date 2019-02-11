/**
 * @filename:UserOrder 2019-02-11 14:25:12
 * @project bhw  V1.0.0
 * Copyright(c) 2018 Liu,Wenzhao Co. Ltd. 
 * All right reserved. 
 */
package com.bingsum.model;

import java.util.Date;
import java.math.BigDecimal;


/**   
 *  
 * @Description:  用户订单
 * @Author:       Liu,Wenzhao   
 * @CreateDate:   2019-02-11 14:25:12
 * @Version:      V1.0.0
 *    
 */

	
public class UserOrder extends BaseEntity {
	
	//唯一订单号编码
	private String uid;
	//实付金额。精确到2位小数；单位：元
	private String payment;
	//0: 个人账户 1: 企业账户
	private Integer payMethod;
	//支付类型
	private String paymentType;
	//物流费用
	private String deliveryFee;
	//支付状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭
	private Integer status;
	//订单创建时间
	private Date createTime;
	//订单更新时间
	private Date updateTime;
	//付款时间
	private Date paymentTime;
	//发货时间
	private Date consignTime;
	//交易完成时间
	private Date endTime;
	//交易关闭时间
	private Date closeTime;
	//物流名称
	private String shippingName;
	//物流单号
	private String shippingCode;
	//
	private Long userId;
	//买家留言
	private String buyerMessage;
	//买家昵称
	private String buyerNick;
	//1.买家未评论，2.买家已评论
	private Integer buyerRate;
	//订单详情id
	private Long orderDetailId;
	//地址详情
	private String address;
	//发票id
	private Long invoiceId;
	//是否安装：0.安装、1.不安装
	private Integer isInstallation;
	//
	private Long installationId;
	//是否开票：0.未开票，1.已开票
	private Integer makeInvoice;
	//开票状态：0.本次不开具发票、1.待开票、2.已开票
	private Integer makeInvoiceStatus;
	//发票邮寄地址
	private String invoiceEmail;
	//安装费
	private Integer installationFee;
	//配送费
	private Integer distributionFee;
	//B2B 支付id

	private Long payId;


	public String getUid(){
	    return this.uid;
	}
	
	public void setUid(String uid){
	    this.uid = uid;
	}

	public String getPayment(){
	    return this.payment;
	}
	
	public void setPayment(String payment){
	    this.payment = payment;
	}

	public Integer getPayMethod(){
	    return this.payMethod;
	}
	
	public void setPayMethod(Integer payMethod){
	    this.payMethod = payMethod;
	}

	public String getPaymentType(){
	    return this.paymentType;
	}
	
	public void setPaymentType(String paymentType){
	    this.paymentType = paymentType;
	}

	public String getDeliveryFee(){
	    return this.deliveryFee;
	}
	
	public void setDeliveryFee(String deliveryFee){
	    this.deliveryFee = deliveryFee;
	}

	public Integer getStatus(){
	    return this.status;
	}
	
	public void setStatus(Integer status){
	    this.status = status;
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

	public Date getPaymentTime(){
	    return this.paymentTime;
	}
	
	public void setPaymentTime(Date paymentTime){
	    this.paymentTime = paymentTime;
	}

	public Date getConsignTime(){
	    return this.consignTime;
	}
	
	public void setConsignTime(Date consignTime){
	    this.consignTime = consignTime;
	}

	public Date getEndTime(){
	    return this.endTime;
	}
	
	public void setEndTime(Date endTime){
	    this.endTime = endTime;
	}

	public Date getCloseTime(){
	    return this.closeTime;
	}
	
	public void setCloseTime(Date closeTime){
	    this.closeTime = closeTime;
	}

	public String getShippingName(){
	    return this.shippingName;
	}
	
	public void setShippingName(String shippingName){
	    this.shippingName = shippingName;
	}

	public String getShippingCode(){
	    return this.shippingCode;
	}
	
	public void setShippingCode(String shippingCode){
	    this.shippingCode = shippingCode;
	}

	public Long getUserId(){
	    return this.userId;
	}
	
	public void setUserId(Long userId){
	    this.userId = userId;
	}

	public String getBuyerMessage(){
	    return this.buyerMessage;
	}
	
	public void setBuyerMessage(String buyerMessage){
	    this.buyerMessage = buyerMessage;
	}

	public String getBuyerNick(){
	    return this.buyerNick;
	}
	
	public void setBuyerNick(String buyerNick){
	    this.buyerNick = buyerNick;
	}

	public Integer getBuyerRate(){
	    return this.buyerRate;
	}
	
	public void setBuyerRate(Integer buyerRate){
	    this.buyerRate = buyerRate;
	}

	public Long getOrderDetailId(){
	    return this.orderDetailId;
	}
	
	public void setOrderDetailId(Long orderDetailId){
	    this.orderDetailId = orderDetailId;
	}

	public String getAddress(){
	    return this.address;
	}
	
	public void setAddress(String address){
	    this.address = address;
	}

	public Long getInvoiceId(){
	    return this.invoiceId;
	}
	
	public void setInvoiceId(Long invoiceId){
	    this.invoiceId = invoiceId;
	}

	public Integer getIsInstallation(){
	    return this.isInstallation;
	}
	
	public void setIsInstallation(Integer isInstallation){
	    this.isInstallation = isInstallation;
	}

	public Long getInstallationId(){
	    return this.installationId;
	}
	
	public void setInstallationId(Long installationId){
	    this.installationId = installationId;
	}

	public Integer getMakeInvoice(){
	    return this.makeInvoice;
	}
	
	public void setMakeInvoice(Integer makeInvoice){
	    this.makeInvoice = makeInvoice;
	}

	public Integer getMakeInvoiceStatus(){
	    return this.makeInvoiceStatus;
	}
	
	public void setMakeInvoiceStatus(Integer makeInvoiceStatus){
	    this.makeInvoiceStatus = makeInvoiceStatus;
	}

	public String getInvoiceEmail(){
	    return this.invoiceEmail;
	}
	
	public void setInvoiceEmail(String invoiceEmail){
	    this.invoiceEmail = invoiceEmail;
	}

	public Integer getInstallationFee(){
	    return this.installationFee;
	}
	
	public void setInstallationFee(Integer installationFee){
	    this.installationFee = installationFee;
	}

	public Integer getDistributionFee(){
	    return this.distributionFee;
	}
	
	public void setDistributionFee(Integer distributionFee){
	    this.distributionFee = distributionFee;
	}

	public Long getPayId(){
	    return this.payId;
	}
	
	public void setPayId(Long payId){
	    this.payId = payId;
	}
}
