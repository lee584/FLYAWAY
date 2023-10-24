package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FlightDetailsDao;
import com.dao.FlightDetailsDaoImpl;
import com.dto.FlightDetails;

import jakarta.servlet.http.HttpServlet;

	public class AddFlight extends HttpServlet {
		private static final long serialVersionUID = 1L;

	    public AddFlight() {};

		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				
				String flightNumber = request.getParameter("flightNumber");
				String airline = request.getParameter("airline");
				String source = request.getParameter("source");
				String destination = request.getParameter("destination");
				String time = request.getParameter("time");
				String price = request.getParameter("price");
				
				FlightDetails flight = new FlightDetails(flightNumber, airline, source, destination, time, price);
				FlightDetailsDao dao = new FlightDetailsDaoImpl();
				Integer flightId = dao.addFlight(flight);
				
				if(flightId != null)
				{
					request.getRequestDispatcher("dashboard.jsp").include(request, response);
					out.print("<script> window.alert('Flight Details added successfully!')</script>");
				}
		}
	}



