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
    <textarea id="filetext" rows="10" cols="45">

    </textarea>
    <button id="saveButton">Save file</button>
</div>

<script>
    $(".file").click(function(){
        $(this).siblings('file').removeClass('active');
        $(this).addClass('active');
        var path = "http://localhost:8080/spring/file?filepath="
        var file = $(this).text();
        var uri = path + file;
        alert(uri);
       $.get(uri, function (data) {
           alert(data);
            $("#filetext").val(data);
       });
    });

    $("#saveButton").click(function(){
       var data = $("#filetext").val();
        var path = "http://localhost:8080/spring/file?filepath=";
        var file = $(".active").text();
        var uri = path + file;
        alert(uri);
        alert(data);
        $.ajax({
           type: "POST",
            url: uri,
            data: data,
            contentType: "text/plain;charset=UTF-8"
        });
    });
</script>
</body>
</html>
