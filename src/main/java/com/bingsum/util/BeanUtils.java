package com.bingsum.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * 扩展org.apache.commons.beanutils.BeanUtils<br>
 * 
 * @author Wesley<br>
 * 
 */
public class BeanUtils extends org.apache.commons.beanutils.BeanUtils {
	
	private static final Set<String> DELETE_TIME_FILEDS_SET = new HashSet<String>();
	
	static {
		DELETE_TIME_FILEDS_SET.add("deletetime");
		DELETE_TIME_FILEDS_SET.add("deletedtime");
		DELETE_TIME_FILEDS_SET.add("deletedat");
		DELETE_TIME_FILEDS_SET.add("deleteat");
	}
	/**
	 * 将源对象中的值覆盖到目标对象中，仅覆盖源对象中不为NULL值的属性
	 * 
	 * @param dest
	 *            目标对象，标准的JavaBean
	 * @param orig
	 *            源对象，可为Map、标准的JavaBean
	 * @throws BusinessException
	 */
	@SuppressWarnings("rawtypes")
	public static void applyIf(Object dest, Object orig) throws Exception {
		try {
			if (orig instanceof Map) {
				Iterator names = ((Map) orig).keySet().iterator();
				while (names.hasNext()) {
					String name = (String) names.next();
					if (PropertyUtils.isWriteable(dest, name)) {
						Object value = ((Map) orig).get(name);
						if (value != null) {
							PropertyUtils.setSimpleProperty(dest, name, value);
						}
					}
				}
			} else {
				java.lang.reflect.Field[] fields = orig.getClass().getDeclaredFields();
				for (int i = 0; i < fields.length; i++) {
					String name = fields[i].getName();
					if (PropertyUtils.isReadable(orig, name) && PropertyUtils.isWriteable(dest, name)) {
						Object value = PropertyUtils.getSimpleProperty(orig, name);
						if (value != null) {
							PropertyUtils.setSimpleProperty(dest, name, value);
						}
					}
				}
			}
		} catch (Exception e) {
			throw new Exception("将源对象中的值覆盖到目标对象中，仅覆盖源对象中不为NULL值的属性", e);
		}
	}

