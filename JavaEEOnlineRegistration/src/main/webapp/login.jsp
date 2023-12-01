<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Login</title>
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body class="bg-light">

    <div class="container mt-5">
        <div class="card">
            <div class="card-header bg-primary text-white">
                <h2 class="display-4">Login</h2>
            </div>
            <div class="card-body">
                <form action="login" method="post">
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input type="text" class="form-control" id="email" name="email" required>
                    </div>
                    <div class="form-group">
                        <label for="password">Password:</label>
                        <input type="password" class="form-control" id="password" name="password" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Login</button>
                </form>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and Popper.js (if needed) -->
    <script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>
