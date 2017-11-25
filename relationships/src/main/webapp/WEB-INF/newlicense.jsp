<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="base.jsp"%>
<body>
<div class="container">
    <h1>New License</h1>

    <form:form action="/licenses" method="POST" modelAttribute="license">
        <p>
            <form:label path="person">Person:</form:label>
            <form:select path="person">
                <c:forEach items="${persons}" var="person">
                    <form:option value="${person}" label="${person.firstName}  ${person.lastName}" />
                </c:forEach>
            </form:select>
        </p>
        <p>
            <form:label path="state">State:</form:label>
            <form:input type="text" path="state" />
        </p>
        <p>
            <form:label path="expirationDate">Expiration Date:</form:label>
            <form:input type="date" path="expirationDate" />
        </p>
        <input type="submit" value="Create"/>
    </form:form>

</div>
</body>
</html>