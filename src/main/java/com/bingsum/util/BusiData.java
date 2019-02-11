package com.bingsum.util;

import java.util.HashMap;
import java.util.Map;

public class BusiData {

	public final static String P_KEY = "#^%&(())&3136431";

	public static final String COMMON_PARAMS_ERROR = "1000";

	public static final String ACCOUNT_TYPE_PERSONAL = "01";

	public static final String ACCOUNT_TYPE_COMPANY = "02";
	
	
	public static final String ROLE_OF_JINJIREN = "AAAAAAAAAA";
	
	public static final String ROLE_OF_CHANGKONG = "BBBBBBBBBB";
	
	public static final String ROLE_OF_LEADER= "CCCCCCCCCC";
	
	public static final String HA_SCHEDULE_NODE_NAME = "1000";
	
	public final static Map<String, String> RoleMap = new HashMap<String, String>();

	static {
		RoleMap.put("2", ROLE_OF_JINJIREN);
//		RoleMap.put("4", ROLE_OF_CHANGKONG);
	}

	/**
	 * 查询账户
	 */
	public static final String ACCOUNT_TYPE_B = "B0001";
	public static final String COMMON_STATUS_SUCCESS = "0000";
	
	public static final String COMMON_STATUS_SUCCESS_APP = "0000";
	public static final String COMMON_STATUS_EXSITS = "0001";
	public static final String COMMON_STATUS_MOBILE_ERROR = "0002";
	public static final String COMMON_STATUS_SMS_ERROR = "0003";
	public static final String COMMON_STATUS_NO_EXSITS = "0004";
	public static final String COMMON_STATUS_BASE_IN_ATTENTION = "0005";
	public static final String COMMON_STATUS_COMPANY_IN_ATTENTION = "0006";
	public static final String COMMON_STATUS_IN_ATTENTION = "0007";
	public static final String COMMON_STATUS_PWD_ERROR = "0008";
	public static final String COMMON_STATUS_PWD_EMPTY = "0108";
	public static final String COMMON_STATUS_ROLE_TYPE_ERROR = "0009";
	public static final String COMMON_STATUS_CUST_NOT_COMPANY = "0010";

	public static final String COMMON_STATUS_UN_PASS_BASE = "0050";
	public static final String COMMON_STATUS_UN_PASS_DRIVER = "0051";
	public static final String COMMON_STATUS_UN_PASS_SERVICE = "0052";
	public static final String COMMON_STATUS_UN_PASS_DRIVING = "0053";
	public static final String COMMON_STATUS_UN_USER_NAME = "0054";
	public static final String COMMON_STATUS_DELETE_FOR_US ="0055";
	public static final String COMMON_EXCEPTION = "9999";
	
	/**
     * 参数不完整
     */
    public static final String  PARAMETER__NOT_COMPLETE = "0011";
    /**
     * 手机号码不存在
     */
    public static final String USER_NOT_FOUND = "0012";
    /**
     * 账户信息不存在
     */
    public static final String IS_NOT_ACCOUNT = "0013";
    /**
     * 该手机号已被注册
     */
    public static final String IS_USER = "0014";
    /**
     * 用户信息不存在
     */
    public static final String IS_NOT_USER = "0015";
    /**
     * 验证码错误
     */
    public static final String  CAPTCHA__NOT_EXIST = "0016";
    /**
     * 通用失败
     */
    public static final String FAIL = "0017";
    /**
     * 帐号或密码错误
     */
    public static final String USER_NOT_INFO = "0018";
    /**
     * 用户已经被禁用
     */
    public static final String LOCK_USER = "0019";
    /**
     * 找不到
     */
    public static final String NOT_FOUND = "0020";
    /**
     * 用户会话失效
     */
    public static final String USER_SESS_EXPIRED = "0021";
    
    /**
     * 该账号在其他手机登录
     */
    public static final String USER_ACCOUNT_LOGINED = "0022";
    /**
     * 已经存在
     */
    public static final String HAVE_EXSIT = "0023";
    
