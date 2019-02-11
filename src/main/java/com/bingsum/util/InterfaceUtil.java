package com.bingsum.util;


import org.apache.commons.lang3.StringUtils;

public class InterfaceUtil {
	private String code;

	private String desc = "";

	private Object body;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
		if (StringUtils.isBlank(desc)) {
			this.desc = BusiData.commonStatusMap.get(code);
		}
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}

	public InterfaceUtil success(Object object) {
		this.body = object;
		this.code = BusiData.COMMON_STATUS_SUCCESS;
		this.desc = BusiData.commonStatusMap.get(this.code);
		return this;
	}
	
	public InterfaceUtil success() {
		this.code = BusiData.COMMON_STATUS_SUCCESS;
		this.desc = BusiData.commonStatusMap.get(this.code);
		return this;
	}

}
