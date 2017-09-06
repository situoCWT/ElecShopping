package org.lanqiao.entity;

import java.util.Date;

public class Order {
	private String orderid;
	private String userid;
	private String gid;
	private double totalprice;
	private Date orderdate;
	private String state;
	
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
	public Order(String orderid, String userid, String gid, double totalprice,
			Date orderdate, String state) {
		super();
		this.orderid = orderid;
		this.userid = userid;
		this.gid = gid;
		this.totalprice = totalprice;
		this.orderdate = orderdate;
		this.state = state;
	}
	
	
	
}
