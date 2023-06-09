package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.UserInfo;

@WebServlet("/delete")

public class Delete extends HttpServlet  {
@Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	UserDao dao=new UserDao();
	UserInfo info=dao.fetch(id);
	dao.delete(info);
	
	
	req.setAttribute("list", dao.fetchAll());
	res.getWriter().print("<h1>data is deleted succesfully</h1>");
	req.getRequestDispatcher("Home.jsp").include(req, res);
	
}
}
