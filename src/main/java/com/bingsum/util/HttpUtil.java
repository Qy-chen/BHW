package com.bingsum.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.CollationKey;
import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("rawtypes")
public class HttpUtil {
	
	private static final Logger log = LoggerFactory.getLogger(HttpUtil.class);
	
	public static String[] mobileAgents = { "iphone", "android", "phone", "mobile",
            "wap", "netfront", "java", "opera mobi", "opera mini", "ucweb",
            "windows ce", "symbian", "series", "webos", "sony",
            "blackberry", "dopod", "nokia", "samsung", "palmsource", "xda",
            "pieplus", "meizu", "midp", "cldc", "motorola", "foma",
            "docomo", "up.browser", "up.link", "blazer", "helio", "hosin",
            "huawei", "novarra", "coolpad", "webos", "techfaith",
            "palmsource", "alcatel", "amoi", "ktouch", "nexian",
            "ericsson", "philips", "sagem", "wellcom", "bunjalloo", "maui",
            "smartphone", "iemobile", "spice", "bird", "zte-", "longcos",
            "pantech", "gionee", "portalmmm", "jig browser", "hiptop",
            "benq", "haier", "^lct", "320x320", "240x320", "176x220",
            "w3c ", "acs-", "alav", "alca", "amoi", "audi", "avan", "benq",
            "bird", "blac", "blaz", "brew", "cell", "cldc", "cmd-", "dang",
            "doco", "eric", "hipt", "inno", "ipaq", "java", "jigs", "kddi",
            "keji", "leno", "lg-c", "lg-d", "lg-g", "lge-", "maui", "maxo",
            "midp", "mits", "mmef", "mobi", "mot-", "moto", "mwbp", "nec-",
            "newt", "noki", "oper", "palm", "pana", "pant", "phil", "play",
            "port", "prox", "qwap", "sage", "sams", "sany", "sch-", "sec-",
            "send", "seri", "sgh-", "shar", "sie-", "siem", "smal", "smar",
            "sony", "sph-", "symb", "t-mo", "teli", "tim-", /*"tosh",*/ "tsm-",
            "upg1", "upsi", "vk-v", "voda", "wap-", "wapa", "wapi", "wapp",
            "wapr", "webc", "winw", "winw", "xda", "xda-",
            "Googlebot-Mobile" };
	
	 public static boolean fromMobile(HttpServletRequest request){
	        boolean isMoblie = false;
	        if (request.getHeader("User-Agent") != null) {
	            for (String mobileAgent : mobileAgents) {
	                if (request.getHeader("User-Agent").toLowerCase().indexOf(mobileAgent) >= 0) {
	                    isMoblie = true;
	                    break;
	                }
	            }
	        }
	        return isMoblie;
	    }
	 
	public static String send(String url, boolean readAll, String enc) {
		BufferedReader br = null;
		StringBuilder sb;
		if(readAll) sb=new StringBuilder(1024);
		else sb=new StringBuilder(1024);
		sb.append("");
        HttpURLConnection urlconn=null;
        try {
        	urlconn = (HttpURLConnection) new URL(url).openConnection();
            urlconn.setConnectTimeout(60000);
            urlconn.setReadTimeout(60000);
            urlconn.connect();// 进行连接，但是实际上get request要在下一句的connection.getInputStream()函数中才会真正发到
            br = new BufferedReader(new InputStreamReader(urlconn.getInputStream(),enc));//设置编码,否则中文乱码
            if(readAll){
                String lines;
                if((lines = br.readLine()) != null){
                	sb.append(lines.replace("encoding=\"UTF-8\"", "encoding=\"gbk\"")
                			.replace("encoding=\"utf-8\"", "encoding=\"gbk\"")
                			+"\n");
                }
                while ((lines = br.readLine()) != null){
                	sb.append(lines+"\n");
                }
            }else br.read();//读一个字节测试
        } catch (Exception e) {
            e.getStackTrace();
            log.error(url, e);
        } finally {
            try {br.close();} catch (Exception e) {}
            try {urlconn.disconnect();} catch (Exception e) {}
        }
        return sb.toString();
	}
	
	
	
