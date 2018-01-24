<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="base.jsp" %>
<body>
<div class="row">
<a href="/host/dashboard" style="margin-left: 40px;">Back to host dashboard</a>
</div>
<div class="row" style="display: inline-block; margin-top: 50px;margin-left: 30px;">
    <form:form modelAttribute="listing" method="post" action="/host/pools/${listing.id}/update">
    <div class="card" style="width: 500px;">
        <div class="card-body">
            <h5 class="card-title">Address: <form:input path="address" value=" ${listing.address}"/></h5>
            <h6 class="card-subtitle mb-2 text-muted">Description: </h6>
            <form:input cssStyle="width: 450px;" row="3" path="description" class="card-text" value="${listing.description}"/>
        </div>
    </div>
    <div class="card" style="width: 550px;margin-left: 550px;margin-top: -140px;">
        <div class="card-body">
            <h5 class="card-title">Email: ${listing.user.username}</h5>
            <h6 class="card-subtitle mb-2 text-muted">Name: ${listing.user.firstName} ${listing.user.lastName}</h6>
            <h6 class="card-title">Pool Size: <div class="form-group row">
                <%--<form:label path="poolSize" class="col-sm-2 col-form-label" ></form:label>--%>
                <div class="col-sm-10">
                    <form:select path="poolSize" class="form-control">
                        <form:option value="${listing.poolSize}" label="(Current) ${listing.poolSize}"/>
                        <form:option value="small" label="Small"/>
                        <form:option value="medium" label="Medium"/>
                        <form:option value="large" label="Large"/>
                    </form:select>
                </div>
            </div></h6>
            <h6 class="card-title">Cost Per Night: $<form:input path="costPerNight" value="${listing.costPerNight}"/> </h6>
        </div>
    </div>
        <input name="userId" type="hidden" value="${currentUser.id}"/>

        <input type="submit" class="btn btn-success" value="Save Changes">
    </form:form>
</div>

<div class="row" style="display: -webkit-inline-flex; margin-top: 50px;margin-left: 40px;">
    <div class="card" style="width: 950px;">
        <div class="card-header">
            <span style="color: blue;">Reviews:
                <fmt:formatNumber type="number" maxFractionDigits="1" value="${listing.rating_average}"/>
                /5</span>

            <%--<c:choose>--%>
                <%--<c:when test="${not empty currentUser.username}">--%>

                    <%--<a href="/pools/${listing.id}/review" style="margin-left: 660px;">Leave a Review</a>--%>
                <%--</c:when>--%>
                <%--<c:otherwise>--%>

                        <%--<a  style="color: blue;margin-left: 550px;" href="/guest/signin"><i class="fa fa-user-circle" aria-hidden="true"></i> Signing to Leave a review</a>--%>

                <%--</c:otherwise>--%>
            <%--</c:choose>--%>



        </div>
    </div>
    <c:forEach items="${reviews}" var="review">
    <div class="card" style="width: 950px;">

        <div class="card-header">
            Review from user: ${review.username}
            <p>Rating: ${review.rating}/5</p>
        </div>
        <div class="card-body">

            <p class="card-text">${review.review}</p>
        </div>
    </div>
    </c:forEach>
</div>


</body>
</html>