package org.lanqiao.entity;


public class OrderDetail {
	private String orderdetailid;
	private String gtitle;
	private double gsaleprice;
	private int gnumber;
	private String orderid;
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
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}
	public OrderDetail(String orderdetailid, String gtitle, double gsaleprice,
			int gnumber, String orderid) {
		super();
		this.orderdetailid = orderdetailid;
		this.gtitle = gtitle;
		this.gsaleprice = gsaleprice;
		this.gnumber = gnumber;
		this.orderid = orderid;
	}
	
	
}
