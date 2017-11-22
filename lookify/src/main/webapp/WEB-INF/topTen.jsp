
<%@include file="base.jsp"%>
<body>
<div class="container" style="margin-top: 80px;">
    <div class="row" style="margin-bottom: 50px;">
        <p>Top 10 Songs</p>

    </div>

    <table class="table table-striped">
       <thead>
        <tr>

            <th>Rating</th>
            <th>Title</th>
            <th>Artist</th>
        </tr>
       </thead>
        <tbody>
        <c:forEach var="song" items="${songs}">
        <tr>
            <td><a href="/songs/${song.id}" style="text-decoration: underline;"><c:out value="${song.rating}"></c:out></a></td>
            <td><c:out value="${song.title}"></c:out></td>
            <td><c:out value="${song.artist}"></c:out></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>
</html>