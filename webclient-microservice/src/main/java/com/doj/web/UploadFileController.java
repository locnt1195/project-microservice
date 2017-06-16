package com.doj.web;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

@Controller
public class UploadFileController {
    //List<String> files = new ArrayList<String>();
    
    @Autowired
    UploadFileRepository uploadFileRepository;
        
    @GetMapping("/upload")
    public String index(Model model) {
        return "uploadFile";
    }
    
    @PostMapping("/uploadFile")
    public String handleFileUpload(
    		@RequestParam("file") MultipartFile file,
    		@RequestParam("type") String type,
    		@RequestParam("author") String author, 
    		Model model) {
    	boolean uploadResult = uploadFileRepository.store(file,type,author);
    	
    	if(uploadResult)
    		model.addAttribute("message", "You successfully uploaded " + file.getName() + "!");
    	else 
    		 model.addAttribute("message", "FAIL to upload " + file.getName() + "!");
    	
        return "uploadFile";
    }
}
