<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="base.jsp" %>

<body>
    <div class="container" style="margin-top: 100px; display:  -webkit-inline-box;">
        <div class="row" style="margin-left: 200px;display: block;">
            <h1><c:out value="${category.name}"></c:out></h1>

            <p><h2>Producs in Catagory</h2>
            <ul>
                <c:forEach items="${ProdsInCat}" var="prods">
                    <li><c:out value="${prods.name}"></c:out></li>

                </c:forEach>
            </ul>
            </p>
        </div>

        <div class="row" style="margin-left: 200px;display:block;">

            <form action="/categories/addProduct" method="POST">
                <p>
                    <label for="">Add Product: </label>
                    <select name="productstobeadded" id="">
                        <c:forEach items="${products}" var="prods">
                        <option value="${prods.id}">${prods.name}</option>
                        </c:forEach>
                    </select>
                </p>

                <p>
                    <input type="hidden" name="categorytobeadded" value=${category.id}>
                    <input type="submit" class="btn btn-primary" value="Add Product"/>
                </p>
            </form>
        </div>
    </div>

</body>
</html>