<%@include file="base.jsp" %>
<body>
<div class="container" style="margin-top: 200px;">
    <a href="/">Back to Main Page</a>
    <h1 style="margin-bottom: 40px;">${question.question}</h1>
    <div id="tag" style="margin-bottom: 20px;">
        <h2>Tags:</h2>
        <div id="tag-buttons">
            <c:forEach var="tag" items="${question.tags}"><button><c:out value="${tag.subject}" /></button></c:forEach>
        </div>
    </div>



    <div class="row" style="display: -webkit-inline-box">
        <div class="col-xs-4">
            <table class="table table-stripped" style="width: 400px;">
                <thead>
                <tr>
                    <th>Answer</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${answers}" var="ans">
                <tr>
                    <td>${ans.answer}</td>
                </tr>
                </c:forEach>
                </tbody>

            </table>
        </div>
        <div class="col-xs-4" style="margin-left: 200px;">
            <p style="color: red">${errors}</p>

            <form action="newanswer" method="POST">
                <p>
                    <label for="">Answer:</label>
                    <input type="text" name="answer" style="width: 200px;height: 50px;">
                </p>

                <input type="hidden" name="questionId" value="${question.id}">

                <input type="submit" class="btn btn-primary" value="Submit" style="margin-left: 190px;">


            </form>
        </div>


    </div>

</div>

</body>
</html>