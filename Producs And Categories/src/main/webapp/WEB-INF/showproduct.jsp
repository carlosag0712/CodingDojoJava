<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="base.jsp" %>
<body>
    <div class="container" style="margin-top: 100px;display: -webkit-inline-box;">



                <div class="row" style="display: block; margin-left: 200px;">
                    <h2>Categories</h2>
                    <h3><c:out value="${product.name}"></c:out></h3>
                    <ul>
                        <c:forEach var="cat" items="${prodCats}">
                            <li><c:out value="${cat.name}" /></li>
                        </c:forEach>
                    </ul>
                </div>


                <div class="row" style="display: block; margin-left: 200px;">
                    <form action="/products/addCategory" method="POST">
                        <label for="category"></label>
                        <select name="newCategory" id="" style="margin-bottom: 20px;">
                            <c:forEach items="${categories}" var="cat">
                                <option value="${cat.id}">${cat.name}</option>

                            </c:forEach>

                        </select><br>

                        <input type="hidden" name="product" value=${product.id}>
                        <input type="submit" class="btn btn-primary" value="Add">
                    </form>

                </div>
    </div>
</body>
</html>