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
import org.springframework.web.servlet.ModelAndView;

@RestController
public class VideoController {

	@Autowired
	IVideoDBRepository videoRepository;
	
	@RequestMapping("/getAllVideos")
	public VideoDB[] getAllVideos(){
		List<VideoDB> videos = videoRepository.findAll();		
		return videos.toArray(new VideoDB[videos.size()]);
	}
	
//	@RequestMapping(value = "/getAllVideosByName", method = RequestMethod.POST)
//	public @ResponseBody Video[] getAllVideosByName(@RequestParam(value="name") String name){
//		List<Video> videos = videoRepository.getAllVideos().stream()
//				.filter(v -> v.name.toLowerCase().contains(name)).collect(Collectors.toList());
//		return videos.toArray(new Video[videos.size()]);
//	}
}
