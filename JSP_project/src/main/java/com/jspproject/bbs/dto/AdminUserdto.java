package com.jspproject.bbs.dto;

import java.sql.Date;

public class AdminUserdto {
	
	String email;
	String name;
	String adress;
	String tel;
	String git;
	Date createdate;
	Date deletedate;
	int admin;
	
	public AdminUserdto(String email, String name, String adress, String tel, String git, Date createdate,
			Date deletedate, int admin) {
		super();
		this.email = email;
		this.name = name;
		this.adress = adress;
		this.tel = tel;
		this.git = git;
		this.createdate = createdate;
		this.deletedate = deletedate;
		this.admin = admin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getGit() {
		return git;
	}
	public void setGit(String git) {
		this.git = git;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Date getDeletedate() {
		return deletedate;
	}
	public void setDeletedate(Date deletedate) {
		this.deletedate = deletedate;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	
	
}
