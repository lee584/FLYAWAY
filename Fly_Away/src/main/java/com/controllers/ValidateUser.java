package com.controllers;
import java.io.IOException;

import java.io.PrintWriter;

import com.dao.AdimDao;
import com.dao.AdimDaoImpl;
import com.dto.Admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ValidateUser() {
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Admin admin = new Admin(email, password);
		AdimDao dao = new AdimDaoImpl();
		
		boolean isAdminValid = dao.validateAdmin(admin);
		
		if(isAdminValid)
		{
			HttpSession session = request.getSession();
			session.setAttribute("email", admin.getEmail());
			session.setAttribute("password", admin.getPassword());
			response.sendRedirect("dashboard.jsp");
		} else {
			request.getRequestDispatcher("login.jsp").include(request, response);
			out.print("<header style='color:red; margin-left:7%'> Invalid email or password! </header>");
		}
	}

}

