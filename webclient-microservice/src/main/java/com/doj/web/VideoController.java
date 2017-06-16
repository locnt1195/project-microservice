package com.doj.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VideoController {

	@Autowired
	VideoRepository videoRepository;
	
	@GetMapping("/videos")
    public String index(Model model) {
        return "videos";
    }
	
	@RequestMapping(value = "/getAllVideos", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public @ResponseBody String getAllVideos() {
		String response = null;
		List<Video> videos = videoRepository.getAllVideos();
		response = JsonUtil.toJson(videos);
		return response;
	}
	
}
