<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="users" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="base.jsp" %>
<body>
<form:form id="logoutForm" method="POST" action="/logout" cssStyle="text-align: right">
    <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
    <input type="submit" class="btn btn-danger"  value="Logout!"/>
</form:form>
<div class="card">

    <h3>Here are some events in your state: </h3>
    <table class="table-striped table-hover" style="width: 900px;">
        <thead>
            <tr>
                <th scope="col">Name</th>
                <th>Date</th>
                <th scope="col">Location</th>
                <th scope="col">Host</th>
                <th scope="col">Action / Status</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${eventsByState}" var="event">
            <tr>
                <th scope="row"><a href="events/${event.id}">${event.name}</a></th>
                <td><fmt:formatDate value="${event.date}" pattern="MMMM dd, yyyy"/></td>
                <td>${event.city}, ${event.state} </td>
                <td>${event.host} </td>
                <c:choose>
                <c:when test="${event.host == currentUser.username}">
                <td><a href="events/loadEvent/${event.id}">Edit</a> | <a href="events/deleteEvent/${event.id}">Delete</a></td>
                </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${event.users.contains(currentUser)}">
                                <td>Joining ... | <a href="events/cancelAttendance/${event.id}">Cancel</a></td>
                            </c:when>
                            <c:otherwise>
                                <td><a href="events/joinEvent/${event.id}">Join</a></td>
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:forEach>
        </tbody>

    </table>



</div>
<div class="card">
    <h3>Here are some events in other states:</h3>
    <table class="table-striped table-hover" style="width: 900px;">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Date</th>
            <th scope="col">Location</th>
            <th scope="col">Host</th>
            <th scope="col">Action / Status</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${NotInState}" var="event">
            <tr>
                <th scope="row"><a href="events/${event.id}">${event.name}</a></th>
                <td><fmt:formatDate value="${event.date}" pattern="MMMM dd, yyyy"/></td>
                <td>${event.city}, ${event.state} </td>
                <td>${event.host}</td>
                <c:choose>
                    <c:when test="${event.host == currentUser.username}">
                        <td>
                            <a href="events/loadEvent/${event.id}">Edit</a> | <a href="events/deleteEvent/${event.id}">Delete</a></td>
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${event.users.contains(currentUser)}">
                                <td>Joining ... | <a href="events/cancelAttendance/${event.id}">Cancel</a></td>
                            </c:when>
                            <c:otherwise>
                                <td><a href="events/joinEvent/${event.id}">Join</a></td>
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div class="card">

    <p>Errors: <form:errors path="event.*"/></p>

    <h3>Create an event</h3>

    <form:form action="events/save" method="post" modelAttribute="event">

        <%--1- eventsPage.jsp => Validation Errors not displaying / Validation working / form POST working--%>


        <div class="form-group">
            <form:label path="name">Name: </form:label>
            <form:input path="name" class="form-control"/>
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
        <input type="submit" class="btn btn-primary" value="Create the event!"/>
    </form:form>
</div>


</body>
</html>