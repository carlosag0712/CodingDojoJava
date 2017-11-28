<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="base.jsp" %>
<body>
    <div class="container" style="margin-top: 100px;">
        <h1 style="margin-bottom: 30px;">New Category</h1>
        <form:form action="/categories" method="POST" modelAttribute="category">
            <p>
                <form:label path="name">Category: </form:label>
                <form:input path="name"></form:input>
            </p>

            <input type="submit" value="Create">

        </form:form>

    </div>
</body>
</html>