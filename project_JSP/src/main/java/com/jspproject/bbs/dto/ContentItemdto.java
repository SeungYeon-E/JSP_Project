package com.jspproject.bbs.dto;

import java.sql.Date;

public class ContentItemdto {
	int i_num;
	String name;
	String user_email;
	String i_title;
	String i_content;
	String i_category;
	int i_hits;
	Date iw_regist;
	
	int ic_num;
	String ic_content;
	Date ic_regist;
	
	String i_image;
	
	public ContentItemdto(int i_num, String name, String user_email, String i_title, String i_content, String i_image, String i_category,
		int i_hits, Date iw_regist) {
	super();
	this.i_num = i_num;
	this.name = name;
	this.user_email = user_email;
	this.i_title = i_title;
	this.i_content = i_content;
	this.i_image = i_image;
	this.i_category = i_category;
	this.i_hits = i_hits;
	this.iw_regist = iw_regist;
}

	public ContentItemdto(int ic_num, String ic_content) {
		super();
		this.ic_num = ic_num;
		this.ic_content = ic_content;
	}

	public ContentItemdto(int ic_num, String name, String user_email, String ic_content, Date ic_regist) {
		super();
		this.ic_num = ic_num;
		this.name = name;
		this.user_email = user_email;
		this.ic_content = ic_content;
		this.ic_regist = ic_regist;
	}

	public ContentItemdto() {
		// TODO Auto-generated constructor stub
	}
	

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public int getic_num() {
		return ic_num;
	}

	public void setic_num(int ic_num) {
		this.ic_num = ic_num;
	}

	public String getic_content() {
		return ic_content;
	}

	public void setic_content(String ic_content) {
		this.ic_content = ic_content;
	}

	public Date getic_regist() {
		return ic_regist;
	}

	public void setic_regist(Date ic_regist) {
		this.ic_regist = ic_regist;
	}

	public int geti_num() {
		return i_num;
	}

	public void seti_num(int i_num) {
		this.i_num = i_num;
	}

	public String getuser_email() {
		return user_email;
	}

	public void setuser_email(String user_email) {
		this.user_email = user_email;
	}

	public String geti_title() {
		return i_title;
	}

	public void seti_title(String i_title) {
		this.i_title = i_title;
	}

	public String geti_content() {
		return i_content;
	}

	public void seti_content(String i_content) {
		this.i_content = i_content;
	}

	public String geti_image() {
		return i_image;
	}

	public void seti_image(String i_image) {
		this.i_image = i_image;
	}

	public String geti_category() {
		return i_category;
	}

	public void seti_category(String i_category) {
		this.i_category = i_category;
	}

	public int geti_hits() {
		return i_hits;
	}

	public void seti_hits(int i_hits) {
		this.i_hits = i_hits;
	}

	public Date getiw_regist() {
		return iw_regist;
	}

	public void setiw_regist(Date iw_regist) {
		this.iw_regist = iw_regist;
	}
	
	
}