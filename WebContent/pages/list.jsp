<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.crud.model.User"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"   
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title><s:text name="user.list" />
</title>
</head>
<body>
	<%
		List<User> umlist = (List<User>) request
				.getAttribute("umlist");
	%>
	<table border="1" cellpadding="1" cellspacing="0" align="center">
		<tr>
			<td><s:text name="user.userId" />
			</td>
			<td><s:text name="user.name" />
			</td>
			<td><s:text name="user.sex" />
			</td>
			<td><s:text name="user.age" />
			</td>
			<td><s:text name="list.operation" />
			</td>
		</tr>
		<%
			if (umlist != null) {
				for (User um : umlist) {
		%>
		<tr>
			<td><%=um.getUserId()%></td>
			<td><%=um.getName()%></td>
			<td><%=um.getSexText()%></td>
			<td><%=um.getAge()%></td>
			<td><a href="/users/User_show.action?id=<%=um.getUserId()%>"><s:text
						name="list.update" />
			</a> <a href="/users/User_delete.action?id=<%=um.getUserId()%>"><s:text
						name="list.delete" />
			</a></td>
		</tr>
		<%
			}
			}
		%>
		<tr>
			<td><a href="/pages/new.jsp"><s:text name="list.add" />
			</a>
			</td>
		</tr>
	</table>

</body>
</html>