<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Add Task</title>
<link rel="stylesheet" href="css/bootstrap.css">
<style>
.form-group {
	margin-bottom: 1.5rem;
}
</style>
</head>
<body class="bg-light">

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="/TaskManagementSystem/dashboard?userId=<%=session.getAttribute("userId")%>">Task Manager</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link"
						href="/TaskManagementSystem/dashboard?userId=<%=session.getAttribute("userId")%>">Dashboard</a>
					</li>
					<li class="nav-item active"><a class="nav-link"
						href="/TaskManagementSystem/addTask.jsp">Add Task</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/TaskManagementSystem/User.jsp">Profile</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container mt-5" style="max-width: 650px">
		<h2>Add Task</h2>

		<form action="task" method="post">
			<div class="form-group">
				<label for="taskTitle">Task Title:</label> <input type="text"
					class="form-control" id="taskTitle" name="taskTitle" required
					placeholder="Enter task title">
			</div>
			<div class="form-group">
				<label for="description">Description:</label>
				<textarea class="form-control" id="description" name="description"
					placeholder="Enter task description"></textarea>
			</div>
			<div class="form-group">
				<label for="dueDate">Due Date:</label> <input type="date"
					class="form-control" id="dueDate" name="dueDate" required>
			</div>
			<div class="form-group">
				<label for="priority">Priority:</label> <select class="form-control"
					id="priority" name="priority" required>
					<option value="Low" disabled selected>Select Priority</option>
					<option value="High">High</option>
					<option value="Medium">Medium</option>
					<option value="Low">Low</option>
				</select>
			</div>
			<input type="hidden" name="username"
				value="<%=session.getAttribute("userName")%>"> <input
				type="hidden" name="userId"
				value="<%=session.getAttribute("userId")%>">
			<button type="submit" class="btn btn-primary">Add Task</button>
		</form>
	</div>

	<!-- Bootstrap JS and Popper.js (if needed) -->
	<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>