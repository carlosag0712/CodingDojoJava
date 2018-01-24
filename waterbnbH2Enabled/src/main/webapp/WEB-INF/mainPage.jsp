<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="base.jsp" %>
<body>
    <div id="wrapper">
    <h4 style="margin-bottom: 15px;">Find places to swim and sleep on water bnb!</h4>

    <form:form class="form-inline" action="/search" method="post">
        <div class="form-group mx-sm-3 mb-2">
            <label class="sr-only">Password</label>
            <input type="text" name="search" class="form-control" style="width: 400px;">
        </div>
        <button type="submit" class="btn btn-primary mb-2">Search <i class="fa fa-search" aria-hidden="true"></i></button>
    </form:form>
    </div>
</body>
</html>