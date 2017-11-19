<%@include file="base.jsp"%>
<body>

<div class="container" style="text-align: center; display: block;margin-top: 50px;">


        <p style="color: red"><c:out value="${error}"></c:out></p>


    <h3>What is the code?</h3>
    <form action="/processCode">
        <input type="text" name="code"/><br>
        <input type="submit" value="Try Code">
    </form>
    
    
</div>
</body>
</html>