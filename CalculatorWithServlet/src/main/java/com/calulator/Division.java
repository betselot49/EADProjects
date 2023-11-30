package com.calulator;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Division extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Division() {
		super();

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int number1 = Integer.parseInt(req.getParameter("number1"));
		int number2 = Integer.parseInt(req.getParameter("number2"));
		int result = number1 / number2;

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html><head><title>CalculatorWithServlet</title></head><body>");
		out.println("<h2>Multiplication result: </h1>" + result);
		out.println("</body></html>");

	}

}
