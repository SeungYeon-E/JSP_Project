package com.jspproject.bbs.dto;

import java.sql.Timestamp;

public class ContentItemdto {
	int iNo;
	String userEmail;
	String iTitle;
	String iContent;
	String iCategory;
	int iHits;
	Timestamp wRegistDate;
	
	String cContent;
	Timestamp cRegistDate;
	
	
	// 굳이 이미지 가져올 필요가 없어
	String iImg;
	// int pLike = resultset.getInt("pLike");// Like수없나요?
	
	
	
	public ContentItemdto(int iNo, String userEmail, String iTitle, String iContent, String iImg, String iCategory,
		int iHits, Timestamp wRegistDate) {
	super();
	this.iNo = iNo;
	this.userEmail = userEmail;
	this.iTitle = iTitle;
	this.iContent = iContent;
	this.iImg = iImg;
	this.iCategory = iCategory;
	this.iHits = iHits;
	this.wRegistDate = wRegistDate;
}

	public ContentItemdto(String userEmail, String cContent, Timestamp cRegistDate) {
		super();
		this.userEmail = userEmail;
		this.cContent = cContent;
		this.cRegistDate = cRegistDate;
	}

	public ContentItemdto() {
		// TODO Auto-generated constructor stub
	}
	

	public String getcContent() {
		return cContent;
	}

	public void setcContent(String cContent) {
		this.cContent = cContent;
	}

	public Timestamp getcRegistDate() {
		return cRegistDate;
	}

	public void setcRegistDate(Timestamp cRegistDate) {
		this.cRegistDate = cRegistDate;
	}

	public int getiNo() {
		return iNo;
	}

	public void setiNo(int iNo) {
		this.iNo = iNo;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getiTitle() {
		return iTitle;
	}

	public void setiTitle(String iTitle) {
		this.iTitle = iTitle;
	}

	public String getiContent() {
		return iContent;
	}

	public void setiContent(String iContent) {
		this.iContent = iContent;
	}

	public String getiImg() {
		return iImg;
	}

	public void setiImg(String iImg) {
		this.iImg = iImg;
	}

	public String getiCategory() {
		return iCategory;
	}

	public void setiCategory(String iCategory) {
		this.iCategory = iCategory;
	}

	public int getiHits() {
		return iHits;
	}

	public void setiHits(int iHits) {
		this.iHits = iHits;
	}

	public Timestamp getwRegistDate() {
		return wRegistDate;
	}

	public void setwRegistDate(Timestamp wRegistDate) {
		this.wRegistDate = wRegistDate;
	}
	
	
	
}