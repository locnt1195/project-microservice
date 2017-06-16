package com.doj.web;

import java.util.List;

public interface VideoRepository {
	List<Video> getAllVideos();
	
	Video searchByName(String name);
}
