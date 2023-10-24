package com.controllers;
import java.io.IOException;

import java.io.PrintWriter;

import com.dao.AdimDao;
import com.dao.AdimDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ChangePassword() {
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
	
		AdimDao dao = new AdimDaoImpl();
		dao.updateAdminPassword(email, password);
		
		request.getRequestDispatcher("login.jsp").include(request, response);
		out.print("<header style='color:green; margin-left:7%'> Password updated successfully! </header>");
	}

}

