package com.bingsum.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * String 工具类
 * @author liuwenzhao
 *
 */
public class StrUtil {
	/**
	 * 连接多个对象为字符串
	 * @param objects
	 * @return
	 */
	public static String concat(Object ... objects){
		StringBuilder sb = new StringBuilder();
		for(Object obj : objects){
			if(obj != null)
			    sb.append(obj);
		}
		return sb.toString();
	}
	
	public static String concatMultLine(Object ... objects){
        StringBuilder sb = new StringBuilder();
        for(Object obj : objects){
            if(obj != null)
                sb.append(obj).append("\n");
        }
        return sb.toString();
    }
	
	public static StringBuilder concatSb(Object ... objects){
        StringBuilder sb = new StringBuilder();
        for(Object obj : objects){
            if(obj != null)
                sb.append(obj);
        }
        return sb;
    }
	/**
	 * 返回随机数 字符串
	 * @param len
	 * @return
	 */
	public static String randomStr(int len){
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i < len; i++){
			sb.append(random.nextInt(10));
		}
		return sb.toString();
	}

	/**
	 * 判断是否是数字
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str){
		try{
			Integer.parseInt(str);
			return true;
		} catch(Exception e){
			return false;
		}
	}

	private static Pattern linePattern = Pattern.compile("_(\\w)");
    /**下划线转驼峰*/
    public static String lineToHump(String str){
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
    
	private static Pattern humpPattern = Pattern.compile("[A-Z]");
	/**驼峰转下划线,效率比上面高*/
    public static String humpToLine(String str){
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(sb, "_"+matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
	
	/**
	 * 驼峰转下划线
	 * @param str
	 * @return
	 */
	public static String toSqlName(String str){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length(); i++) {
		   char c = str.charAt(i);
		   if (Character.isUpperCase(c)){
		      sb.append('_').append(Character.toLowerCase(c));
		   } else {
			   sb.append(c);
		   }
		  }
		return sb.toString();
	}
	
	/**
	 *  Convert byte[] to hex string.这里我们可以将byte转换成int，然后利用Integer.toHexString(int)来转换成16进制字符串。  
	 * @param src byte[] data  
	 * @return hex string  
	 */     
	public static String bytesToHexString(byte[] src){  
	    StringBuilder stringBuilder = new StringBuilder();  
	    if (src == null || src.length <= 0) {  
	        return null;  
	    }  
	    for (int i = 0; i < src.length; i++) {  
	        int v = src[i] & 0xFF;  
	        String hv = Integer.toHexString(v);  
	        if (hv.length() < 2) {  
	            stringBuilder.append(0);  
	        }  
	        stringBuilder.append(hv);  
	    }  
	    return stringBuilder.toString();  
	} 
	
	public static String mapToURL(Map<String, String> paramMap){
		if(paramMap == null || paramMap.isEmpty())
			return "";
		StringBuilder sb = new StringBuilder();
		for(String s : paramMap.keySet()){
			if(sb.length() > 0)
				sb.append('&');
			String value = paramMap.get(s);
			try {
				if(value == null)
					value="";
				value = URLEncoder.encode(value, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			sb.append(s).append('=').append(value);
		}
		return sb.toString();
	}
	
	/**
	 * id 转成9位的路径. 12345 => 000/012/345
	 * @param id
	 * @return
	 */
	public static String IdToURL(Integer id){
		if(id == null)
			return null;
		StringBuilder sb = new StringBuilder();
		sb.append("000000000").append(id);
		sb.delete(0, sb.length()-9);
		String url =  StrUtil.concat(sb.substring(0, 3), '/', sb.substring(3, 6), '/', sb.substring(6, 9));
		return url;
	}
	
	

	public static Long toLong(Object o){
	    String s = toString(o);
        if(StringUtils.isEmpty(s)){
            return null;
        }
        try{
            Long l = Long.parseLong(s);
            return l;
        } catch(Exception e){
            return null;
        }
	}

	public static Float toFloat(Object o){
		if(o instanceof BigDecimal){
			return ((BigDecimal)o).floatValue();
		}
		String s = toString(o);
		if(StringUtils.isEmpty(s)){
			return null;
		}
		try{
			Float i = Float.parseFloat(s);
			return i;
		} catch(Exception e){
			return null;
		}
	}

	public static Double toDouble(Object o){
	    if(o instanceof BigDecimal){
	        return ((BigDecimal)o).doubleValue();
	    }
        String s = toString(o);
        if(StringUtils.isEmpty(s)){
            return null;
        }
        try{
            Double i = Double.parseDouble(s);
            return i;
        } catch(Exception e){
            return null;
        }
    }
	
	public static Integer toInteger(Object o){
	    String s = toString(o);
	    if(StringUtils.isEmpty(s)){
	        return null;
	    }
	    try{
	    	if(s != null && s.contains(".")) {
	    		s = s.split("\\.")[0];
	    	}
	        Integer i = Integer.parseInt(s);
	        return i;
	    } catch(Exception e){
	        return null;
	    }
	}
	
	public static Short toShort(Object o){
	    String s = toString(o);
        if(StringUtils.isEmpty(s)){
            return null;
        }
        try{
            Short res = Short.valueOf(s);
            return res;
        } catch(Exception e){
            return null;
        }
    }
	
	public static String toString(Object o){
	    if(o == null){
	        return null;
	    }
	    if(o instanceof BigDecimal){
	        return ((BigDecimal)o).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
	    }
	    return String.valueOf(o);
	}
	
	public static BigDecimal toBigDecimal(Object o){
		if(o == null){
	        return null;
	    }
	    if(o instanceof BigDecimal){
	        return (BigDecimal)o;
	    }
	    String s = toString(o);
	    if(StringUtils.isEmpty(s) || "null".equalsIgnoreCase(s)){
	    	return null;
	    }
	    return  new BigDecimal(s);
	}
	
	public static Byte toByte(Object o){
	    Integer i = StrUtil.toInteger(o);
	    if(i == null){
	    	return null;
	    }
	    try{
	    	byte bt = (byte)i.intValue();
	    	return bt;
	    } catch(Exception e){
	        return null;
	    }
	}
	
	public static Date toDate(Object o){
		String s = StrUtil.toString(o);
		if(s != null){
			Date d = DateHelper.StringToDateAll(s);
			return d;
		}
		return null;
	}
	
	 /**金额为分的格式 */    
    public static final String CURRENCY_FEN_REGEX = "\\-?[0-9]+";    
        
    /**   
     * 将分为单位的转换为元并返回金额格式的字符串 （除100）  
     *   
     * @param amount  
     * @return  
     * @throws Exception   
     */    
    public static String changeF2Y(Long amount) throws Exception{    
        if(!amount.toString().matches(CURRENCY_FEN_REGEX)) {    
            throw new Exception("金额格式有误");    
        }    
            
        int flag = 0;    
        String amString = amount.toString();    
        if(amString.charAt(0)=='-'){    
            flag = 1;    
            amString = amString.substring(1);    
        }    
        StringBuffer result = new StringBuffer();    
        if(amString.length()==1){    
            result.append("0.0").append(amString);    
        }else if(amString.length() == 2){    
            result.append("0.").append(amString);    
        }else{    
            String intString = amString.substring(0,amString.length()-2);    
            for(int i=1; i<=intString.length();i++){    
                if( (i-1)%3 == 0 && i !=1){    
                    result.append(",");    
                }    
                result.append(intString.substring(intString.length()-i,intString.length()-i+1));    
            }    
            result.reverse().append(".").append(amString.substring(amString.length()-2));    
        }    
        if(flag == 1){    
            return "-"+result.toString();    
        }else{    
            return result.toString();    
        }    
    }    
        
    /**  
     * 将分为单位的转换为元 （除100）  
     *   
     * @param amount  
     * @return  
     * @throws Exception   
     */    
    public static String changeF2Y(String amount){    
        if(!amount.matches(CURRENCY_FEN_REGEX)) {
        	return amount;
        }    
        return BigDecimal.valueOf(Long.valueOf(amount)).divide(new BigDecimal(100)).toString();    
    }    
        
    /**   
     * 将元为单位的转换为分 （乘100）  
     *   
     * @param amount  
     * @return  
     */    
    public static String changeY2F(Long amount){    
        return BigDecimal.valueOf(amount).multiply(new BigDecimal(100)).toString();    
    }    
        
    /**   
     * 将元为单位的转换为分 替换小数点，支持以逗号区分的金额  
     *   
     * @param amount  
     * @return  
     */    
    public static String changeY2F(String amount){    
        String currency =  amount.replaceAll("\\$|\\￥|\\,", "");  //处理包含, ￥ 或者$的金额    
        int index = currency.indexOf(".");    
        int length = currency.length();    
        Long amLong = 0l;    
        if(index == -1){    
            amLong = Long.valueOf(currency+"00");    
        }else if(length - index >= 3){    
            amLong = Long.valueOf((currency.substring(0, index+3)).replace(".", ""));    
        }else if(length - index == 2){    
            amLong = Long.valueOf((currency.substring(0, index+2)).replace(".", "")+0);    
        }else{    
            amLong = Long.valueOf((currency.substring(0, index+1)).replace(".", "")+"00");    
        }    
        return amLong.toString();    
    }    
    
	public static boolean contains(String pare, String sub){
		return contains( pare,  sub,  ",");
	}
	
	public static boolean contains(String pare, String sub, String split){
		if(pare == null || sub == null){
			return false;
		}
		return (pare+split).contains(sub + split);
	}
}