	public static String httpSend(String url, boolean readAll, String enc) {
		BufferedReader br = null;
		StringBuilder sb;
		if(readAll) sb=new StringBuilder(1024);
		else sb=new StringBuilder(1024);
		sb.append("");
        HttpURLConnection urlconn=null;
        try {
        	urlconn = (HttpURLConnection) new URL(url).openConnection();
//        	urlconn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            urlconn.setConnectTimeout(60000);
            urlconn.setReadTimeout(60000);
            urlconn.connect();// 进行连接，但是实际上get request要在下一句的connection.getInputStream()函数中才会真正发到
            br = new BufferedReader(new InputStreamReader(urlconn.getInputStream(),enc));//设置编码,否则中文乱码
            if(readAll){
                String lines;
                if((lines = br.readLine()) != null){
                	sb.append(lines.replace("encoding=\"UTF-8\"", "encoding=\"" + enc + "\"")
                			.replace("encoding=\"utf-8\"", "encoding=\"" + enc + "\"")
                			+"\n");
                }
                while ((lines = br.readLine()) != null){
                	sb.append(lines+"\n");
                }
            }else br.read();//读一个字节测试
        } catch (Exception e) {
            e.getStackTrace();
            log.error("请求异常:" + url, e);
        } finally {
            try {br.close();} catch (Exception e) {}
            try {urlconn.disconnect();} catch (Exception e) {}
        }
        return sb.toString();
	}
	
	public static String send(String url, boolean readAll) {
		return send(url, readAll, "utf-8");
	}
	