    /**
     * 已经获取验证码
     */
    public static final String Have_send_mes = "0024";
    /**
     * 您今天发送该类型的短信次数已达上限
     */
    public static final String Have_send_mes_over = "0025";
    /**
     * 已拉黑该用户
     */
    public static final String HAVE_BLACK_USER = "0026";
    /**
     * 用户签到已存在
     */
    public static final String HAVE_SIGN_EXSIT = "0027";
    /**
     * 不能使用全英文
     */
    public static final String HAVE_REGEX_NOT_EXSIT = "0028";
    /**
     * 手机格式不正确
     */
    public static final String PHONE_REGEX_NOT_EXSIT = "0029";
    /**
     * 请不要关注自己
     */
    public static final String FOLLOW_BY_NOT_USER = "0030";
    /**
     * 不要取关自己
     */
    public static final String DEL_FOLLOW_BY_NOT_USER = "0031";
    /**
     * 请不要拉黑自己
     */
    public static final String BLACK_BY_NOT_USER = "0032";
    /**
     * 取消拉黑自己
     */
    public static final String DEL_BLACK_BY_NOT_USER = "0033";
    /**
     * 相同昵称已存在
     */
    public static final String HAVE_NICK_NAME_EXSIT = "0034";
 
    /**
     * 相同用户名已存在
     */
    public static final String HAVE_USER_NAME_EXSIT = "0035";
    
    public static final String PARTY_NOT_EXIST = "0037";
    
    public static final String PARTY_NOT_BEN_REN = "0038";
    
    public static final String PARTY_QUN_NOT_EXIT = "0039";
    
    public static final String PARTY_EXIST_IN = "0040";
    
    public static final String PARTY_APPLY_EXIST = "0041";
    
    public static final String DO_NOT_CHECK_BANK_CARD = "0042";
    
    public static final String CARD_NOT_EXIST = "0043";
    
    public static final String GOLD_NOT_EMPTY = "0044";
    
    public static final String GOLD_IS_INTEGER = "0045";
    
    public static final String PACKAGE_NOT_EXIST = "0046";
    
    public static final String COLLECT_EXIST = "0047";
    
    public static final String COMMENT_EXIST = "0048";
    
    public static final String VIEW_NOT_EXIST = "0049";
    
    public static final String HUAN_IS_BUSY = "0050";
    
    public static final String NOTICE_NOT_EXIT = "0051";
    
    public static final String GUIDE_NOT_EXIST = "0052";
    
    public static final String COLLECT_NOT_EXIST = "0053";
    
    public static final String FRIEND_IS_EXIST = "0054";
    
    public static final String ACTUAL_NUMBER_ERROR = "0055";
    
    public static final String MAIN_SUB_BUS_ORDER_NOT_EXIST = "0056";
    
    public static final String ACTIVTY_NOT_EXIST = "0057";
    
    public static final String GUIDE_HAS_ORDER = "0058";
    
    
    public static final String Data_NOT_FOUD = "0258";

	public final static Map<String, String> commonStatusMap = new HashMap<String, String>();

