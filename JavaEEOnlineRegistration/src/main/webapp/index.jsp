<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Registration Form</title>
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body class="bg-light">

    <%@ include file="header.jsp"%>

    <div class="container mt-5">
        <div class="card">
            <div class="card-header bg-primary text-white">
                <h2 class="display-4">Registration Form</h2>
            </div>
            <div class="card-body">
                <form action="register" method="post">
                    <div class="form-group">
                        <label for="name">Name:</label>
                        <input type="text" class="form-control" id="name" name="name" required>
                    </div>
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input type="text" class="form-control" id="email" name="email" required>
                    </div>
                    <div class="form-group">
                        <label for="password">Password:</label>
                        <input type="password" class="form-control" id="password" name="password" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Register</button>
                </form>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and Popper.js (if needed) -->
    <script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>