	public static String url2Encode(String url, String enc){
		try {
			return java.net.URLEncoder.encode(url, enc);
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static String url2Decode(String url, String enc){
		try {
			return java.net.URLDecoder.decode(url, enc);
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static HashMap<String, String> url2MapDecoder(String url, String enc) {
		HashMap<String, String> map=new HashMap<String, String>();
		for(String s: url.split("`")){
			try {
				int idx=s.indexOf("=");
				if(idx>0){
					map.put(s.substring(0,idx), java.net.URLDecoder.decode(s.substring(idx+1), enc));
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
				
		}
		return map;
	}
	
	public static HashMap<String, String> url2Map(String url) {
		HashMap<String, String> map=new HashMap<String, String>();
		for(String s: url.split("`")){
			int idx=s.indexOf("=");
			if(idx>0){
				map.put(s.substring(0,idx), s.substring(idx+1));
			}
		}
		return map;
	}

    public static String getHttpUrlParam(String url,String paramName){
    	String beginStr=paramName+"=";
    	String endStr="&";
    	int beginIndex=url.indexOf(beginStr)+beginStr.length();
		int endIndex=url.indexOf(endStr,beginIndex);
		if(endIndex<0){
			endIndex=url.length();
		}
		if(beginIndex<0 || endIndex<beginIndex){
			return "";
		}
		return url.substring(beginIndex, endIndex);
    }
    
    public static String getHttpUrlParam(String url,String paramName, String split){
    	String beginStr=paramName+"=";
    	String endStr=split;
    	int beginIndex=url.indexOf(beginStr)+beginStr.length();
		int endIndex=url.indexOf(endStr,beginIndex);
		if(endIndex<0){
			endIndex=url.length();
		}
		if(beginIndex<0 || endIndex<beginIndex){
			return "";
		}
		return url.substring(beginIndex, endIndex);
    }
    
    /**
     * 转换编码 ISO-885Array-1到GB2312
     * @param str
     * @return
     */
	public static String convertEnc(String str, String sourceEnc, String targetEnc) {
		String result = "";
		try {
			result = new String(str.getBytes(sourceEnc), targetEnc);
//			result = new String(str.getBytes("ISO-885Array-1"), "GB2312");
		} catch (UnsupportedEncodingException ex) {
			result = ex.toString();
		}
		return result;
	} 
	
	/**
	 * MD5 加密
	 */
	public static String getMD5Str(String str, String enc) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(str.getBytes(enc));//"gb2312"
		} catch (NoSuchAlgorithmException e) {
			//System.out.println("NoSuchAlgorithmException caught!");
			System.exit(-1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		byte[] byteArray = messageDigest.digest();
		StringBuffer md5StrBuff = new StringBuffer();
		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}
		return md5StrBuff.toString();
	}
	public static final Map<String, String> getRequestParamsInFilter(HttpServletRequest request) {
		Map<String,String> params = new HashMap<String,String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				String vStr = "";
				vStr = values[i];
//				try {
//					if (request.getMethod().equals("POST")) {
//						vStr = values[i];
//					} else {
//					    vStr = values[i];
//						vStr = new String(values[i].getBytes("ISO-8859-1"), "UTF-8");
//						values[i] = vStr;
//					}
//				} catch (UnsupportedEncodingException e) {
//					e.printStackTrace();
//				}
				valueStr = (i == values.length - 1) ? valueStr +  vStr
						: valueStr + values[i] + ",";
			}
			
			params.put(name, valueStr);
		}
		return params;
	}
	
	public static final Map<String, String> getRequestParams(HttpServletRequest request) {
		Map<String,String> params = new HashMap<String,String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				String vStr = "";
			    vStr = values[i];
				valueStr = (i == values.length - 1) ? valueStr +  vStr
						: valueStr + values[i] + ",";
			}
			
			params.put(name, valueStr);
		}
		return params;
	}
	
	public static String map2Str(Map<String, String> params) {
		StringBuffer url = new StringBuffer();
		int i = 0;
		for (Entry<String, String> entry : params.entrySet()) {
			String paramName = entry.getKey();
			String paramValue = entry.getValue();
			if (i == 0) {
				url.append("?");
			} else {
				url.append("&");
			}
			url.append(paramName).append("=").append(paramValue);
			i++;
		}
		return url.toString();
	}
	
	public static String postMap2Str(Map<String, String> params) {
		StringBuffer url = new StringBuffer();
		int i = 0;
		for (Entry<String, String> entry : params.entrySet()) {
			String paramName = entry.getKey();
			String paramValue = entry.getValue();
			url.append("&");
			url.append(paramName).append("=").append(paramValue);
			i++;
		}
		return url.toString();
	}
	
	public static String appendUrl(String url, String paramterName, String paramterValue) {
		if (!StringUtils.isEmpty(paramterValue)) {
			int x = -1;
			int y = -1;
			if ((x = url.indexOf("&" + paramterName + "=")) < 0 && (y = url.indexOf("?" + paramterName + "=")) < 0) {
				if (url.lastIndexOf("?") >= 0) {
					url+="&";
				} else {
					url+="?";
				}
				url+=paramterName+"="+paramterValue;
			} else {
				int z = (x>y?x:y);
				int end = (url.indexOf("&",z+1) > 0 ? url.indexOf("&",z+1) : url.length());
				url = url.replace(url.substring(z+paramterName.length()+"&=".length(),end),paramterValue);
			}
		}	
		return url;
	}

	public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if( ip.indexOf(",")!= -1){
            ip = ip.split(",")[0];
        }
        if(ip.contains(":")){
            ip="invalid";
            log.error("无效的IP:"+ip);
        }
        return ip;
    }
	

