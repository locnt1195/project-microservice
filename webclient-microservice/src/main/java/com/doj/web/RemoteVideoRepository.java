package com.doj.web;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class RemoteVideoRepository implements VideoRepository{

	protected Logger logger = Logger
			.getLogger(RemoteVideoRepository.class.getName());

	
	@Autowired
	protected RestTemplate restTemplate;
	
	protected String serviceUrl;
	
	public RemoteVideoRepository(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}
	
	@Override
	public List<Video> getAllVideos() {
		Video[] videos = restTemplate.getForObject(serviceUrl+"/getAllVideos", Video[].class);
		return Arrays.asList(videos);
	}

	@Override
	public Video searchByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
