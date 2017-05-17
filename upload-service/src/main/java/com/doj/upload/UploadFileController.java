package com.doj.upload;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

@RestController
public class UploadFileController {
	@Autowired
    UploadFileRepository uploadFileRepository;
 
    List<String> files = new ArrayList<String>();
    
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public @ResponseBody boolean uploadFile(@RequestParam(value="file") MultipartFile file) {
    	//MultipartFile upFile = file.get("file");
        boolean uploadResult = uploadFileRepository.store(file);
        return uploadResult;
    }
 
    @GetMapping("/uploadFileList")
    public List<File> getListFiles(Model model) {
    	return uploadFileRepository.getAllFiles();
    }
}
