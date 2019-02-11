package com.bingsum.interceptor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bingsum.util.ApiUtil;
import com.bingsum.util.BusiData;
import com.bingsum.util.IpHandler;
import com.bingsum.util.JsonBeanSwaps;
import com.bingsum.util.JsonToMap;
import com.bingsum.util.Page;
import com.bingsum.util.ParaData;
import com.bingsum.util.Tools;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@Component
@Aspect
public class ApiParamAspectJ {


	private static final Logger log = LoggerFactory.getLogger(ApiParamAspectJ.class);

	public final String paramError = "controller方法中必须包含参数Page,请联系后端技术人员解决";

	public final String paramErrorBusiCode = "请输入业务类型参数【busiCode】";

	public final String paramRateError = "手速太快，服务器需要休息一会......";

	public final String paramBlankError = "因不合法操作，此IP已受限";

	public final String paramErrorBusiCode2 = "请输入正确的业务参数【busiCode】";

	public final String paramErrorBusiCode3 = "加密接口，请输入正确的业务参数【userId】";

	public final String paramErrorBusiCode4 = "用户加密处理失败，联系管理员查看用户加密信息是否有误";

	public Object commonHandler(ProceedingJoinPoint point, ParaData pd, JsonObject object) {
		long startTime = System.currentTimeMillis();
		Object result = null;

		JsonObject body = object.get("body").getAsJsonObject();

		boolean isLog = false;

		Class clazz = point.getTarget().getClass();
		log.debug(
				"执行类 [" + clazz.getName() + "." + point.getSignature().getName() + "]方法入参：" + JsonBeanSwaps.toJson(pd));
		ParaData pdBody = null;
		try {
			Object args[] = point.getArgs();
			if (args != null && args.length > 0) {
				boolean isContain = false;
				for (Object arg : args) {
					if (arg instanceof Page) {
						Page pg = (Page)arg;
						Map<String, Object> aMap = JsonToMap.toMap(body);
						pd.remove("body");
						pd.putAll(aMap);
						pg.setPd(pd);
					}
				}
			}
			result = point.proceed(args);
			log.debug(pd.getString("busiCode") + ":" + result);
		} catch (Throwable e) {
			e.printStackTrace();
			long endTime = System.currentTimeMillis();
			log.error("around " + point + "\tUse time : " + (endTime - startTime) + " ms with exception : "
					+ e.getMessage());
			return ApiUtil.returnFail(pd, BusiData.COMMON_EXCEPTION);
		} finally {
			if (isLog) {
				ParaData pdLog = new ParaData();
				HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
						.getRequest();
				Gson gson = new Gson();
				pdLog.put("busiCode", pd.get("busiCode"));
				pdLog.put("requestId", request.getSession().getId());
				String reqContent = gson.toJson(pdBody).toString();
				if (reqContent != null && reqContent.length() > 1000) {
					reqContent = reqContent.substring(0, 1000);
				}
				pdLog.put("reqContent", reqContent);
				String rspContent = gson.toJson(result).toString();
				if (rspContent != null && rspContent.length() > 1000) {
					rspContent = rspContent.substring(0, 1000);
				}
				pdLog.put("rspContent", rspContent);
				pdLog.put("execTime", System.currentTimeMillis() - startTime);
				pdLog.put("state", 1);
				pdLog.put("ipaddr", IpHandler.getIPAddress(request));
				log.debug(pdLog.toString());
			}
		}
		return result;
	}

	/**
	 * 参数的权限的验证
	 * 
	 * @param pd
	 * @return
	 */
	public String authCheck(Map<String, Object> pd) {

		return null;
	}

	public String getParams(HttpServletRequest request) {
		StringBuffer json = new StringBuffer();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
			String line = null;
			while (StringUtils.isNotBlank(line = reader.readLine())) {
				json.append(line);
			}
		} catch (IOException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return json.toString();
	}


	@Around("FromHandlerController()")
	public Object formPreHandler(ProceedingJoinPoint point) throws Throwable {

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();

		String ipaddress = request.getRemoteAddr();


		String json = getParams(request);
		if (StringUtils.isBlank(json)) {
			return ApiUtil.returnDescFail(new ParaData(), paramErrorBusiCode);
		}

		// log.debug("##############################"+json.toString());
		String s = new JsonParser().parse(json.toString()).getAsJsonObject().toString();
		log.debug(s);

		Map<String, Object> map = JsonToMap.toMap(json);
		ParaData pd = new ParaData(map);

		JsonObject object = new JsonParser().parse(json).getAsJsonObject();

		return this.commonHandler(point, pd, object);
	}

	@Pointcut("execution(* com.bingsum.controller.ApiController.api(..))") // 拦截所有的controller
	public void FromHandlerController() {

	}

}