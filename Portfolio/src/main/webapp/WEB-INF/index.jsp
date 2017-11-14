
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">
    <link href="jumbotron.css" rel="stylesheet">
</head>
<body>

 <div class="container">
    <div class="jumbotron" style="text-align: center">
        <div class="container">
            <h1 class="display-3">Hi, I'm Carlos Arosemena</h1>
            <p>Welcome to my portfolio</p>
        </div>
    </div>
 </div>

    <div class="container">
        <!-- Example row of columns -->
        <div class="row">
            <div class="col-md-6">
                <h2>About me</h2>
                <p>
                    Little bit of my background and what I do.

                </p>
                <p><a class="btn btn-secondary" href="/me" role="button">View details &raquo;</a></p>
            </div>
            <div class="col-md-6x">
                <h2>Projects</h2>
                <p>
                    Showcasing my projects
                </p>
                <p><a class="btn btn-secondary" href="/projects" role="button">View details &raquo;</a></p>
            </div>

        </div>

        <hr>

    </div> <!-- /container -->



</body>
</html>