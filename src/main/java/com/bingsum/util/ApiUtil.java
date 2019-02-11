package com.bingsum.util;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.util.JSONPObject;

public class ApiUtil {

	private static final Logger logger = LoggerFactory.getLogger(ApiUtil.class);

	/**
	 * 设置分页的参数
	 * 
	 * @param pd
	 * @return
	 */
	public static ParaData setPageParam(ParaData pd) {
		String page_now_str = pd.get("page_now").toString();
		int pageNowInt = Integer.parseInt(page_now_str) - 1;
		String page_size_str = pd.get("page_size").toString(); // 每页显示记录数
		int pageSizeInt = Integer.parseInt(page_size_str);

		String page_now = pageNowInt + "";
		String page_start = (pageNowInt * pageSizeInt) + "";

		pd.put("page_now", page_now);
		pd.put("page_start", page_start);

		return pd;
	}

	// /**
	// * 设置list中的distance
	// */
	// public static List<PageData> setListDistance(List<PageData> list,
	// PageData pd){
	// List<PageData> listReturn = new ArrayList<PageData>();
	// String user_longitude = "";
	// String user_latitude = "";
	//
	// try{
	// user_longitude = pd.get("user_longitude").toString(); //"117.11811";
	// user_latitude = pd.get("user_latitude").toString(); //"36.68484";
	// } catch(Exception e){
	// logger.error("缺失参数--user_longitude和user_longitude");
	// logger.error("lost param：user_longitude and user_longitude");
	// }
	//
	// PageData pdTemp = new PageData();
	// int size = list.size();
	// for(int i=0;i<size;i++){
	// pdTemp = list.get(i);
	// String longitude = pdTemp.get("longitude").toString();
	// String latitude = pdTemp.get("latitude").toString();
	// String distance = MapDistance.getDistance(
	// user_longitude, user_latitude,
	// longitude, latitude
	// );
	// pdTemp.put("distance", distance);
	// pdTemp.put("size", distance.length());
	// listReturn.add(pdTemp);
	// }
	//
	// return listReturn;
	// }

	public static Object returnOK(ParaData pd, Object object) {
		if(object != null && object instanceof Page) {
			object = ((Page)object).toPageRes();
		}
		if(object != null && object instanceof ParaData) {
			((ParaData)object).toHump();
		}
		InterfaceUtil util = new InterfaceUtil();
		object = util.success(object);
		if (pd.containsKey("callback")) {
			String callback = pd.get("callback").toString();
			return new JSONPObject(callback, object);
		} else {
			return object;
		}
	}
	
	public static Object returnOK() {
		InterfaceUtil util = new InterfaceUtil();
		Object object = util.success();
		return object;
	}

	/**
	 * 显示特定的错误提示，错误编码9999
	 * 
	 * @param pd
	 * @param errorCodeMessage
	 * @return
	 */
	public static Object returnDescFail(ParaData pd, String errorCodeMessage) {
		InterfaceUtil util = new InterfaceUtil();
		util.setCode(BusiData.COMMON_EXCEPTION);
		util.setDesc(errorCodeMessage);
		Object object = ApiUtil.returnObject(pd, util);
		logger.error(JsonBeanSwaps.toJson(object));
		return object;
	}

	/**
	 * 显示特定的错误，根据指定的错误编码，获取指定的错误描述，需要在BusiData里面配置
	 * 
	 * @param pd
	 * @param errorCode
	 * @return
	 */
	public static Object returnFail(ParaData pd, String errorCode) {
		InterfaceUtil util = new InterfaceUtil();
		util.setCode(errorCode);
		Object object = ApiUtil.returnObject(pd, util);
		logger.error(JsonBeanSwaps.toJson(object));
		return object;
	}

	public static Object returnObject(ParaData pd, Object object) {
		if(object instanceof com.github.pagehelper.Page) {
			try {
				object = BeanUtils.convertBean(object);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (pd.containsKey("callback")) {
			String callback = pd.get("callback").toString();
			return new JSONPObject(callback, object);
		} else {
			return object;
		}
	}
}
