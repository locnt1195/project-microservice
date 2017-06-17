package com.uit.video;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@RequestMapping(value = "/getAllVideosByName", method = RequestMethod.POST)
	public @ResponseBody Video[] getAllVideosByName(@RequestParam(value="name") String name){
		List<Video> videos = videoRepository.getAllVideos().stream()
				.filter(v -> v.name.toLowerCase().contains(name)).collect(Collectors.toList());
		return videos.toArray(new Video[videos.size()]);
	}
}
