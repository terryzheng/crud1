package com.crud.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.crud.dao.UserDao;
import com.crud.database.UserModel;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport implements ServletRequestAware {
	public UserModel um = new UserModel();
	public List<UserModel> umlist = new ArrayList<UserModel>();
	public File myFile;
	public String myFileFileName;
	public String myFileContentType;
	private HttpServletRequest request;

	public void validate() {
		if (um.getAge() > 150) {
			this.addFieldError("um.age", "xxxxxx");
		}
	}

	public String list() {
		UserDao ud = new UserDao();
		umlist = ud.queryUser("1=1");
		request.setAttribute("umlist", umlist);
		return "list";
	}

	public String show() {
		int id = Integer.valueOf(request.getParameter("id"));
		UserDao ud = new UserDao();
		um = ud.getUser(id);
		request.setAttribute("user", um);
		return "show";
	}

	public String create() {
		OutputStream os = null;
		InputStream is = null;
		try {
			byte[] bs = new byte[1024];
			os = new FileOutputStream("e:/" + myFileFileName);
			is = new FileInputStream(myFile);
			int length = 0;
			while ((length = is.read(bs)) > 0) {
				os.write(bs, 0, length);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(myFileFileName);
		System.out.println(myFileContentType);
		UserDao ud = new UserDao();
		try {
			Thread.sleep(6000L);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		Boolean result = ud.insertUser(um);
		System.out.println(result);
		return "tolist";
	}

	public String update() {
		UserDao ud = new UserDao();
		Boolean result = ud.updateUser(um);
		System.out.println(result);
		return "tolist";
	}

	public String delete() {
		int id = Integer.valueOf(request.getParameter("id"));
		UserDao ud = new UserDao();
		Boolean result = ud.deleteUser(id);
		System.out.println(result);
		return "tolist";
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}
