package com.example.todo.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.terasoluna.gfw.web.download.AbstractFileDownloadView;

@Component
public class TextFileDownloadView extends AbstractFileDownloadView {

	@Override
	protected InputStream getInputStream(Map<String, Object> model, HttpServletRequest request) throws IOException {
		return new FileInputStream("C:\\home\\developer\\workspace\\download.txt");
	}

	@Override
	protected void addResponseHeader(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setHeader("Content-Disposition", "attachment; filename=download.txt");
		response.setContentType("text/plain");

	}

}
