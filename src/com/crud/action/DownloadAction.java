package com.crud.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport {
	public String getContentDisposition() throws UnsupportedEncodingException {
		String s = new String("≤‚ ‘".getBytes(), "ISO8859-1");
		return "attachment;filename=\"" + s + ".bmp\"";
	}

	public InputStream getInputStream() {
		File file = new File("e:/123.bmp");
		try {
			return new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}
