<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.css">
    <meta charset="ISO-8859-1">
    <title>Welcome Page</title>
</head>
<body class="bg-light">

    <div class="container mt-5">
        <div class="card">
            <div class="card-header bg-primary text-white">
                <h1 class="display-4">Welcome, <%= session.getAttribute("userName") %></h1>
            </div>
            <div class="card-body">
                <p class="lead">Thank you for logging in. Enjoy your experience!</p>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and Popper.js (if needed) -->
    <script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>
