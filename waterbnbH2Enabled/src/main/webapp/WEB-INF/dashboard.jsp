<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="base.jsp" %>
<body>

<div id="wrapper" style="padding: 40px;">

    <h4>Current Listings</h4>
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
        <c:forEach items="${currentUser.listings}" var="listing">
        <tr>
            <th scope="row">${listing.address}</th>
            <td>${listing.poolSize}</td>
            <td>${listing.costPerNight}</td>
            <td><a href="/host/pools/${listing.id}">${listing.rating_average}/5 - Edit</a></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>


    <div class="card" style="width: 750px;">
        <div class="card-header">
            New Listing!
        </div>
        <div class="card-body">
            <c:if test="${error != null}">
                <div class="alert alert-danger" role="alert">
                    <form:errors path="listing.*"/>
                </div>
            </c:if>
            <form:form action="/host/saveListing" method="post" modelAttribute="listing">
                <div class="form-group row">
                    <form:label path="venueName" class="col-sm-2 col-form-label">BnB Name:</form:label>
                    <div class="col-sm-10">
                        <form:input path="venueName" type="text" class="form-control"/>
                    </div>
                </div>

                <div class="form-group row">
                    <form:label path="address" class="col-sm-2 col-form-label">Address:</form:label>
                    <div class="col-sm-10">
                        <form:input path="address" type="text" class="form-control"/>
                    </div>
                </div>

                <div class="form-group row">
                    <form:label path="description" class="col-sm-2 col-form-label">Description:</form:label>
                    <div class="col-sm-10">
                        <form:input path="description" type="text" class="form-control" style="height: 80px;"/>
                    </div>
                </div>

                <div class="form-group row">
                    <form:label path="costPerNight" class="col-sm-2 col-form-label">Cost Per Night:</form:label>
                    <div class="col-sm-10">
                        <form:input path="costPerNight" type="text" class="form-control"/>
                    </div>
                </div>

                <div class="form-group row">
                    <form:label path="poolSize" class="col-sm-2 col-form-label" >Pool Size:</form:label>
                    <div class="col-sm-10">
                    <form:select path="poolSize" class="form-control">
                        <form:option value="small" label="Small"/>
                        <form:option value="medium" label="Medium"/>
                        <form:option value="large" label="Large"/>
                    </form:select>
                    </div>
                </div>

                <input name="userId" type="hidden" value="${currentUser.id}"/>

                <input type="submit" style="margin-left: 550px;" class="btn btn-primary" value="Register"/>

            </form:form>

        </div>
    </div>

</div>

</body>
</html>