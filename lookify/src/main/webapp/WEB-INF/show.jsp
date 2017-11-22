<%@include file="base.jsp"%>
<body>
<div class="container" style="margin-top: 50px;">
    <div class="row" style="text-align:right; margin-left: 800px; text-decoration: underline;">
        <a href="/dashboard">dashboard</a>
    </div>

    <h3>Song Info: </h3>
    <p>Title: <c:out value="${song.title}"></c:out></p>
    <p>Artist: <c:out value="${song.artist}"></c:out></p>
    <p>Rating (1-10): <c:out value="${song.rating}"></c:out></p>

    <br>
    <a href="/songs/delete/${song.id}">delete</a>

</div>
</body>
</html>