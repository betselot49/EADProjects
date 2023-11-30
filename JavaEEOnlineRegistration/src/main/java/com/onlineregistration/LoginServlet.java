package com.onlineregistration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		try {
			Connection conn = DBManager.getConnection();
			String query = "SELECT * FROM users WHERE email = ? AND password = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				// Authentication successful
				conn.close();
				res.sendRedirect("welcome.jsp");
			} else {
				// Authentication failed
				conn.close();
				res.sendRedirect("login.jsp");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
