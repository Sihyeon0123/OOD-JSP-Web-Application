<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 24. 4. 17.
  Time: 오후 6:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; ISO-8859-1" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>주소록 추가</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/my_style.css">
</head>
<body>
<h1>주소록 지우기</h1>
<hr/>
<table border="1">
    <thead>
    <tr>
        <th>이름</th>
        <th>이메일</th>
        <th>전화번호</th>
        <th>삭제</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="row" items="${dataRows}">
        <tr>
            <td>${row.name}</td>
            <td>${row.email}</td>
            <td>${row.phone}</td>
            <td><form action="${pageContext.request.contextPath}/ch06/delete.do" style="display: inline" method="POST"><input type="hidden" name="email" value="${row.email}"><input type="submit" value="삭제"></form></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<%@include file="/WEB-INF/jspf/main_footer.jspf"%>
</body>
</html>
