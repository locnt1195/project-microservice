package com.doj.upload;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFileRepository {
	public boolean store(MultipartFile file);
}
