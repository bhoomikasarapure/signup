package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import net.bytebuddy.asm.Advice.Local;

@WebServlet("/signup")
public class Signup extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	

		Date date=Date.valueOf(req.getParameter("dob"));
		
		
//	String name=req.getParameter("name");
//	long mobile=Long.parseLong(req.getParameter("mob"));
//	String email=req.getParameter("email");
//	String password=req.getParameter("pwd");
//	Date date=Date.valueOf(req.getParameter("dob"));
//	String gender=req.getParameter("gender");
//	String address=req.getParameter("address");
//	String country=req.getParameter("country");
//	String[] skills=req.getParameterValues("skills");
	
  dto.UserInfo info=new dto.UserInfo();
	info.setCountry(req.getParameter("country"));
	info.setAddress(req.getParameter("address"));
	info.setDate(Date.valueOf(req.getParameter("dob")));
	info.setEmail(req.getParameter("email"));
	info.setGender(req.getParameter("gender"));
	info.setMobile(Long.parseLong(req.getParameter("mob")));
	info.setName(req.getParameter("name"));
	info.setPassword(req.getParameter("pwd"));
	info.setSkills(req.getParameterValues("skills"));
	info.setAge(Period.between(date.toLocalDate(), LocalDate.now()).getYears());
	
	
//	int yob=date.toLocalDate().getYear();
//	int ty=LocalDate.now().getYear();

	UserDao dao=new UserDao();
	dao.save(info);
	res.getWriter().print("<h1> account created successfully</h1>");

	req.getRequestDispatcher("login.html").include(req, res);
	
	}
}

