package com.employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/Employee")
public class Employee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String designation;
    private double salary;

    public Employee() {
        super();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection conn = DBManager.getConnection()) {
            String selectQuery = "SELECT * FROM employees";
            try (PreparedStatement preparedStatement = conn.prepareStatement(selectQuery)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    List<Employee> employees = new ArrayList<>();

                    while (resultSet.next()) {
                        Employee employee = new Employee();
                        employee.setId(resultSet.getInt("id"));
                        employee.setName(resultSet.getString("name"));
                        employee.setDesignation(resultSet.getString("designation"));
                        employee.setSalary(resultSet.getInt("salary"));

                        employees.add(employee);
                    }

                    StringBuilder jsonBuilder = new StringBuilder();
                    jsonBuilder.append("[");
                    for (int i = 0; i < employees.size(); i++) {
                        Employee employee = employees.get(i);
                        jsonBuilder.append("{");
                        jsonBuilder.append("\"id\":").append(employee.getId()).append(",");
                        jsonBuilder.append("\"name\":\"").append(employee.getName()).append("\",");
                        jsonBuilder.append("\"designation\":\"").append(employee.getDesignation()).append("\",");
                        jsonBuilder.append("\"salary\":").append(employee.getSalary());
                        jsonBuilder.append("}");
                        if (i < employees.size() - 1) {
                            jsonBuilder.append(",");
                        }
                    }
                    jsonBuilder.append("]");

                    response.setContentType("application/json");

                    PrintWriter out = response.getWriter();
                    out.print(jsonBuilder.toString());
                    out.flush();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error fetching employees");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           String firstName = request.getParameter("name");
           String designation = request.getParameter("designation");
           double salaryParameter = Double.parseDouble(request.getParameter("salary"));

          
           try (Connection conn = DBManager.getConnection()) {
               String insertQuery = "INSERT INTO employees (name, designation, salary) VALUES (?, ?, ?)";
               try (PreparedStatement preparedStatement = conn.prepareStatement(insertQuery)) {
                   preparedStatement.setString(1, firstName);
                   preparedStatement.setString(2, designation);
                   preparedStatement.setDouble(3, salaryParameter);

                   int rowsAffected = preparedStatement.executeUpdate();

                   if (rowsAffected > 0) {
                	   response.setContentType("text/html"); 
                       PrintWriter out = response.getWriter(); 
                       out.println("<html><head><title>Employee Registration</title></head><body>"); 
                       out.println("<h2>Employee registered successfully!</h2>"); 
                       out.println("<p>Redirecting to <a href='index.html'>Employees</a></p>"); 
                       out.println("<script>setTimeout(function() { window.location.href = 'index.html'; }, 3000);</script>"); 
                       out.println("</body></html>");
                   } else {
                       response.getWriter().println("<h2>Failed to insert employee record</h2>");
                   }
               }
           } catch (SQLException e) {
               e.printStackTrace();
               response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error inserting employee");
           }
          
       }

	

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int id = Integer.parseInt(request.getParameter("id"));
	    String newDepartment = request.getParameter("newDepartment");
	    int newSalary = Integer.parseInt(request.getParameter("newSalary"));

	    try (Connection conn = DBManager.getConnection()) {
	        String updateQuery = "UPDATE employees SET department = ?, salary = ? WHERE id = ?";
	        try (PreparedStatement preparedStatement = conn.prepareStatement(updateQuery)) {
	            preparedStatement.setString(1, newDepartment);
	            preparedStatement.setInt(2, newSalary);
	            preparedStatement.setInt(3, id);

	            int rowsAffected = preparedStatement.executeUpdate();

	            if (rowsAffected > 0) {
	                response.getWriter().println("Employee record updated successfully");
	            } else {
	                response.getWriter().println("Failed to update employee record");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int id = Integer.parseInt(request.getParameter("id"));

	    try (Connection conn = DBManager.getConnection()) {
	        String deleteQuery = "DELETE FROM employees WHERE id = ?";
	        try (PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery)) {
	            preparedStatement.setInt(1, id);

	            int rowsAffected = preparedStatement.executeUpdate();

	            if (rowsAffected > 0) {
	                response.getWriter().println("Employee record deleted successfully");
	            } else {
	                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Employee not found");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error deleting employee record");
	    }
	}



}