	/**
	 * 将源对象中的值覆盖到目标对象中，仅覆盖源对象中不为NULL值的属性
	 * 
	 * @param orig
	 *            源对象，标准的JavaBean
	 * @param dest
	 *            排除检查的属性，Map
	 * 
	 * @throws BusinessException
	 */
	@SuppressWarnings("rawtypes")
	public static boolean checkObjProperty(Object orig, Map dest) throws Exception {
		try {
			java.lang.reflect.Field[] fields = orig.getClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				String name = fields[i].getName();
				if (!dest.containsKey(name)) {
					if (PropertyUtils.isReadable(orig, name)) {
						Object value = PropertyUtils.getSimpleProperty(orig, name);
						if (value == null) {
							return true;
						}
					}
				}
			}
			return false;
		} catch (Exception e) {
			throw new Exception("将源对象中的值覆盖到目标对象中，仅覆盖源对象中不为NULL值的属性", e);
		}
	}

	@SuppressWarnings({ "rawtypes" })
	public static ParaData convertBean(Object bean)
			throws IntrospectionException, IllegalAccessException, InvocationTargetException {
		Class type = bean.getClass();
		ParaData returnMap = new ParaData();
		BeanInfo beanInfo = Introspector.getBeanInfo(type);

		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (int i = 0; i < propertyDescriptors.length; i++) {
			PropertyDescriptor descriptor = propertyDescriptors[i];
			String propertyName = descriptor.getName();
			if (!propertyName.equals("class")) {
				Method readMethod = descriptor.getReadMethod();
				Object result = readMethod.invoke(bean, new Object[0]);
				if (result != null) {
					returnMap.put(propertyName, result);
				} else {
					returnMap.put(propertyName, "");
				}
			}
		}
		return returnMap;
	}

	@SuppressWarnings({ "rawtypes" })
	public static Object convertMap(Class type, Map map) {
		try {
			Object obj = type.newInstance();// 创建JavaBean对象
			BeanInfo beanInfo = Introspector.getBeanInfo(type);// 获取类属性
			// 给JavaBean对象的属性赋值
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();

				if (map.containsKey(propertyName)) {
					// 下面一句可以try起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
					Object value = map.get(propertyName);

					Object[] args = new Object[1];
					args[0] = value;

					descriptor.getWriteMethod().invoke(obj, args);
				}
			}
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static <T> T convertMap(Class<T> type, ParaData map) {
		try {
			T obj = type.newInstance();// 创建JavaBean对象
			BeanInfo beanInfo = Introspector.getBeanInfo(type);// 获取类属性
			// 给JavaBean对象的属性赋值
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				Class<?> c = descriptor.getPropertyType();
			    String name = null;
			    if(c != null){
			    	name = c.getName();
			    }
				if (map.containsKey(propertyName)) {
					// 下面一句可以try起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
					Object value = null;
					if(name != null && name.toLowerCase().contains("string")){
						value =map.getString(propertyName);
					} else if(name != null && name.toLowerCase().contains("integer")){
						value =map.getInteger(propertyName);
					} else if(name != null && name.toLowerCase().contains("long")){
						value = StrUtil.toLong(map.get(propertyName));
					} else if(name != null && name.toLowerCase().contains("byte")){
						value = StrUtil.toByte(map.get(propertyName));
					}else if(name != null && name.toLowerCase().contains("double")){
						value = StrUtil.toDouble(map.get(propertyName));
					}else if(name != null && name.toLowerCase().contains("float")){
						value = StrUtil.toFloat(map.get(propertyName));
					}else if(name != null && name.toLowerCase().contains("short")){
						value = StrUtil.toShort(map.get(propertyName));
					}else if(name != null && name.toLowerCase().contains("date")){
						value = StrUtil.toDate(map.get(propertyName));
					}else if(name != null && name.toLowerCase().contains("bigdecimal")){
						value = StrUtil.toBigDecimal(map.get(propertyName));
					}else {
						value =map.get(propertyName);
					}
					Object[] args = new Object[1];
					args[0] = value;
					if(value != null){
						descriptor.getWriteMethod().invoke(obj, args);
					}
				}
			}
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static Object loadCreateInfo(Object obj,  Integer uId, Class type) {
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(type);// 获取类属性
			// 给JavaBean对象的属性赋值
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				if(propertyName.toLowerCase().equals("createdat")) {
					descriptor.getWriteMethod().invoke(obj, new Date());
				} else if(propertyName.toLowerCase().equals("creator")) {
					descriptor.getWriteMethod().invoke(obj, uId);
				}
			}
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @Title: objDeleteTimeField 
	 * @Description: 返回逻辑删除时间字段
	 * @date 2019年1月20日 上午9:25:55
	 * @author Liu,Wenzhao [wenzhao.liu@foxmail.com]
	 * @param obj
	 * @param type
	 * @return  String
	 */
	public static String objDeleteTimeField(Class type) {
		
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(type);// 获取类属性
			// 给JavaBean对象的属性赋值
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				String lPropertyName = propertyName.toLowerCase();
				if(DELETE_TIME_FILEDS_SET.contains(lPropertyName)) {
					return propertyName;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static Object loadDeleteTime(Object obj,  Class type) {
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(type);// 获取类属性
			// 给JavaBean对象的属性赋值
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				if(propertyName.toLowerCase().equals("deleteat")
						|| propertyName.toLowerCase().equals("deletedat")
						|| propertyName.toLowerCase().equals("deletetime")
						|| propertyName.toLowerCase().equals("deletedtime")
						) {
					descriptor.getWriteMethod().invoke(obj, new Date());
				}
			}
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Object loadUpdateInfo(Object obj,  Integer uId, Class type) {
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(type);// 获取类属性
			// 给JavaBean对象的属性赋值
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				if(propertyName.toLowerCase().equals("modifiedat")) {
					descriptor.getWriteMethod().invoke(obj, new Date());
				} else if(propertyName.toLowerCase().equals("modifier")) {
					descriptor.getWriteMethod().invoke(obj, uId);
				}
			}
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static Object loadCreateInfo(Object obj, Long userId, Class type) {
		return loadCreateInfo(obj,   userId.intValue(), type);
	}
	
	public static Object loadUpdateInfo(Object obj,  Long userId, Class type) {
		return loadUpdateInfo(  obj,   userId.intValue(), type);
	}
	
	public static Object loadCreateInfo(Object obj,  Class type, Integer uId) {
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(type);// 获取类属性
			// 给JavaBean对象的属性赋值
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				if(propertyName.toLowerCase().equals("createtime")) {
					descriptor.getWriteMethod().invoke(obj, new Date());
				}
				else if(propertyName.toLowerCase().equals("createby")) {
					descriptor.getWriteMethod().invoke(obj,  uId);
				}
			}
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Object loadUpdateInfo(Object obj,  Class type, Integer uId) {
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(type);// 获取类属性
			// 给JavaBean对象的属性赋值
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				if(propertyName.toLowerCase().equals("updatetime")) {
					descriptor.getWriteMethod().invoke(obj, new Date());
				} 
				else if(propertyName.toLowerCase().equals("updateby")) {
					descriptor.getWriteMethod().invoke(obj, uId);
				}
			}
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Object loadDeleteInfo(Object obj, Class type) {
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(type);// 获取类属性
			// 给JavaBean对象的属性赋值
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				if(propertyName.toLowerCase().equals("deletetime")) {
					descriptor.getWriteMethod().invoke(obj, new Date());
				}
			}
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}