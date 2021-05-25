package com.jspproject.bbs.dto;

public class TipDto {
	int t_num;
	String t_title;
	String t_content;
	String t_image;
	String t_category;
	
	public TipDto(int t_num, String t_title, String t_content, String t_image, String t_category) {
		super();
		this.t_num = t_num;
		this.t_title = t_title;
		this.t_content = t_content;
		this.t_image = t_image;
		this.t_category = t_category;
	}

	public int getT_num() {
		return t_num;
	}

	public void setT_num(int t_num) {
		this.t_num = t_num;
	}

	public String getT_title() {
		return t_title;
	}

	public void setT_title(String t_title) {
		this.t_title = t_title;
	}

	public String getT_content() {
		return t_content;
	}

	public void setT_content(String t_content) {
		this.t_content = t_content;
	}

	public String getT_image() {
		return t_image;
	}

	public void setT_image(String t_image) {
		this.t_image = t_image;
	}

	public String getT_category() {
		return t_category;
	}

	public void setT_category(String t_category) {
		this.t_category = t_category;
	}
	
	

}//----------------
