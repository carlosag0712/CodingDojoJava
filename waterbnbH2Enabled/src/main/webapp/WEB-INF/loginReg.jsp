<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="loginbase.jsp" %>
<body>


<a  href="/"><h4 style="padding: 20px;">Back to Main Page</h4></a>

<div class="row" style="margin-top: 40px; padding: 20px;">

    <div class="col-sm-6">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Register</h5>
                <p class="card-text">Don't have an account? Register today, it's free!</p>
                <c:if test="${error != null}">
                <div class="alert alert-danger" role="alert">
                    <form:errors path="user.*"/>
                </div>
                </c:if>
                <form:form action="/guest/registration" method="POST" modelAttribute="user">

                    <div class="form-group row">
                        <form:label path="firstName" class="col-sm-2 col-form-label">First Name:</form:label>
                        <div class="col-sm-10">
                            <form:input path="firstName" type="text" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <form:label path="lastName" class="col-sm-2 col-form-label">Last Name:</form:label>
                        <div class="col-sm-10">
                            <form:input path="lastName" type="text" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <form:label path="username" class="col-sm-2 col-form-label">Email:</form:label>
                        <div class="col-sm-10">
                            <form:input path="username" type="text" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <form:label path="password" class="col-sm-2 col-form-label">Password:</form:label>
                        <div class="col-sm-10">
                            <form:input path="password" type="password" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <form:label path="confPassword" class="col-sm-2 col-form-label">Confirm Password:</form:label>
                        <div class="col-sm-10">
                            <form:input path="confPassword" type="password" class="form-control"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label >Account Type:</label>
                        <select class="form-control" name="account">
                            <option value="host" label="">Host</option>
                            <option value="guest" label="">Guest</option>
                        </select>
                    </div>
                    <input type="submit" style="margin-left: 550px;" class="btn btn-primary" value="Register"/>
                </form:form>
            </div>
        </div>
    </div>
    <div class="col-sm-6">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Login</h5>
                <p class="card-text">Have an account? log in!</p>
                <c:if test="${not empty errorMessage}">
                <div class="alert alert-success" role="alert">
                    ${errorMessage}
                </div>
                </c:if>
                <form action="/guest/login" method="POST">

                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Email:</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" name="username">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label">Password:</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" name="password">
                        </div>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                    <input type="submit" style="margin-left: 550px;" class="btn btn-primary" value="Login"/>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>