	public static String getSignMessage(String url){
	    if(StringUtils.isEmpty(url))
	    	return url;
		int index = url.indexOf('?');
		if(index < 0)
			return url;
	    Map<String, String> params = new HashMap<String, String>();
		while(index > -1){
			int nxtStart = url.indexOf("&", index+1);
			int endIndex = nxtStart;
			if(nxtStart < 0)
				endIndex = url.length();
			
			if(endIndex > -1 && index<endIndex){
				String pairStr = url.substring(index+1, endIndex);
				int i = pairStr.indexOf('=');
				if(i>-1){
					String v = pairStr.substring(i+1);
					try {
						v = URLDecoder.decode(v, "UTF-8");
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					params.put(pairStr.substring(0,i), v);
				}
			} else
				break;
			index = nxtStart;
		}
		return getSignMessage(params);
	}
	@SuppressWarnings("unchecked")
	public static String getSignMessage(Map<String, String> params) {
        StringBuilder signVal = new StringBuilder();
        Set<String> set = params.keySet();
        String[] keys = new String[set.size()];
        set.toArray(keys);
        Arrays.sort(keys, new MyComparator());
        for (String key : keys) {
            if ("sign".equals(key))  continue;
            String value = params.get(key);
            signVal.append(key).append(value);
        }
        return signVal.toString();
    }
	
	public static class MyComparator implements Comparator{
		private Collator collator = Collator.getInstance();// 点击查看中文api详解
		
		public int compare(Object o1, Object o2) {

			// 把字符串转换为一系列比特，它们可以以比特形式与 CollationKeys 相比较
			CollationKey key1 = collator.getCollationKey(o1.toString());// 要想不区分大小写进行比较用o1.toString().toLowerCase()
			CollationKey key2 = collator.getCollationKey(o2.toString());

			return key1.compareTo(key2);// 返回的分别为1,0,-1 分别代表大于，等于，小于。要想按照字母降序排序的话
										// 加个“-”号
		}
	}
	
	private final static int CONNECT_TIMEOUT = 5000; // in milliseconds
	private final static String DEFAULT_ENCODING = "UTF-8";

	public static String postData(String urlStr, String data) {
		return postData(urlStr, data, null);
	}

	public static String postData(String urlStr, String data, String contentType) {
		BufferedReader reader = null;
		try {
			URL url = new URL(urlStr);
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			conn.setConnectTimeout(CONNECT_TIMEOUT);
			conn.setReadTimeout(CONNECT_TIMEOUT);
			if (contentType != null)
				conn.setRequestProperty("content-type", contentType);
			OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream(), DEFAULT_ENCODING);
			if (data == null)
				data = "";
			writer.write(data);
			writer.flush();
			writer.close();

			reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), DEFAULT_ENCODING));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
				sb.append("\r\n");
			}
			return sb.toString();
		} catch (IOException e) {
//			((Object) logger).error("Error connecting to " + urlStr + ": " + e.getMessage());
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
			}
		}
		return null;
	}
	
	
	public final static void httpSendAsync(String urlStr, String data){
		CloseableHttpAsyncClient httpclient = HttpAsyncClients.createDefault();
        httpclient.start();

        final CountDownLatch latch = new CountDownLatch(1);
        final HttpPost request = new HttpPost(urlStr);
        StringEntity entity = new StringEntity(data, "UTF-8");

        entity.setContentType("application/json");
        request.setEntity(entity);

        httpclient.execute(request, new FutureCallback<HttpResponse>() {

            public void completed(final HttpResponse response) {
                latch.countDown();
                try {
                    String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                    log.info(" response content is : " + content);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            public void failed(final Exception ex) {
                latch.countDown();
                log.error(request.getRequestLine() + "->" + ex);
            }
            public void cancelled() {
                latch.countDown();
                log.info(request.getRequestLine() + " cancelled");
            }
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            httpclient.close();
        } catch (IOException ignore) {

        }
	}
	
	public static void main(String[] args) {
//		Map map = new HashMap<>();
//		map.put("topic", "user.userId");
//		map.put("routingKey", "user_"+"123456");
//		map.put("exchangeType","3");
//		String data = postMap2Str(map);
//		System.out.println("111");
//		postData("http://localhost:8089/message/rabbit/createTopic", data);
//		System.out.println("222");
		
		Map map2 = new HashMap<>();
		map2.put("content", "ccccccc");
		map2.put("routingKey", "room_"+"123456");
		String data2 = postMap2Str(map2);
		postData("http://192.168.0.229:8189/message/rabbit/topic", data2);
		
		
//		Map map3 = new HashMap<>();
//		map3.put("topic", "liveStart");
//		String data3 = postMap2Str(map3);
//		postData("http://192.168.0.229:8189/message/rabbit/consumer", data3);
	}
}