	static {
		commonStatusMap.put(COMMON_STATUS_SUCCESS, "一切正常");
		commonStatusMap.put(COMMON_STATUS_DELETE_FOR_US, "只能删除自己的");
		commonStatusMap.put(COMMON_STATUS_EXSITS, "账号已经存在");
		commonStatusMap.put(COMMON_STATUS_MOBILE_ERROR, "手机号码异常");
		commonStatusMap.put(COMMON_STATUS_SMS_ERROR, "短信号码验证异常");
		commonStatusMap.put(COMMON_STATUS_NO_EXSITS, "账号不存在");
		commonStatusMap.put(PARAMETER__NOT_COMPLETE, "参数不完整");
		commonStatusMap.put(USER_NOT_FOUND, "手机号码不存在");
		commonStatusMap.put(IS_NOT_USER, "账户信息不存在");
		commonStatusMap.put(Have_send_mes, "已经获取验证码");
	    commonStatusMap.put(HAVE_EXSIT, "账号信息已绑定");
	    commonStatusMap.put(USER_ACCOUNT_LOGINED, "该账号在其他手机登录");
	    commonStatusMap.put(USER_SESS_EXPIRED, "用户会话失效");
	    commonStatusMap.put(CAPTCHA__NOT_EXIST, "验证码错误");
		commonStatusMap.put(FAIL, "通用失败");
		commonStatusMap.put(USER_NOT_INFO, "帐号或密码错误");
		commonStatusMap.put(LOCK_USER, "用户已经被禁用");
		commonStatusMap.put(NOT_FOUND, "找不到");
		commonStatusMap.put(Have_send_mes_over, "您今天发送该类型的短信次数已达上限");
		commonStatusMap.put(IS_USER, "该手机号已被注册");
		commonStatusMap.put(HAVE_BLACK_USER, "已被拉黑");
		commonStatusMap.put(HAVE_SIGN_EXSIT, "已签到");
		commonStatusMap.put(HAVE_REGEX_NOT_EXSIT, "请不要使用使用全英文");
		commonStatusMap.put(PHONE_REGEX_NOT_EXSIT, "手机号码格式不正确");
		commonStatusMap.put(FOLLOW_BY_NOT_USER, "请不要关注自己");
		commonStatusMap.put(DEL_FOLLOW_BY_NOT_USER, "无法取消关注自己");
		commonStatusMap.put(BLACK_BY_NOT_USER, "请不要拉黑自己");
		commonStatusMap.put(DEL_BLACK_BY_NOT_USER, "无法取消拉黑自己");
		commonStatusMap.put(HAVE_NICK_NAME_EXSIT, "相同昵称已存在");
		commonStatusMap.put(PARTY_NOT_EXIST, "派对不存在");
		commonStatusMap.put(PARTY_NOT_BEN_REN, "不是群主不能修改派对信息"); 
		commonStatusMap.put(PARTY_QUN_NOT_EXIT, "群主不能退群");  
		commonStatusMap.put(PARTY_EXIST_IN, "您已经加入该群，请不要反复申请");  
		commonStatusMap.put(PARTY_APPLY_EXIST, "您已经申请加入该群，请等待群主同意");  
		commonStatusMap.put(DO_NOT_CHECK_BANK_CARD, "请选择提现的银行卡号或支付宝账号");  
		commonStatusMap.put(CARD_NOT_EXIST, "银行卡或支付宝账号不存在");  
		commonStatusMap.put(GOLD_NOT_EMPTY, "提现金额不能为空");  
		commonStatusMap.put(GOLD_IS_INTEGER, "提现金额只能正整数");
		commonStatusMap.put(PACKAGE_NOT_EXIST, "套餐不存在或已下线");
		commonStatusMap.put(COLLECT_EXIST, "已收藏该产品，请不要重复点击");
		commonStatusMap.put(COMMENT_EXIST, "已评论该订单");
		commonStatusMap.put(VIEW_NOT_EXIST, "景点不存在或已下线");
		commonStatusMap.put(GUIDE_NOT_EXIST, "导游不存在");
		commonStatusMap.put(HUAN_IS_BUSY, "服务器正忙，请稍后再试");
		commonStatusMap.put(NOTICE_NOT_EXIT, "群公告不存在");
		commonStatusMap.put(COLLECT_NOT_EXIST, "已取消收藏");
		commonStatusMap.put(FRIEND_IS_EXIST, "已经是好友");
		commonStatusMap.put(ACTUAL_NUMBER_ERROR, "参与人数异常");
		commonStatusMap.put(ACTIVTY_NOT_EXIST, "活动已下架或不存在");
		commonStatusMap.put(MAIN_SUB_BUS_ORDER_NOT_EXIST, "未找到补单信息，请联系管理员");
		commonStatusMap.put(GUIDE_HAS_ORDER, "导游已接单");
		commonStatusMap.put(HAVE_USER_NAME_EXSIT, "相同用户名已存在");
		commonStatusMap.put(Data_NOT_FOUD, "没有查到对应数据");
	}
	
	/**
	 * 消息渠道
	 */
	public static final String MESSAGE_CHANNEL_NOTICE = "notice"; // 全体通知
	
	
	public static final String ACCOUNT_TYPE_AMOUNT ="000001";
	public static final String ACCOUNT_TYPE_BEAN ="000002";
	public static final String ACCOUNT_TYPE_SHARE ="000004";
	
	
	public static final String MEMBER_TYPE_AGENT="2";
	
	/***
	 * 芝麻认证
	 */
    /**
     * 已经达到芝麻认证每天最大次数
     */
    public static final String Max_ZHIMA_DAY= "0000739";
    
    /**
     * 身份证已进行芝麻认证
     */
    public static final String ID_CARD_EXIST = "0000740";
    
    /**
     * 实名认证失败
     */
    public static final String Real_Name_Validate_Fail = "0000712";
    
    
    
    public final static Map<String, String> zhiMaStatusMap = new HashMap<String, String>();

