package com.doj.web;

import java.util.List;

public interface VideoRepository {
	List<Video> getAllVideos();
	
	List<Video> getAllVideosByName(String name);
	
	Video searchByName(String name);
	
	
}
