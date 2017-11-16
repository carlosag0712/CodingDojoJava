
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">
</head>
<body>
<div class="container" style="text-align: center; margin-top: 50px;">
    <h1>You have visited <a href="/">http://localhost:8080 </a><c:out value="${count}"/> Times</h1>
    <h1><a href="/">Test Another visit</a></h1>
    <h1><a href="/reset">Reset Counter</a></h1>

</div>
</body>
</html>