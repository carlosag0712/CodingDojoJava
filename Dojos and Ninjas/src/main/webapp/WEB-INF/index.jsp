<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="base.jsp" %>
<body>
    <div class="container" style="margin-top: 100px;">
        <h1>New Dojo</h1>
        <form:form action="/dojos" method="POST" modelAttribute="dojo">
            <p>
                <form:label path="name">Name: </form:label>
                <form:input type="text" path="name"></form:input>
            </p>

            <input type="submit" value="Create">

        </form:form>
    </div>
</body>
</html>