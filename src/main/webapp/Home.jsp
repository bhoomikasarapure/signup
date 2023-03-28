<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="dto.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
<th>Id</th>
<th>Age</th>
<th>Country</th>
<th>Password</th>
<th>Name</th>
<th>Address</th>
<th>Mobile</th>
<th>Gender</th>
<th>Email</th>
<th>Date of Birth</th>
<th>Skills</th>
<th>Edit</th>
<th>Delete</th>
</tr>

<%List<UserInfo> list=(List<UserInfo>)request.getAttribute("list"); 
for(UserInfo info:list){%>
<tr>
<th><%=info.getId() %></th>
<th><%=info.getAge() %></th>
<th><%=info.getCountry() %></th>
<th><%=info.getPassword() %></th>
<th><%=info.getName() %></th>
<th><%=info.getAddress() %></th>
<th><%=info.getMobile() %></th>
<th><%=info.getGender() %></th>
<th><%=info.getEmail() %></th>
<th><%=info.getDate() %></th>
<th><%=Arrays.toString(info.getSkills()) %></th>
<th><a href="edit?id"=<%=info.getId() %>><button>Edit</button></a></th>
<th><a href="delete?id=<%=info.getId() %>"><button>Delete</button></a></th>
</tr>
<%}%>
</table>



</body>
</html>