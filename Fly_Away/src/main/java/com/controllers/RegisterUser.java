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



public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public RegisterUser() {
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Admin admin = new Admin(email, password);
		AdimDao dao = new AdimDaoImpl();
		
		Integer adminId = dao.addAdmin(admin);
		
		if(adminId != null)
			response.sendRedirect("login.jsp");	
	}
}