	static {
		commonStatusMap.put(Max_ZHIMA_DAY, "您已达到最大芝麻认证次数，请明日再试");
		commonStatusMap.put(ID_CARD_EXIST, "实名认证失败，您提交的身份证已认证通过，请不要重复已提交");
		commonStatusMap.put(Real_Name_Validate_Fail, "芝麻实名认证初始化失败");
	}
	
	/**
	 * 直播间错误代码
	 */
	/**
     * 直播已结束
     */
    public static final String NO_ROOM = "0000707";
    
    /**
     * 主播踢观众出主播间状态，禁止进直播间
     */
    public static final String OUT_LIVE = "0000709";
    
    /**
     * 直播密码错误
     */
    public static final String PASSWORD_ERROR = "0000708";
    
    
    /**
     * 发红包失败,金币不足
     */
    public static final String Send_Red_FAILE = "0000716";
    
    /**
     * 未通过主播认证
     */
    public static final String ANCHOR_OUT_OF_SERVICE = "0000713";
    
    /**
     * 礼物不存在
     */
    public static final String GIFT_NOT_EXIST = "0000714";
    
    
    /**
     * 无权限领红包
     */
    public static final String HAS_NOT_POWER_RED = "0000799";
    
    /**
     * 直播间不存在
     * **/
    public static final String ROOM_OUT_OF_SERVICE = "0000715";
    public static final String ANCOR_IN_SHENHE = "0000726";
    
    
    public final static Map<String, String> liveRoomMap = new HashMap<String, String>();

	static {
		commonStatusMap.put(NO_ROOM, "直播已结束");
		commonStatusMap.put(OUT_LIVE, "禁止进直播间");
		commonStatusMap.put(Send_Red_FAILE, "发送红包失败，豆子不足");
		commonStatusMap.put(ANCHOR_OUT_OF_SERVICE, "未通过主播认证，请先通过主播认证");
		commonStatusMap.put(GIFT_NOT_EXIST, "礼物不存在");
		commonStatusMap.put(ROOM_OUT_OF_SERVICE, "直播间不存在");
		commonStatusMap.put(ANCOR_IN_SHENHE, "您已通过认证或正在审核中");
		commonStatusMap.put(HAS_NOT_POWER_RED, "您没有权限抢红包");
		commonStatusMap.put(PASSWORD_ERROR, "密码错误");
	}
	
	/**
	 * 订单模块
	 */
	
	/**
     * 支付失败,金币不足
     */
    public static final String Order_SONG_FAILE = "0000711";
    
    /**
     * 提现失败,金币不足
     */
    public static final String NO__ENOUGH_GOLD = "0000812";
    
    
    /**
     * 提现最大值
     */
    public static final String TOO_MUCH_GOLD = "0000722";
    
    
    /**
     * 提现最大值
     */
    public static final String WITHDRAW_OUT_OF_SERVICE = "0000723";
    
    /**
     * 提现失败,金币不足
     */
    public static final String NO__GOLD = "0000814";
    
    /**
     * 输入充值金额和购买指定商品不能同时存在
     */
    public static final String PRICE_AND_ID_EXIST = "0000815";
    
    
    
    /**
     * 苹果一天只能充值一笔
     */
    public static final String Have_get_IOS_order = "0000816";
    
    /**
     * 支付失败
     */
    public static final String Order_FAILE = "0000700";
    
    public final static Map<String, String> orderMap = new HashMap<String, String>();

	static {
		commonStatusMap.put(NO__ENOUGH_GOLD, "提现失败,金币不足");
		commonStatusMap.put(TOO_MUCH_GOLD, "提现已达到最大值20W");
		commonStatusMap.put(WITHDRAW_OUT_OF_SERVICE, "提现申请时间为10:00-15:00，周六、周日等节假日不受理提现");
		commonStatusMap.put(NO__GOLD, "提现失败,金币不足");
		commonStatusMap.put(PRICE_AND_ID_EXIST, "输入充值金额和购买指定商品不能同时存在");
		commonStatusMap.put(Have_get_IOS_order, "苹果一天只能充值一笔");
		commonStatusMap.put(Order_FAILE, "支付失败");
	}

	
	//图片涉黄
    public static final String IMG_IS_YELLOW = "500741"; 
    
    //直播间涉黄
    public static final String LIVE_IS_YELLOW = "500742";
    
