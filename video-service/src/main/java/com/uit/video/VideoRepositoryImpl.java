package com.uit.video;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VideoRepositoryImpl implements VideoRepository{

	@Autowired
	IVideoDBRepository videoDBRepository;
	
	@Override
	public List<Video> getAllVideos() {
		// TODO Auto-generated method stub
		List<VideoDB> videoDB = videoDBRepository.findAll();
		List<Video> videos = new ArrayList<Video>();
		
		for (VideoDB video : videoDB) {
			videos.add(new Video(video.name,video.link,video.type,video.author,video.views));
		}
		return videos;
	}

	@Override
	public Video searchByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
