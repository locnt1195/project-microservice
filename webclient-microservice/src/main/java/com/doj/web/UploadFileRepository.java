package com.doj.web;

import java.io.File;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface UploadFileRepository {
	public boolean store(MultipartFile file);
	 
    public List<File> getAllFiles();
     
    public void deleteAll();
 
    public void init();
}
