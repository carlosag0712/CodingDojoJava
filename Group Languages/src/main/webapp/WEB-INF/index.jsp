
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
    <table class="table table-stripped" style="margin-top: 50px;">
        <thead>
            <tr>
                <th>Name</th>
                <th>Creator</th>
                <th>Version</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="lang" varStatus="loop" items="${languages}">
            <tr>
                <td><a href="/languages/${lang.id}">${lang.name}</a></td>
                <td>${lang.creator}</td>
                <td>${lang.version}</td>
                <td>
                    <a href="/languages/delete/${lang.id}" style="text-decoration: underline">delete</a>
                    <a href="/languages/edit/${lang.id}" style="text-decoration: underline; margin-left:5px;">edit</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <p style="color: red"><form:errors path="language.*"/></p>

        <div class="form-container">
            <form:form action="/languages" method="POST" modelAttribute="language">
                <p>
                    <form:label path="name" for="name">Name</form:label>
                    <form:input path="name" class="input-size float" type="text" name="creator"></form:input>
                </p>
                <p>
                    <form:label path="creator" for="creator">Creator</form:label>
                    <form:input path="creator" class="input-size float" type="text" name="name"></form:input>
                </p>
                <p>
                    <form:label path="version" for="version">Version</form:label>
                    <form:input path="version" class="input-size float" type="text" name="version"></form:input>
                </p>

                <input type="submit" class="float" value="Submit"/>

            </form:form>
        </div>

</div>
</body>
</html>