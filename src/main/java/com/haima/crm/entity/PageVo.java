package com.haima.crm.entity;

import java.io.Serializable;

public class PageVo implements Serializable {
	private static final long serialVersionUID = -4056260441770908644L;
	private Integer page;
	private Integer limit;
	private Integer offset;// 从第几条开始查询 offset = (page-1)*limit

	public Integer getPage() {
		if (page == null || page < 1) {
			return 1;
		}
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		if (limit == null || limit < 1) {
			return 10;
		}
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getOffset() {
		if (offset == null) {
			return (getPage() - 1) * getLimit();
		}
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

}
