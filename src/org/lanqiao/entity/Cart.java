package org.lanqiao.entity;

import java.util.Date;

public class Cart {
	private String orderid;
	private String userid;
	private String gid;
	private double totalprice;
	private Date orderdate;
	private String state;
	private String orderdetailid;
	private String gtitle;
	private double gsaleprice;
	private int gnumber;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getOrderdetailid() {
		return orderdetailid;
	}
	public void setOrderdetailid(String orderdetailid) {
		this.orderdetailid = orderdetailid;
	}
	public String getGtitle() {
		return gtitle;
	}
	public void setGtitle(String gtitle) {
		this.gtitle = gtitle;
	}
	public double getGsaleprice() {
		return gsaleprice;
	}
	public void setGsaleprice(double gsaleprice) {
		this.gsaleprice = gsaleprice;
	}
	public int getGnumber() {
		return gnumber;
	}
	public void setGnumber(int gnumber) {
		this.gnumber = gnumber;
	}
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}
	
	public Cart(String orderid, String userid, String gid, double totalprice,
			Date orderdate, String state, String orderdetailid, String gtitle,
			double gsaleprice, int gnumber) {
		super();
		this.orderid = orderid;
		this.userid = userid;
		this.gid = gid;
		this.totalprice = totalprice;
		this.orderdate = orderdate;
		this.state = state;
		this.orderdetailid = orderdetailid;
		this.gtitle = gtitle;
		this.gsaleprice = gsaleprice;
		this.gnumber = gnumber;
	}
	
	
}
