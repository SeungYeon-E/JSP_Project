package com.jspproject.bbs.dto;

public class NoticeDto {
	int num;
	String title;
	String content;
	int views;
	
	public NoticeDto() {
		// TODO Auto-generated constructor stub
	}

	public NoticeDto(int num, String title, String content, int views) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.views = views;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}
	//================================
	int n_num;
	String n_title;
	String n_content;
	
	public NoticeDto(int n_num, String n_title, String n_content) {
		super();
		this.n_num = n_num;
		this.n_title = n_title;
		this.n_content = n_content;
	}

	public int getN_num() {
		return n_num;
	}

	public void setN_num(int n_num) {
		this.n_num = n_num;
	}

	public String getN_title() {
		return n_title;
	}

	public void setN_title(String n_title) {
		this.n_title = n_title;
	}

	public String getN_content() {
		return n_content;
	}

	public void setN_content(String n_content) {
		this.n_content = n_content;
	}
	
}
