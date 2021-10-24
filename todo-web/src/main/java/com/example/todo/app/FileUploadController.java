package com.example.todo.app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("file-upload")
@Controller
public class FileUploadController {

	@ModelAttribute
	public FileUploadForm setFileUploadForm() {
		return new FileUploadForm();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String uploadForm() {
		return "file/upload_form";
	}
	
	/**
	 * ファイルアップロードサンプル
	 * 
	 * @param fileUploadForm
	 * @param result
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(@Validated FileUploadForm fileUploadForm, BindingResult result, RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "file/upload_form";
		}

		MultipartFile uploadFile = fileUploadForm.getFile();

		if (uploadFile.isEmpty()) {
			result.rejectValue(uploadFile.getName(), "e.xx.at.6003");
			return "file/upload_form";
		}

		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			inputStream = uploadFile.getInputStream();
			outputStream = new FileOutputStream(new File("C:\\home\\developer\\workspace\\after_upload.txt"));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					outputStream.flush();
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}

		return "redirect:/file-upload/complete";
	}

	@RequestMapping(value = "/complete", method = RequestMethod.GET)
	public String uploadComplete() {
		return "file/upload_complete";
	}

}
