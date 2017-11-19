
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
    <table class="table table-stripped">
        <thead>
            <tr>
                <th>Name</th>
                <th>Creator</th>
                <th>Version</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach
            <tr>
                <td></td>
            </tr>
        </tbody>
    </table>


        <form action="" method="">
            <div class="form-group row">
                <label for="name" class="col-sm-2 col-form-label col-form-label-lg">Name:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control form-control-lg" id="name" name="name" >
                </div>
            </div>
            <div class="form-group row">
                <label for="creator" class="col-sm-2 col-form-label col-form-label-lg">Creator:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control form-control-lg" id="creator" name="creator" >
                </div>
            </div>
            <div class="form-group row">
                <label for="version" class="col-sm-2 col-form-label col-form-label-lg">Version:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control form-control-lg" id="version" name="version" >
                </div>
            </div>

            <input type="submit" class="btn btn-success" value="Submit">
        </form>

</div>
</body>
</html>