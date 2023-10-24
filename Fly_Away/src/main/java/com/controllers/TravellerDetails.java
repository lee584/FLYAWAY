package com.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TravellerDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TravellerDetails() {
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String pname = request.getParameter("pname");
			String pemail = request.getParameter("pemail");
			String phone = request.getParameter("phone");
			
			HttpSession session = request.getSession();
			session.setAttribute("pname", pname);
			session.setAttribute("pemail", pemail);
			session.setAttribute("phone", phone);
			
			response.sendRedirect("checkout.jsp");
	}

}

