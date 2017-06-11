package com.doj.upload.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Video")
public class Video {
	@Id
	public String id;
	public String name;
	public String link;
	public String type;
	
	public Video(String name,String link,String type){
		this.name = name;
		this.link = link;
		this.type = type;
	}
}
