
<%@include file="base.jsp"%>
<body>
<div class="container" style="margin-top: 80px;">
    <div class="row" style="margin-bottom: 50px;">
        <p>Songs by Artist: <c:out value="${artist}"></c:out></p>


        <form action="/search" method="POST" style="margin-left: 200px;">
            <input id="searchText" type="text" placeholder="Artist Name" name="artist" placeholder="${artist}" />
            <input class="button btn btn-primary" type="submit" value="Search Artists"/>
        </form>

    </div>

    <table class="table table-striped">
       <thead>
        <tr>
            <th>Name</th>
            <th>Rating</th>
            <th>Action</th>
        </tr>
       </thead>
        <tbody>
        <c:forEach var="song" items="${songs}">
        <tr>
            <td><a href="/songs/${song.id}" style="text-decoration: underline;"><c:out value="${song.title}"></c:out></a></td>
            <td><c:out value="${song.rating}"></c:out></td>
            <td>
                <a href="/songs/delete/${song.id}" style="text-decoration: underline">delete</a>
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>
</html>