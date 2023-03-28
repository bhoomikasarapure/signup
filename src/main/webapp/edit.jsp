<%@page import="dto.UserInfo"%>
<%@page import="dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
int id=Integer.parseInt(request.getParameter("id"));
UserDao dao=new UserDao();
UserInfo info=dao.fetch(id);
%>
<h1>Enter Your  updated details</h1>
<form action="Update" method="post">
<table>
<tr>
<th>Id:</th>
<td><input type="text" value="<%=info.getId() %>" readonly="readonly" name="id"></td>
</tr>
<tr>
<th>Name:</th>
<td><input type="text" value="<%=info.getName() %>" name="name"></td>
</tr>
<tr>
<th>Mobile:</th>
<td><input type="tel"value="<%=info.getMobile() %>" name="mob"></td>
</tr>
<tr>
<th>Email:</th>
<td><input type="email" value="<%=info.getEmail() %>"  name="email" required="required"></td>
</tr>
<tr>
<th>Password:</th>
<td><input type="password" value="<%=info.getPassword() %>"  name="pwd"></td>
</tr>
<tr>
<th>Date of Birth:</th>
<td><input type="date" value="<%=info.getDate() %>"  name="dob"></td>
</tr>

<tr>










</tr>
<tr>
<td><button type="reset">Cancel</button></td>
<td><button>Update</button></td>
</tr>
</table>
</form>
<br>
<a href="Signup.html">New?Click here to Signup</a>



</body>
</html>