
<%@include file="base.jsp" %>

<body>
<body>
<h1>Welcome to the Admin Page <c:out value="${currentUser.username}"></c:out></h1>

<form id="logoutForm" method="POST" action="/logout">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Logout!" />
</form>
</body>

</body>
</html>