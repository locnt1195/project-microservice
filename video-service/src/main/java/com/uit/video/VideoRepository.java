package com.uit.video;

import java.util.List;

public interface VideoRepository {
	List<Video> getAllVideos();
	
	Video searchByName(String name);
}
