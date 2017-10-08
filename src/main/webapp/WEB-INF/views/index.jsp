<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dmitry Zvezdov
  Date: 07.10.17
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script
            src="http://code.jquery.com/jquery-3.2.1.min.js"
            integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">

    <c:forEach var="file" items="${files}">
        <p class="file"><c:out value="${file}"/></p>
    </c:forEach>
    <textarea class="filetext" rows="10" cols="45">

    </textarea>
    <button class="saveButton">Save file</button>
</div>

<script>
    $(".file").click(function(){
        var path = "http://localhost:8080/spring/file?filepath="
        var file = $(this).text();
        var uri = path + file;
        alert(uri);
       $.get(uri, function (data) {
           alert(data);
            $(".filetext").val(data);
       });
    });
</script>
</body>
</html>
