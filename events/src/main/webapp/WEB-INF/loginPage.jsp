<%@include file="base.jsp" %>
<body>

<div class="card">
    <div class="card-header">
        <h1>Login</h1>
    </div>

    <c:if test="${logoutMessage != null}">
        <p><c:out value="${logoutMessage}"></c:out></p>
    </c:if>
    <c:if test="${errorMessage != null}">
        <p><c:out value="${errorMessage}"></c:out></p>
    </c:if>

    <div class="card-body">
        <form method="POST" action="/login" style="margin-bottom: 20px;">
            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" class="form-control"/>
            </div>


          <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" class="form-control"/>
          </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button type="submit" class="btn btn-primary">Login</button>
        </form>
        <a href="/registration">Register</a>
    </div>
</div>


</body>
</html>