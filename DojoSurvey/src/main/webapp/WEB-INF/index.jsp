
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
    <h1>Dojo Survey</h1>
    <form style="width: 600px;">
        <div class="form-group">
            <label>Your Name:</label>
            <input type="email" class="form-control" name="name">
        </div>
        <div class="form-group">
            <label>Dojo Location:</label>
            <select class="form-control" name="dojolocation">
                <option selected disabled></option>
                <option value="java">Java</option>
                <option value="python">Python</option>
                <option value="mean">MEAN</option>
            </select>
        </div>
        <div class="form-group">
            <label>Favourite Language:</label>
            <select class="form-control" name="favouriteLang">
                <option selected disabled></option>
                <option value="online">Online</option>
                <option value="washington">Washington</option>
                <option value="california">California</option>
            </select>
        </div>

        <div class="form-group">
            <label>Comment (Optional):</label>
            <textarea class="form-control" name="comment"></textarea>
        </div>

        <button class="btn btn-success">Submit</button>
    </form>

</div>
</body>
</html>