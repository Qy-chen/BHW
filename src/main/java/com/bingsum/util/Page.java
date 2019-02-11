package com.bingsum.util;

import java.util.HashMap;
import java.util.Map;

public class Page{
	
	private static final long serialVersionUID = 1L;
	private int length =15; // 每页显示记录数
	private int recordsTotal; // 总记录数
	private int recordsFiltered; // 总记录数
	private int draw = 1; // 调用次数
	private int start; // 当前记录起始索引
	private boolean entityOrField; // true:需要分页的地方，传入的参数就是Page实体；false:需要分页的地方，传入的参数所代表的实体拥有Page属性

	private Object data = null;

	private ParaData busiParam = new ParaData();

	private ParaData pd = new ParaData();

	public Page() {
	}

	public void toExportModel(){
		this.setLength(999999);
		this.setStart(0);
	}
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public boolean isEntityOrField() {
		return entityOrField;
	}

	public void setEntityOrField(boolean entityOrField) {
		this.entityOrField = entityOrField;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ParaData getPd() {
		return pd;
	}

	public void setPd(ParaData pd) {
		this.pd = pd;
	}

	public ParaData getBusiParam() {
		return busiParam;
	}

	public void setBusiParam(ParaData busiParam) {
		this.busiParam = busiParam;
	}
	
	public ParaData toPageRes() {
		Integer pageTotal = this.getRecordsTotal()/this.getLength() + ((this.getRecordsTotal()%this.getLength()) > 0 ? 1 : 0);
		ParaData pd = ParaData.getInstance().afterPut("pageSize", this.getLength())
				.afterPut("recordsTotal", this.getRecordsTotal())
				.afterPut("list", this.getData())
				.afterPut("pageNo", this.getPd().get("pageNo"))
				.afterPut("pageTotal", pageTotal);
		return pd;
	}
	
	public boolean isExport() {
		return "1".equals(this.pd.getString("isExport"));
	}
}
