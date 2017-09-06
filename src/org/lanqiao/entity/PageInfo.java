package org.lanqiao.entity;

import java.util.List;

public class PageInfo<T> {
	private int pageindex;
	private int pagesize;
	private int totalnumber;
	private int totalpages;
	private boolean isfirstpage;
	private boolean islastpage;
	private List<T> list;
	public int getPageindex() {
		return pageindex;
	}
	public void setPageindex(int pageindex) {
		this.pageindex = pageindex;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getTotalnumber() {
		return totalnumber;
	}
	public void setTotalnumber(int totalnumber) {
		this.totalnumber = totalnumber;
	}
	public int getTotalpages() {
		return totalpages;
	}
	public void setTotalpages(int totalpages) {
		this.totalpages = totalpages;
	}
	public boolean getIsfirstpage() {
		return isfirstpage;
	}
	public void setIsfirstpage(boolean isfirstpage) {
		this.isfirstpage = isfirstpage;
	}
	public boolean getIslastpage() {
		return islastpage;
	}
	public void setIslastpage(boolean islastpage) {
		this.islastpage = islastpage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public PageInfo(int pageindex, int pagesize, int totalnumber,
			int totalpages, boolean isfirstpage, boolean islastpage,
			List<T> list) {
		super();
		this.pageindex = pageindex;
		this.pagesize = pagesize;
		this.totalnumber = totalnumber;
		this.totalpages = totalpages;
		this.isfirstpage = isfirstpage;
		this.islastpage = islastpage;
		this.list = list;
	}
	public PageInfo() {
		// TODO Auto-generated constructor stub
	}
	
}
