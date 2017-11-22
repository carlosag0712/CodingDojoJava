<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="base.jsp"%>
<body>

<div class="container" style="margin-top: 20px;">

    <div class="row" style="text-align:right; margin-left: 800px; text-decoration: underline;">
        <a href="/">dashboard</a>
    </div>


    <p style="color: red"><form:errors path="song.*"/></p>
    <div class="row">


        <form:form action="/songs" method="POST" modelAttribute="song">
            <p>
                <form:label path="title" for="title">Title: </form:label>
                <form:input path="title" type="text" name="title"></form:input>
            </p>
            <p>
                <form:label path="artist" for="artist">Artist</form:label>
                <form:input path="artist" type="text" name="artist"></form:input>
            </p>
            <p>
                <form:label path="rating" for="rating">Rating (1-10)</form:label>
                <form:input path="rating" min="1" max="10" type="number" name="rating"></form:input>
            </p>
            <p>
                <input class="button btn btn-success" type="submit" value="Add Song">
            </p>


        </form:form>
    </div>

</div>
</body>
</html>