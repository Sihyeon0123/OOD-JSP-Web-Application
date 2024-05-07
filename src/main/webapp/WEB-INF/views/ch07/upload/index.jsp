<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 24. 4. 17.
  Time: 오후 4:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; ISO-8859-1" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>파일 업로드</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/my_style.css">
</head>
<body>
    <h1>파일 올리기</h1>
    <hr/>

    <c:if test="${!empty exec_message}">
        <div class="box">실행 결과: ${exec_message}</div>
    </c:if>

    <form enctype="multipart/form-data" method="POST"
        action="${pageContext.request.contextPath}/ch07/upload.do">
        username: <input type="text" name="username"> <br>
        upload할 파일 선택: <input type="file" name="upfile"> <br>
        <input type="submit" value="Upload">
    </form>

    <%@include file="/WEB-INF/jspf/main_footer.jspf" %>
</body>
</html>
