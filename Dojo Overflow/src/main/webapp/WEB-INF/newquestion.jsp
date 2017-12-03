<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="base.jsp" %>
<body>
    <div class="container" style="margin-top: 100px;">
        <h1>What is your Question?</h1>

        <p style="color: red">${errors}</p>

        <form action="post" method="POST" modelAttribute="questionAttr">
            <p>
                <label for="">Question:</label>
                <input type="text" name="question" style="width: 600px;height: 50px;">
            </p>

            <p>
                <label for="">Tags:</label>
                <input type="text" name="tags">
            </p>

            <input type="submit" class="btn btn-primary" value="Submit">


        </form>
    </div>
</body>
</html>