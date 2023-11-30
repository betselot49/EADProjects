package com.calulator;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Calculator() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String calculationType = request.getParameter("operation");

		if ("addition".equals(calculationType)) {
			jakarta.servlet.RequestDispatcher dispacher = request.getRequestDispatcher("/addition");
			dispacher.forward(request, response);
		} else if ("subtraction".equals(calculationType)) {
			jakarta.servlet.RequestDispatcher dispacher = request.getRequestDispatcher("/subtraction");
			dispacher.forward(request, response);
		} else if ("multiplication".equals(calculationType)) {
			jakarta.servlet.RequestDispatcher dispacher = request.getRequestDispatcher("/multiplication");
			dispacher.forward(request, response);
		} else if ("division".equals(calculationType)) {
			jakarta.servlet.RequestDispatcher dispacher = request.getRequestDispatcher("/division");
			dispacher.forward(request, response);
		} else {
			response.getWriter().println("Invalid operation");
		}
	}

}
