package com.example.todo.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("file-download")
@Controller
public class FileDownloadController {
	
	@RequestMapping(value = "/download-form", method = RequestMethod.GET)
	public String page() {
	    return "file/download_form";
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public String download() {
	    return "textFileDownloadView";
	}
	
}
