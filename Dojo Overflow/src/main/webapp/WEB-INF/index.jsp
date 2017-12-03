<%@include file="base.jsp" %>
<body>
<div class="container" style="margin-top: 100px;">
    <h1>Questions Dashboard</h1>
    <table class="table table-stripped">
        <thead>
            <tr>
                <th>Question</th>
                <th>Tags</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${questions}" var="question">

            <tr>
                <td><a href="/questions/${question.id}">${question.question}</a></td>
                <td>
                    <c:forEach items="${question.tags}" var="tag">
                        <span style="color: white; background: royalblue; border-radius: 5px; padding: 5px;"> ${tag.subject}</span>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <hr>
    <h4 style="margin-left: 800px;text-decoration: underline"><a href="questions/new">New Question</a></h4>
</div>
</body>
</html>