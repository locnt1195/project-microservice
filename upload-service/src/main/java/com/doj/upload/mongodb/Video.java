package com.doj.upload.mongodb;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Video")
public class Video {
	/**
	 * 
	 */
	@Id
	public String id;
	public String name;
	public String link;
	public String type;
	public String author;
	public int views;
	
	public Video(String name,String link,String type,String author,int views){
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
