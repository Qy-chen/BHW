package com.bingsum.controller;

import com.bingsum.annotation.Api;
import com.bingsum.cache.StaffCache;
import com.bingsum.mapper.StaffMapper;
import com.bingsum.model.Staff;
import com.bingsum.service.StaffService;
import com.bingsum.service.SysAuthService;
import com.bingsum.util.ApiUtil;
import com.bingsum.util.BusiData;
import com.bingsum.util.HttpUtil;
import com.bingsum.util.Page;
import com.bingsum.util.ParaData;
import com.bingsum.util.StrUtil;
import com.github.pagehelper.PageInfo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.target.SingletonTargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
public class ApiController {
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private StaffMapper staffMapper;
	
	@Autowired
	private SysAuthService sysAuthService;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/api/{service}/{methodName}", method = RequestMethod.POST)
	public Object api(Page pg,  HttpServletRequest request,@PathVariable("service") String service,@PathVariable("methodName") String methodName) {
		ParaData pd = pg.getPd();
	    String ip = HttpUtil.getIpAddr(request);
		Object result = null;
		
		Advised advised = (Advised) applicationContext.getBean(service);
		SingletonTargetSource singTarget = (SingletonTargetSource) advised.getTargetSource();
		Object serObj = singTarget.getTarget();
		
		try {
			Class paramsClass = ParaData.class;
			Method method = serObj.getClass().getMethod(methodName,  paramsClass);
			Api api = method.getAnnotation(Api.class);
			if(api == null) {
				return ApiUtil.returnDescFail(new ParaData(), "未定义api注解的方法");
			}
			String params = api.notNullPara();
			if(StringUtils.isNotBlank(params)) {
				String[] arr = params.split(",");
				for(String s : arr) {
					if(pd.get(s) == null) {
						return ApiUtil.returnDescFail(new ParaData(), s+"不能为空");
					}
				}
			}
			String noAuth = api.noAuth();
			if(StringUtils.isBlank(noAuth)) {
				//获取登录信息
				String token = pd.getString("token");
				if(StringUtils.isBlank(token)) {
					return ApiUtil.returnDescFail(new ParaData(), "token不能为空");
				}
				Staff staff = StaffCache.getByToken(token, staffMapper);
				if(staff == null) {
					return ApiUtil.returnDescFail(new ParaData(), "无效的token");
				}
				pd.put("loginStaff", staff);
				//验证用户的接口权限
				if(!"admin".equalsIgnoreCase(staff.getUsername())) {
					if(!sysAuthService.isAuth(staff, StrUtil.concat(service, "/", methodName))) {
						return ApiUtil.returnDescFail(new ParaData(), "接口权限不足");
					}
				}
			}
            pd.put("ip", ip);
            result = method.invoke(serObj, pd);
			if (result == null) {
				result = ApiUtil.returnFail(pd, BusiData.COMMON_EXCEPTION);
			}
		} catch (Exception e) {
			if(e instanceof NoSuchMethodException) {
				return ApiUtil.returnDescFail(new ParaData(), "未定义的接口");
			}
			e.printStackTrace();
			result = ApiUtil.returnDescFail(new ParaData(), "业务异常");
		}
		return result;
	}
}
