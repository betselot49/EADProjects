package com.employee;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/EditEmployee")
public class EditEmployee extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("id"));

        try (Connection conn = DBManager.getConnection()) {
            String selectQuery = "SELECT * FROM employees WHERE id = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(selectQuery)) {
                preparedStatement.setInt(1, employeeId);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String designation = resultSet.getString("designation");
                    double salary = resultSet.getDouble("salary");

                    response.getWriter().println("Employee Details: " + name + ", " + designation + ", " + salary);
                } else {
                    response.getWriter().println("Employee not found");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error getting employee details");
        }
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        String firstName = request.getParameter("name");
        String designation = request.getParameter("designation");
        double salaryParameter = Double.parseDouble(request.getParameter("salary"));

        try (Connection conn = DBManager.getConnection()) {
            String updateQuery = "UPDATE employees SET name=?, designation=?, salary=? WHERE id=?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(updateQuery)) {
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, designation);
                preparedStatement.setDouble(3, salaryParameter);
                preparedStatement.setInt(4, employeeId);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    response.getWriter().println("Employee updated successfully");
                } else {
                    response.getWriter().println("Failed to update employee record");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error updating employee");
        }
    }
}