    //景点容纳达上限
    public static final String ORDER_VIEWSPOT_OVERLOAD = "1000001";
    //套餐订单人数达上限
    public static final String ORDER_PACKAGE_ORDER_OVERLOAD = "1000002";
  //优惠券无效
    public static final String ORDER_INVALID_COUPON = "1000003";
  //订单金额不正确
    public static final String ORDER_INVALID_TOTAL = "1000004";
    //订单出发时间为空
    public static final String ORDER_BLANK_START_TIME = "1000005";
  //订单不存在
    public static final String ORDER_NOT_EXIST = "1000006";
    //订单状态不匹配
    public static final String ORDER_STATUS_ERR = "1000007";
    //订单状态不匹配
    public static final String ORDER_PAY_ERR = "1000008";
  //租车单所在城市无客运公司不能下单
    public static final String ORDER_TRANSPORTCORPORATION_ERR = "1000009";
  //租车单所在城市无客运公司不能下单
    public static final String ORDER_INVALID_CITY = "1000010";
  //按天收费价格未维护
    public static final String ORDER_INVALID_BUS_PRICE = "1000011";
  //租车单所在城市无客运公司不能下单
    public static final String ORDER_MIN_NUMBER = "1000012";
  //订单出发时间为空要大于3小时
    public static final String ORDER_INVALID_START_TIME = "1000013";
  //订单状态不匹配
    public static final String ORDER_CANNOT_PAY = "1000014";
  //订单商家拒绝接单
    public static final String ORDER_REJECT_ERR = "1000015";
  //订单商家已截单
    public static final String ORDER_STOP_ERR = "1000016";
  //下单导游订单没有有效的套餐或租车单
    public static final String ORDER_GUIDE_PRE_ORDERS_ERR = "1000017";
  //景点容纳达上限
    public static final String ORDER_GUIDE_OVERLOAD = "1000018";
    //出发时间不能小于当前时间
    public static final String ORDER_PACKAGE_START_TIME = "1000019";
    //里程价格未维护
    public static final String ORDER_INVALID_BUS_PRICE_UNIT = "1000020";
    //超过开始时间不能申请退款
    public static final String ORDER_REFUND_TIME_ERR = "1000021";
    
    static{
    	commonStatusMap.put(ORDER_VIEWSPOT_OVERLOAD, "超出景点容纳人数");
		commonStatusMap.put(ORDER_PACKAGE_ORDER_OVERLOAD, "超出套餐订单限制人数");
		commonStatusMap.put(ORDER_INVALID_COUPON, "无效的优惠券");
		commonStatusMap.put(ORDER_INVALID_TOTAL, "订单总金额不正确");
        commonStatusMap.put(ORDER_BLANK_START_TIME, "出发时间不能为空");
        commonStatusMap.put(ORDER_NOT_EXIST, "订单不存在");
        commonStatusMap.put(ORDER_STATUS_ERR, "订单已被结单");
        commonStatusMap.put(ORDER_PAY_ERR, "获取支付信息失败");
        commonStatusMap.put(ORDER_TRANSPORTCORPORATION_ERR, "当前城市无客运公司");
        commonStatusMap.put(ORDER_INVALID_CITY, "无效的城市信息");
        commonStatusMap.put(ORDER_INVALID_BUS_PRICE, "对应租车价格未维护");
        commonStatusMap.put(ORDER_INVALID_BUS_PRICE_UNIT, "租车里程价格未维护");
        commonStatusMap.put(ORDER_MIN_NUMBER, "未达到最小成单人数");
        commonStatusMap.put(ORDER_INVALID_START_TIME, "出发时间要距现在三小时以上");
        commonStatusMap.put(ORDER_CANNOT_PAY, "超出订单出发时间，无法支付");
        commonStatusMap.put(ORDER_REJECT_ERR, "当前订单商家拒绝接单");
        commonStatusMap.put(ORDER_STOP_ERR, "当前订单商家已截单");
    //    commonStatusMap.put(ORDER_GUIDE_PRE_ORDERS_ERR, "当前没有已支付待消费的派对订单");
        commonStatusMap.put(ORDER_GUIDE_OVERLOAD, "当前导游订单人数已满");
        commonStatusMap.put(ORDER_PACKAGE_START_TIME, "出发时间不能小于当前时间");
        commonStatusMap.put(ORDER_REFUND_TIME_ERR, "超过开始时间不能申请退款");
    }
}
