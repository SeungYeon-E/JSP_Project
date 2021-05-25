package com.jspproject.bbs.dto;

public class NoticeDto {
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
	


	

}//---------------------------
