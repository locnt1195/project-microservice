package com.uit.video;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoController {

	@Autowired
	VideoRepositoryImpl videoRepository;
	
	@RequestMapping("/getAllVideos")
	public Video[] getAllVideos(){
		List<Video> videos = videoRepository.getAllVideos();		
		return videos.toArray(new Video[videos.size()]);
	}
	
}
