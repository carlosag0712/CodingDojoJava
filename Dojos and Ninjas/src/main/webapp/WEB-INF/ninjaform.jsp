<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="base.jsp" %>
<body>
<div class="container" style="margin-top: 100px;">
    <h1>New Ninja</h1>

    <form:form action="/ninjas" method="POST" modelAttribute="ninja">

        <p>
            <form:label path="dojo">Dojo: </form:label>
            <form:select path="dojo">
                <c:forEach items="${dojos}" var="dojo">
                    <form:option value="${dojo}" label="${dojo.name}"></form:option>

                </c:forEach>
            </form:select>
        </p>

        <p>
            <form:label path="firstName">First Name: </form:label>
            <form:input type="text" path="firstName"></form:input>
        </p>
        <p>
            <form:label path="lastName">Last Name: </form:label>
            <form:input type="text" path="lastName"></form:input>
        </p>
        <p>
            <form:label path="age">Age: </form:label>
            <form:input type="text" path="age" min="1" placeholder=""></form:input>
        </p>

        <input type="submit" value="Create">

    </form:form>
</div>
</body>
</html>