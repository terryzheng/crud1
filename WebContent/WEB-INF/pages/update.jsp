<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<%@ page import="com.crud.database.UserModel"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"   
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>用户信息</title>
</head>
<body>
	<%
		UserModel um = (UserModel) request.getAttribute("user");
	%>

	<form action="/users/User_update.action" method="post">
		姓名： <input name="um.name" value="<%=um.getName()%>" /> 性别： <select
			name="um.sex" />
		<option value="1" <%if(um.getSex()==1)
				out.print("selected");%>>男</option>
		<option value="0" <%if(um.getSex()==0)
				out.print("selected");%>>女</option>
		</select> 年龄： <input name="um.age" value="<%=um.getAge()%>" /> <input
			type="hidden" name="um.userId" value="<%=um.getUserId()%>" /> <input
			type="submit" value="提交">
	</form>
</body>
</html>