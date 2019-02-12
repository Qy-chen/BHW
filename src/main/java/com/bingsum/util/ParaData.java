package com.bingsum.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.bingsum.model.Staff;


@SuppressWarnings("rawtypes")
public class ParaData extends HashMap implements Map {

	private static final long serialVersionUID = 1L;

	Map map = null;

	@SuppressWarnings("unchecked")
	public ParaData(Map<String, Object> map2) {
		Map properties = map2;
		Map returnMap = new HashMap();
		Iterator entries = properties.entrySet().iterator();
		Map.Entry entry;
		String name = "";
		String value = "";
		while (entries.hasNext()) {
			entry = (Map.Entry) entries.next();
			name = (String) entry.getKey();
			Object valueObj = entry.getValue();
			if (null == valueObj) {
				value = "";
			} else if (valueObj instanceof String[]) {
				String[] values = (String[]) valueObj;
				for (int i = 0; i < values.length; i++) {
					value = values[i] + ",";
				}
				value = value.substring(0, value.length() - 1);
			} else {
				value = valueObj.toString();
			}
			returnMap.put(name, value);
		}
		map = returnMap;
	}

	public ParaData() {
		map = new HashMap();
	}

	@Override
	public Object get(Object key) {
		Object obj = null;
		if (map.get(key) instanceof Object[]) {
			Object[] arr = (Object[]) map.get(key);
			obj = arr;//request == null ? arr : (request.getParameter((String) key) == null ? arr : arr[0]);
		} else {
			obj = map.get(key);
		}
		return obj;
	}
	
	public BigDecimal getBigDecimal(Object key){
		return StrUtil.toBigDecimal(get(key));
	}
	
	public String getString(Object key) {
		Object o = get(key);
		return StrUtil.toString(o);
	}
	
	public Integer getInteger(Object key){
		return StrUtil.toInteger(get(key));
	}
	
	public Integer getInteger(Object key, Integer nullValue){
		Integer res = StrUtil.toInteger(get(key));
		return res == null ? nullValue : res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object put(Object key, Object value) {
		return map.put(key, value);
	}

	@Override
	public Object remove(Object key) {
		return map.remove(key);
	}

	public void clear() {
		map.clear();
	}

	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return map.containsKey(key);
	}

	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return map.containsValue(value);
	}

	public Set entrySet() {
		// TODO Auto-generated method stub
		return map.entrySet();
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return map.isEmpty();
	}

	public Set keySet() {
		// TODO Auto-generated method stub
		return map.keySet();
	}

	@SuppressWarnings("unchecked")
	public void putAll(Map t) {
		// TODO Auto-generated method stub
		map.putAll(t);
	}

	public int size() {
		// TODO Auto-generated method stub
		return map.size();
	}

	public Collection values() {
		// TODO Auto-generated method stub
		return map.values();
	}
	
	public  boolean hasBlankParamErr(String ... paramNames){
		for(String s : paramNames){
			if (StringUtils.isBlank(StrUtil.toString(this.get(s)))){
				return true;
			}
		}
		return false;
	}
	
	public  String blankParamErr(String ... paramNames){
		for(String s : paramNames){
			if (StringUtils.isBlank(StrUtil.toString(this.get(s)))){
				return s +"不能为空";
			}
		}
		return null;
	}
	
	public static ParaData getInstance(){
	    ParaData pd = new ParaData();
	    return pd;
	}
	
	public ParaData afterPut(Object key, Object value){
	    this.put(key, value);
	    return this;
	}
	
	/**
	 * 
	 * @Title: PutNotNull 
	 * @Description: 只存放非空值
	 * @date 2018年9月12日 下午2:11:02
	 * @author Liu,Wenzhao [wenzhao.liu@foxmail.com]
	 * @param key
	 * @param value
	 * @return  PageData
	 */
	public ParaData PutNotNull(Object key, Object value){
		if(key == null || value == null) {
			return this;
		}
	    this.put(key, value);
	    return this;
	}
	
	
	public <T> T toBean(Class<T> cls) {
		T bean = BeanUtils.convertMap(cls, this);
		return bean;
	}
	
	public <T> T toAddBean(Class<T> cls) {
		T bean = BeanUtils.convertMap(cls, this);
		BeanUtils.loadCreateInfo(bean, cls);
		return bean;
	}
	
	public <T> T toUpdateBean(Class<T> cls) {
		T bean = BeanUtils.convertMap(cls, this);
		BeanUtils.loadUpdateInfo(bean, cls);
		return bean;
	}
	
	public <T> T toDeleteBean(Class<T> cls) {
		T bean = BeanUtils.convertMap(cls, this);
		BeanUtils.loadDeleteInfo(bean, cls);
		return bean;
	}
	
	public String showStr() {
		return JsonBeanSwaps.toJson(this);
	}
	
	/**
	 * 
	 * @Title: formatDate 
	 * @Description: 所有时间类型统一处理某格式
	 * @date 2019年1月21日 下午4:13:15
	 * @author Liu,Wenzhao [wenzhao.liu@foxmail.com]
	 * @param datePatter  void
	 */
	public void formatDate(String datePatter) {
		Set<String> keySet = this.keySet();
		if(keySet == null || keySet.isEmpty()) {
			return;
		}
		for(String key : keySet) {
			Object value = this.get(key);
			if(value instanceof Date) {
				this.put(key, DateHelper.dateToString((Date)value, datePatter));
			}
		}
	}
	/**
	 * 
	 * @Title: toHump 
	 * @Description: 转驼峰形式
	 * @date 2019年1月21日 下午4:08:54
	 * @author Liu,Wenzhao [wenzhao.liu@foxmail.com]  void
	 */
	public void toHump() {
		Set<String> keySet = this.keySet();
		if(keySet == null || keySet.isEmpty()) {
			return;
		}
		Set<String> delSet = new HashSet<String>();
		ParaData add = ParaData.getInstance();
		for(String key : keySet) {
			Object value = this.get(key);
			String humpName = StrUtil.lineToHump(key);
			if(humpName.equals(key)) {
				add.put(key, value);
				continue;
			}
			add.put(StrUtil.lineToHump(key), value);
			delSet.add(key);
		}
		if(!delSet.isEmpty()) {
			for(String key :delSet) {
				this.remove(key);
			}
		}
		this.putAll(add);
	}
	
	public Staff getLoginStaff() {
		Staff s = (Staff) this.get("loginStaff");
		return s;
	}
	
	public String getToken() {
		return this.getString("token");
	}
}
