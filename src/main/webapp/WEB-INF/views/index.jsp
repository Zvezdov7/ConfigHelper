<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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

    <div class="intFiles">
        <h4>Int:</h4>
        <c:forEach var="file" items="${intFiles}">
            <p class="file"><c:out value="${file}"/></p>
        </c:forEach>
    </div>
    <div class="extFiles">
        <h4>Ext</h4>
        <c:forEach var="file" items="${extFiles}">
            <p class="file"><c:out value="${file}"/></p>
        </c:forEach>
    </div>
    <textarea id="filetext" rows="30" cols="120"></textarea>
    <button id="saveButton">Save file</button>
    <button id="backupButton">Backup file</button>
</div>
<spring:url value="/resources/js/indexPage.js" var="coreJs" />
<script src="${coreJs}"></script>


</body>
</html>
