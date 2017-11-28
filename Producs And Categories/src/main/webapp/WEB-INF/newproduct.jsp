<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="base.jsp" %>
<body>
    <div class="container" style="margin-top: 100px;">
        <h1 style="margin-bottom: 30px;">New Product</h1>
        <form:form action="/products" method="POST" modelAttribute="product">
            <p>
                <form:label path="name">Name: </form:label>
                <form:input type="text" path="name"></form:input>
            </p>
            <p>
                <form:label path="description">Description: </form:label>
                <form:input type="text" path="description"></form:input>
            </p>
            <p>
                <form:label path="price">Price: </form:label>
                <form:input type="number" step="0.01" path="price"></form:input>
            </p>

            <input type="submit" value="Create">
        </form:form>
    </div>
</body>
</html>