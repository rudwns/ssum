package com.DAO;

public class ssumVO {
	private String id;
	private String pw;
	private String name;
	private String personnumber;
	private String sex;
	
	public ssumVO(String id, String pw, String name, String personnumber, String sex) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.personnumber = personnumber;
		this.sex = sex;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPersonnumber() {
		return personnumber;
	}
	public void setPersonnumber(String personnumber) {
		this.personnumber = personnumber;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	
	
}
