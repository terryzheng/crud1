<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"   
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title><s:text name="list.title" />
</title>
</head>
<body>
	<form action="/users/User_create.action" method="post"
		enctype="multipart/form-data">
		<s:text name="user.name" />
		： <input name="um.name" />
		<s:text name="user.sex" />
		： <select name="um.sex">
			<option value="1">
				<s:text name="male" />
			</option>
			<option value="0">
				<s:text name="female" />
			</option>
		</select>
		<s:text name="user.age" />
		： <input name="um.age" /> 头像： <input type="file" name="myFile" />
		<s:submit name="" key="add.submit" />
		<a href="/aaa/downloadAction.action">下载文件</a>
	</form>
</body>
</html>