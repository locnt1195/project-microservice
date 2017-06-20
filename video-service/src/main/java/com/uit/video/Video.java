package com.uit.video;

import java.io.Serializable;

public class Video implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public String link;
	public String type;
	public String author;
	public int views;
	
	public Video(String name,String link,String type,String author,int views){
		super();
		this.name = name;
		this.link = link;
		this.type = type;
		this.author = author;
		this.views = views;
	}
	
	@Override
	public String toString() {
		return "Video [name=" + name + ", link=" + link + ", type=" + type + ", author=" + author + ",views=" + views + "]";
	}
}
