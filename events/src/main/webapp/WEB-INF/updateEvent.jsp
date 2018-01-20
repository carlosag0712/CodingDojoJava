<%@include file="base.jsp" %>
<body>

<div class="card">
    <h3>Update an event</h3>

    <form:form action="/events/save" method="post" modelAttribute="event">

        <%--1- eventsPage.jsp => Validation Errors not displaying / Validation working / form POST working--%>
        <p>Errors: <form:errors path="event.*"></form:errors></p>

        <div class="form-group">
            <form:label path="name">Name: </form:label>
            <form:input path="name" class="form-control" value="${event.name}"/>
        </div>
        <div class="form-group">
            <form:label path="date">Date:</form:label>
            <form:input path="date" type="date" class="form-control"/>
        </div>
        <div class="form-group">
            <form:label path="city">City:</form:label>
            <form:input path="city" class="form-control"/>
        </div>
        <div class="form-group">
            <form:label path="state">State:</form:label>
            <form:select path="state" class="form-control">
                <c:forEach items="${stateList}" var="state">
                    <form:option value="${state}" label="${state}"></form:option>
                </c:forEach>
            </form:select>
        </div>
        <form:input path="Host" type="hidden" class="btn btn-primary" value='${currentUser.username}'/>
        <input type="hidden" value='${currentUser.username}' name="username">
        <input type="hidden" value='${event.id}' name="id">

        <input type="submit" class="btn btn-primary" value="Update the event!"/>
    </form:form>
</div>


</body>
</html>