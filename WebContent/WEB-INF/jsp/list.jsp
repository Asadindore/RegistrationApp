<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center"> 
 <table border="1">
 
            <th>UserId</th>
            <th>User Name</th>
            <th>User Salary</th>
            <th>Password</th>
            <th>Action</th>

	<c:forEach var="userlist" items="${listUser}">

	<tr>

		<td>${userlist.user_id }</td>
		<td>${userlist.user_name }</td>
		<td>${userlist.user_sal }</td>
		<td>${userlist.password }</td>
		<td><a href="editDetails?user_id=${userlist.user_id}">edit</a></td>
		<td><a href="deleteDetails?user_id=${userlist.user_id}">delete</a></td>
		

	</tr>


	</c:forEach>
 </table>
</div>
</body>
</html>