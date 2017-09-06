package org.lanqiao.entity;

public class Search {
	private String sname;
	private String scontent;
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getScontent() {
		return scontent;
	}
	public void setScontent(String scontent) {
		this.scontent = scontent;
	}
	public Search(String sname, String scontent) {
		super();
		this.sname = sname;
		this.scontent = scontent;
	}
	
	public Search() {
		// TODO Auto-generated constructor stub
	}
}
