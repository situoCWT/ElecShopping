package org.lanqiao.entity;

public class Category {
	public String cid;
	public String cname;
	public int corder;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCorder() {
		return corder;
	}
	public void setCorder(int corder) {
		this.corder = corder;
	}
	public Category(String cid, String cname, int corder) {
		this.cid = cid;
		this.cname = cname;
		this.corder = corder;
	}
	public Category(){
		
	}
}
