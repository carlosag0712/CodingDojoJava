
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dojo Survey</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">
<head>
    <meta charset="UTF-8">
    <title>Dojo Survey</title>
</head>
<body>
<div class="container" style="margin-top: 50px; align-items: center;">
    <h1>Dojo Survey </h1>
    <h3>Submitted Info </h3>
    <p>Name: <c:out value="${name}"></c:out></p>
    <p>Dojo Location: <c:out value="${location}"></c:out></p>
    <p>Favourite Language: <c:out value="${language}"></c:out></p>
    <p>Comment: <c:out value="${comment}"></c:out></p>

</div>
</body>
</html>