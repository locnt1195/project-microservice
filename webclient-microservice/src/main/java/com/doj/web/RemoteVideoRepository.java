package com.doj.web;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
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

	@Override
	public List<Video> getAllVideosByName(String name) {
		HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.parseMediaType("application/json")));
        httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);  
        
        LinkedMultiValueMap<String, Object> vars = new LinkedMultiValueMap<String, Object>();
		vars.add("name", name);
        
		HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(vars, httpHeaders);
		Video[] videos = restTemplate.postForObject(serviceUrl + "/getAllVideosByName", requestEntity, Video[].class); 
		return Arrays.asList(videos);
	}

}
