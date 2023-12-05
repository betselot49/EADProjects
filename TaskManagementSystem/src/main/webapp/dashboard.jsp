<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.taskmanager.Task"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Task Dashboard</title>
<link rel="stylesheet" href="css/bootstrap.css">
<style>
.high-priority {
	color: red;
}

.medium-priority {
	color: orange;
}

.low-priority {
	color: green;
}
</style>
</head>
<body class="bg-light">

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand"
				href="/TaskManagementSystem/dashboard?userId=<%=session.getAttribute("userId")%>">Task
				Manager</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link"
						href="/TaskManagementSystem/dashboard?userId=<%=session.getAttribute("userId")%>">Dashboard</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="/TaskManagementSystem/addTask.jsp">Add Task</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/TaskManagementSystem/User.jsp">Profile</a></li>
				</ul>
				<form class="form-inline ml-auto" action="dashboard">
					<div class="form-group mr-2">
						<input type="hidden" id="userId" name="userId"
							value="<%=session.getAttribute("userId")%>">
					</div>
					<div class="form-group mr-2">
						<input type="text" class="form-control" name="searchText"
							placeholder="Search">
					</div>
					<button type="submit" class="btn btn-primary">Search</button>
				</form>
				<form action="user" method="get">
					<button type="submit" class="btn btn-primary ml-4">Logout</button>
				</form>
			</div>
		</div>
	</nav>

	<div class="container mt-5">
		<h2>Task Dashboard</h2>

		<%
		String userName = (String) session.getAttribute("userName");
		int userId = (int) session.getAttribute("userId");
		if (userName != null) {
		%>
		<div class="alert alert-info mt-3">
			Hello,
			<%=userName%>!
		</div>
		<%
		}

		List<Task> tasks = (List<Task>) request.getAttribute("tasks");
		if (tasks == null || tasks.isEmpty()) {
		%>
		<div class="alert alert-info mt-3">No tasks available</div>
		<%
		} else {
		%>
		<table class="table table-bordered mt-3">
			<thead>
				<tr>
					<th>Role Number</th>
					<th>Task Title</th>
					<th>Description</th>
					<th>Due Date</th>
					<th>Priority</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<%
				int roleNumber = 1;
				for (Task task : tasks) {
					String priorityClass;
					switch (task.getPriority()) {
					case "High":
						priorityClass = "high-priority";
						break;
					case "Medium":
						priorityClass = "medium-priority";
						break;
					case "Low":
						priorityClass = "low-priority";
						break;
					default:
						priorityClass = "";
					}
				%>
				<tr>
					<td><%=roleNumber++%></td>
					<td><%=task.getTaskTitle()%></td>
					<td><%=task.getDescription()%></td>
					<td><%=task.getDueDate()%></td>
					<td class="<%=priorityClass%>"><%=task.getPriority()%></td>
					<td><a
						href="task?id=<%=task.getId()%>&opr=edit&username=<%=request.getParameter("username")%>&userId=<%=userId%>"
						class="btn btn-warning btn-sm">Edit</a> <a
						href="task?id=<%=task.getId()%>&opr=delete&username=<%=request.getParameter("username")%>&userId=<%=userId%>"
						class="btn btn-danger btn-sm"
						onclick="return confirm('Are you sure you want to delete this task?')">Delete</a>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<%
		}
		%>
		<a href="addTask.jsp" class="btn btn-primary mt-3">Add Task</a>
	</div>

	<!-- Bootstrap JS and Popper.js (if needed) -->
	<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>