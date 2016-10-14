package com.bit2016.guestbook2.vo;

public class guestbookVo {
	private int no;
	private String name;
	private String context;
	private String passwd;
	private String date;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "guestbookVo [no=" + no + ", name=" + name + ", context=" + context + ", passwd=" + passwd + ", date="
				+ date + "]";
	}
	
}
