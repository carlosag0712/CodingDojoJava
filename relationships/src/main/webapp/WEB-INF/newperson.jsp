<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="base.jsp"%>
<body>
    <div class="container">
        <h1>New Person</h1>
        <form:form action="/persons" method="POST" modelAttribute="person">
            <p>
                <form:label path="firstName">First Name</form:label>
                <form:input path="firstName" type="text" name="firstName"/>
            </p>
            <p>
                <form:label path="lastName">Last Name</form:label>
                <form:input path="lastName" type="text" name="lastName"/>
            </p>

            <input type="submit" value="Create">

        </form:form>
    </div>
</body>
</html>