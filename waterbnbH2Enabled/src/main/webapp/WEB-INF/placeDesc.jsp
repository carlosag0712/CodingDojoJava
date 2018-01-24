<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="base.jsp" %>
<body>

<div class="row" style="display: -webkit-inline-flex; margin-top: 50px;margin-left: 40px;">
    <div class="card" style="width: 500px;">
        <div class="card-body">
            <h5 class="card-title">${listing.address}</h5>
            <h6 class="card-subtitle mb-2 text-muted"></h6>
            <p class="card-text">${listing.description}</p>
        </div>
    </div>
    <div class="card" style="width: 400px;margin-left: 50px;">
        <div class="card-body">
            <h5 class="card-title">Email: ${listing.user.username}</h5>
            <h6 class="card-subtitle mb-2 text-muted">Name: ${listing.user.firstName} ${listing.user.lastName}</h6>
            <h6 class="card-title">Pool Size: ${listing.poolSize}</h6>
            <h6 class="card-title">Cost Per Night: $${listing.costPerNight}</h6>
        </div>
    </div>
</div>

<div class="row" style="display: -webkit-inline-flex; margin-top: 50px;margin-left: 40px;">
    <div class="card" style="width: 950px;">
        <div class="card-header">
            <span style="color: blue;">Reviews:
                <fmt:formatNumber type="number" maxFractionDigits="1" value="${listing.rating_average}"/>
                /5</span>

            <c:choose>
                <c:when test="${not empty currentUser.username}">

                    <a href="/pools/${listing.id}/review" style="margin-left: 660px;">Leave a Review</a>
                </c:when>
                <c:otherwise>

                        <a  style="color: blue;margin-left: 550px;" href="/guest/signin"><i class="fa fa-user-circle" aria-hidden="true"></i> Signing to Leave a review</a>

                </c:otherwise>
            </c:choose>



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