<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 24. 5. 09.
  Time: 오후 4:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; ISO-8859-1" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="fileList" scope="page" class="deu.se.ood.beans.ch07.FileListBean"/>
<%--@elvariable id="targetDirectory" type="String"--%>
<jsp:setProperty name="fileList" property="dirName" value="${targetDirectory}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" http-equiv="Content-Type">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>파일 내려받기</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/my_style.css">
    <style>
        input {
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
    <h1>파일 내려받기</h1>
    <hr/>
    원하는 파일을 선택하세요.
    <br/>
    <br/>

    <form action="${pageContext.request.contextPath}/ch07/download.do" method="POST">
        <c:forEach var="fileName" items="${fileList.relativeFileList}">
            <label> <input type="radio" name="filename" value="${fileName}"> ${fileName} </label>
            <br/>
        </c:forEach>
        <br/>

        <input type="submit" value="내려받기"/>
    </form>

    <%@include file="/WEB-INF/jspf/main_footer.jspf" %>
</body>
</html>
