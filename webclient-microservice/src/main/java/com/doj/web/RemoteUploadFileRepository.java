package com.doj.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

public class RemoteUploadFileRepository implements UploadFileRepository{

	protected Logger logger = Logger
			.getLogger(RemoteUploadFileRepository.class.getName());
	
	@Autowired
	protected RestTemplate restTemplate;
	
	protected String serviceUrl;
	
	public RemoteUploadFileRepository(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}
	
	@Override
	public boolean store(MultipartFile file,String type,String author) {
		FormHttpMessageConverter converter = new FormHttpMessageConverter();
		converter.setCharset(Charset.forName("UTF8"));
		restTemplate.getMessageConverters().add(converter);
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
		
		HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.parseMediaType("application/json")));
        httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);  
        
        LinkedMultiValueMap<String, Object> vars = new LinkedMultiValueMap<String, Object>();
        
        File currentFile = null;
        
        try {
	        String tempFileName = file.getOriginalFilename();
	        currentFile = new File(tempFileName);
	        FileOutputStream fo = new FileOutputStream(currentFile);
	        fo.write(file.getBytes());
	        fo.close();
	        vars.add("file", new FileSystemResource(tempFileName));
        }catch (IOException e) {
            e.printStackTrace();
        }   
        vars.add("type", type);
        vars.add("author", author);
        
        HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(vars, httpHeaders);
        boolean uploadResource = restTemplate.postForObject(serviceUrl+"/uploadFile", requestEntity, boolean.class); 
        
        if(currentFile != null)
        	currentFile.delete();
        
		return uploadResource;
	}

}
