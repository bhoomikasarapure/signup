package controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.UserInfo;

@WebServlet("/Login")
public class Login extends HttpServlet {

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	String emph=req.getParameter("emph");
	String password=req.getParameter("pwd");
	
	UserDao dao=new UserDao();
	List<UserInfo> list=dao.fetchAll();
	
	try{
		
	long mobile=Long.parseLong(emph);
	UserInfo info =dao.fetch(mobile);
	if(info==null)
	{
		res.getWriter().print("<h1 style='color:red'>Invalid Mobile Number</h1>");
		req.getRequestDispatcher("login.html").include(req,res);
	}
	else
	{
		if(info.getPassword().equals(password))
		{
			res.getWriter().print("<h1 style='color:green'>Login Success</h1>");
			req.setAttribute("list", list);
			req.getRequestDispatcher("Home.jsp").include(req, res);
		
//			res.getWriter().print("<h1 style='color:green'>Login Success</h1>");
//			res.getWriter().print("<table border='1'>");
//			res.getWriter().print("<tr>");
//			res.getWriter().print("<th>id</th>");
//			res.getWriter().print("<th>name</th>");
//			res.getWriter().print("<th>mobile</th>");
//			res.getWriter().print("<th>email</th>");
//			res.getWriter().print("<th>country</th>");
//			res.getWriter().print("<th>age</th>");
//			res.getWriter().print("<th>skills</th>");
//			res.getWriter().print("<th>password</th>");
//			res.getWriter().print("<th>gender</th>");
//			res.getWriter().print("<th>date</th>");
//			res.getWriter().print("</tr>");
//			
//			for(UserInfo info2:list)
//			{
//				res.getWriter().print("<tr>");
//				res.getWriter().print("<th>"+info2.getId()+"</th>");
//				res.getWriter().print("<th>"+info2.getMobile()+"</th>");
//				res.getWriter().print("<th>"+info2.getAddress()+"</th>");
//				res.getWriter().print("<th>"+info2.getAge()+"</th>");
//				res.getWriter().print("<th>"+info2.getCountry()+"</th>");
//				res.getWriter().print("<th>"+info2.getEmail()+"</th>");
//				res.getWriter().print("<th>"+info2.getName()+"</th>");
//				res.getWriter().print("<th>"+info2.getPassword()+"</th>");
//				res.getWriter().print("<th>"+info2.getDate()+"</th>");
//				res.getWriter().print("<th>"+Arrays.toString(info2.getSkills())+"</th>");
//				res.getWriter().print("</tr>");
//			}
//			res.getWriter().print("</table>");
//			
//			
//			
		}
		else
		{
			res.getWriter().print("<h1 style='color:red'>Invalid password</h1>");
		}
	
	}
	}
	
	catch(NumberFormatException e)
	{
		String email=emph;
	
	
	UserInfo info =dao.fetch(email);
	if(info==null)
	{
		res.getWriter().print("<h1 style='color:red'>Invalid Email</h1>");
		req.getRequestDispatcher("login.html").include(req,res);
	}
	else
	{
		if(info.getPassword().equals(password))
		{
			res.getWriter().print("<h1 style='color:green'>Login Success</h1>");
			req.setAttribute("list", list);
			req.getRequestDispatcher("Home.jsp").include(req, res);
		}
		else
		{
			res.getWriter().print("<h1 style='color:red'>Invalid password</h1>");
		}
	}
}
}
}

