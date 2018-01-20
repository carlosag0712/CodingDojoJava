<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="base.jsp" %>
<body>
<div class="card">
    <div class="card-header">
        <h1>Register!</h1>
    </div>
    <div class="card-body">
        <p><form:errors path="user.*"/></p>
        <c:if test="${errorMessage != null}">
            <p><c:out value="${errorMessage}"></c:out></p>
        </c:if>

        <form:form method="POST" action="/registration" modelAttribute="user">
            <div class="form-group">
                <form:label path="firstName">First Name:</form:label>
                <form:input path="firstName" class="form-control"/>
            </div>
            <div class="form-group">
                <form:label path="lastName">Last Name:</form:label>
                <form:input path="lastName" class="form-control"/>
            </div>
            <div class="form-group">
                <form:label path="username">Email (Useranme):</form:label>
                <form:input path="username" class="form-control"/>
            </div>
            <div class="form-group">
                <form:label path="city">City:</form:label>
                <form:input path="city" class="form-control"/>
            </div>
            <div class="form-group">
                <form:label path="state">State:</form:label>
                <form:select path="state" class="form-control">
                    <c:forEach items="${stateList}" var="state">
                        <form:option value="${state}" label="${state}"></form:option>
                    </c:forEach>
                </form:select>
            </div>
            <div class="form-group">
                <form:label path="password">Password:</form:label>
                <form:password path="password" class="form-control"/>
            </div>
            <div class="form-group">
                <form:label path="passwordConfirmation">Password Confirmation:</form:label>
                <form:password path="passwordConfirmation" class="form-control"/>
            </div>
            <input type="submit" class="btn btn-primary" value="Register!"/>
        </form:form>
    </div>
</div>
</body>
</html>