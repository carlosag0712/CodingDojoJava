<%@include file="base.jsp" %>
<body>
<div class="container" style="margin-top: 100px;">
    <h1 style="margin-bottom: 30px;"><c:out value="${dojo.name}"/> Location Ninjas</h1>

    <table class="table table-stripped">
        <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Age</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="ninja" items="${dojo.ninjas}">
                <tr>
                    <td><c:out value="${ninja.firstName}"></c:out></td>
                    <td><c:out value="${ninja.lastName}"></c:out></td>
                    <td><c:out value="${ninja.age}"></c:out></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>