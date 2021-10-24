package com.example.todo.app;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadForm implements Serializable {

	private MultipartFile file;
	
	public MultipartFile getFile() {
		return file;
	}
	
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
}
