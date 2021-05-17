package com.jspproject.bbs.dto;

import java.sql.Timestamp;

public class ContentItemdto {
	int bId;
	String bName;
	String bTitle;
	String bContent;
	Timestamp bDate;
	
	int pNo;
	String userEmail;
	String pTitle;
	String pContent;
	String pImg;
	String pCategory;
	int pHits;
	int pLike;
	Timestamp wRegistDate;
	
	String cContent;
	Timestamp cRegisDate;
	
	public ContentItemdto() {
		// TODO Auto-generated constructor stub
	}
	
	public ContentItemdto(int bId, String bName, String bTitle, String bContent, Timestamp bDate) {
		super();
		this.bId = bId;
		this.bName = bName;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bDate = bDate;
	}
	
	public ContentItemdto(String userEmail, String cContent, Timestamp cRegisDate) {
		super();
		this.userEmail = userEmail;
		this.cContent = cContent;
		this.cRegisDate = cRegisDate;
	}
	
	public ContentItemdto(int pNo, String userEmail, String pTitle, String pContent, String pImg, String pCategory, int pHits, int pLike,
			Timestamp wRegistDate) {
		super();
		this.pNo = pNo;
		this.userEmail = userEmail;
		this.pTitle = pTitle;
		this.pContent = pContent;
		this.pImg = pImg;
		this.pCategory = pCategory;
		this.pHits = pHits;
		this.pLike = pLike;
		this.wRegistDate = wRegistDate;
	}

	public String getcContent() {
		return cContent;
	}

	public void setcContent(String cContent) {
		this.cContent = cContent;
	}

	public Timestamp getcRegisDate() {
		return cRegisDate;
	}

	public void setcRegisDate(Timestamp cRegisDate) {
		this.cRegisDate = cRegisDate;
	}

	
	
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public String getpTitle() {
		return pTitle;
	}

	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}

	public String getpContent() {
		return pContent;
	}

	public void setpContent(String pContent) {
		this.pContent = pContent;
	}

	public String getpImg() {
		return pImg;
	}

	public void setpImg(String pImg) {
		this.pImg = pImg;
	}

	public String getpCategory() {
		return pCategory;
	}

	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}

	public int getpHits() {
		return pHits;
	}

	public void setpHits(int pHits) {
		this.pHits = pHits;
	}

	public int getpLike() {
		return pLike;
	}

	public void setpLike(int pLike) {
		this.pLike = pLike;
	}

	public Timestamp getwRegistDate() {
		return wRegistDate;
	}

	public void setwRegistDate(Timestamp wRegistDate) {
		this.wRegistDate = wRegistDate;
	}


	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public Timestamp getbDate() {
		return bDate;
	}

	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}
}
