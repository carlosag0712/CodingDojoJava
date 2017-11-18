
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Ninja Gold</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">
    <style>
        .col-xs-3{
            width: 200px;
            height: 200px;
            background: greenyellow;
            margin: 40px;
            text-align: center;
            padding: 40px;
            border-radius: 5px;
        }

        .yellow{
            width: 200px;
            height: 200px;
            background: yellow;
            margin: 40px;
            padding: 40px;
            border-radius: 5px;


        }

        .border{
            border: 1px solid black;
            padding: 10px;
            width: 100px;
            height: 100px;
        }
    </style>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <div class="container" style="margin-top: 50px;align-items: center">
        <div class="row">
            <p>Your Gold: <span class="border"><c:out value="${gold}"></c:out></span></p>
        </div>
        <div class="row">
            <h3><a href="/reset">Reset the gold counter</a></h3>
        </div>
        <div class="col-xs-3">
            <p><strong>Farm</strong></p>
            <p>(earns 10-20 gold)</p>
            <form action="/process" method="POST">
                <input type="hidden" name="building" value="farm">
                <input type="submit" value="Find Gold">
            </form>

        </div>
        <div class="col-xs-3">
            <p><strong>Cave</strong></p>
            <p>(earns 5-10 gold)</p>
            <form action="/process" method="POST">
                <input type="hidden" name="building" value="cave">
                <input type="submit" value="Find Gold">
            </form>

        </div>
        <div class="col-xs-3">
            <p><strong>House</strong></p>
            <p>(earns 2-5 gold)</p>
            <form action="/process" method="POST">
                <input type="hidden" name="building" value="house">
                <input type="submit" value="Find Gold">
            </form>

        </div>
        <div class="col-xs-3 yellow">
            <p><strong>Casino!</strong></p>
            <p>(earns/takes 0-50 gold)</p>
            <form action="/process" method="POST">
                <input type="hidden" name="building" value="casino">
                <input type="submit" value="Find Gold">
            </form>

        </div>

    </div>

    <div class="container">
        <h3>Activities: </h3>

        <div class="row" style="border: 1px solid green; height: 200px; width: 1150px;padding: 10px; border; overflow: scroll;border-radius: 5px;">

            <c:forEach var="msg" items="${messages}">
                <c:choose>
                    <c:when test="${msg.contains('lost')}">
                        <p style="color: red"><c:out value="${msg}"></c:out></p>
                    </c:when>
                    <c:otherwise>
                        <p style="color: green"><c:out value="${msg}"></c:out> </p>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
    </div>
</body>
</html>