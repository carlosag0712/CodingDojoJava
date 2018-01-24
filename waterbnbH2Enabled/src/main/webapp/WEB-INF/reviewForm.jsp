<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="base.jsp" %>
<body>

<h2></h2>
<h3></h3>

<div class="card" style="width: 800px;margin-left: 30px;">
    <h5 class="card-header">
        Review For: ${listing.venueName}
    </h5>
    <div class="card-body">
        <h5 class="card-title">Address: ${listing.address}</h5>

        <form:form method="post" action="/pools/saveReview" modelAttribute="rating">
            <div class="form-group">
                <form:label path="review">Comments: </form:label>
                <form:textarea path="review" class="form-control" rows="3"></form:textarea>
            </div>

            <div class="form-group">
                <form:label path="rating">Rating: (1 = sucks | 5 = rocks!) </form:label>
                <form:select path="rating" class="form-control" id="exampleFormControlSelect1">
                    <option disabled="" value="Select your rating" selected/>
                    <form:option value="1" label="1"/>
                    <form:option value="2" label="2"/>
                    <form:option value="3" label="3"/>
                    <form:option value="4" label="4"/>
                    <form:option value="5" label="5"/>
                </form:select>
            </div>

            <form:input path="username" type="hidden" value="${currentUser.username}"/>
            <input type="hidden" name="listingId" value="${listing.id}">



            <input type="submit" class="btn btn-primary" value="Post Review"/>
        </form:form>
    </div>
</div>
</body>
</html>