<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="base.jsp" %>
<body>


<form:form class="form-inline" action="/search" method="post" cssStyle="margin-left: 20px;margin-top: 100px; margin-bottom: 30px;">
    <div class="form-group mx-sm-3 mb-2">
        <label class="sr-only">Password</label>
        <input type="text" name="search" class="form-control" style="width: 400px;">
    </div>
    <button type="submit" class="btn btn-primary mb-2">Search <i class="fa fa-search" aria-hidden="true"></i></button>
</form:form>

<table class="table table-hover" style="width: 800px; margin-left: 30px;">
    <thead>
    <tr>
        <th scope="col">Address</th>
        <th scope="col">Pool Size</th>
        <th scope="col">Cost Per Night</th>
        <th scope="col">Details</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${results}" var="result">
    <tr>
        <th scope="row">${result.address}</th>
        <td>${result.poolSize}</td>
        <td>${result.costPerNight}</td>
        <td><a href="pools/${result.id}">${result.rating_average}/5 - See More</a></td>
    </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>