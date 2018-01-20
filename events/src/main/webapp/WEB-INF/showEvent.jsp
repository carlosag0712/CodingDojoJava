<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@include file="base.jsp" %>
<body>

<div id="wrapper" style="display: -webkit-inline-flex; margin-top: 40px;">

<div class="row" style="display: block;padding-left: 130px;">
    <div class="card" style="width: 450px;">
        <div class="card-body">
            <h3 class="card-title">${event.name}</h3>
            <h5 class="card-subtitle mb-2 text-muted">Host: ${host.firstName} ${host.lastName}</h5>
            <h5 class="card-text">Date: <fmt:formatDate value="${event.date}" pattern="MMMM dd, yyyy"/></h5>
            <h5 class="card-text">Location: ${event.city}, ${event.state}</h5>
            <h5 class="card-text">People attending this event: ${count}</h5>
        </div>
    </div>
    <table class="table-striped table-hover table-bordered" style="width: 450px;text-align: center; font-size: 100%;">
        <thead>
            <tr>
                <th>Name</th>
                <th>Location</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${event.users}" var="user">
            <tr>
                <td>${user.firstName}</td>
                <td>${user.city}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<div class="row" style="display: block;width: 700px;margin-left: 150px;">
    <div class="form-group">
        <label for="exampleFormControlSelect2">Example multiple select</label>
        <select multiple class="form-control" id="exampleFormControlSelect2">
            <c:forEach items="${messagesInEvent}" var="messageInEvent">
                <option value="">${messageInEvent.username}: ${messageInEvent.messageBody}</option>
            </c:forEach>
        </select>
    </div>
    <form:form action="postMessage/${event.id}" method="POST" modelAttribute="messages">
    <div class="form-group">
        <label>Post Message</label>
        <form:input cssStyle="margin-bottom: 20px;" type="text" path="messageBody"  name="message" class="form-control" id="exampleFormControlTextarea1" rows="3"></form:input>
        <form:input  type="hidden" path="username" name="username" value="${userInSession.firstName}"></form:input>
        <%--<form:input type="hidden" path="events" value="${event}"/>--%>
        <input type="submit" class="btn btn-primary" value="Post Message">
    </div>
    </form:form>
</div>

</div>



</body>
</html>