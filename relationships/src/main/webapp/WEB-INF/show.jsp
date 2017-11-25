<%@include file="base.jsp"%>
<body>
    <div class="container" style="margin-top: 100px;">
        <h1><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></h1>

        <p>License Number: <c:out value="${person.license.number}"></c:out></p>
        <p>State: <c:out value="${person.license.state}"></c:out></p>
        <p>Expiration Date: <c:out value="${person.license.expirationDate}"/></p>

    </div>

</body>
</html>