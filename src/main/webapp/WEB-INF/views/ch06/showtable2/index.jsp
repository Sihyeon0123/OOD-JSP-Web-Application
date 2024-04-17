<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 24. 4. 17.
  Time: 오후 5:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; ISO-8859-1" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags/ch06" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:eval expression="@environment.getProperty('spring.datasource.username')" var="db_username" />
<spring:eval expression="@environment.getProperty('spring.datasource.password')" var="db_password" />

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>주소록 보기 2</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/my_style.css">
</head>
<body>
    <h1>주소록</h1>
    <hr/>
    <c:catch var="errorReason">
        <mytags:addrbook user="${db_username}" password="${db_password}" schema="webmail" table="addrbook"/>
    </c:catch>
    ${empty errorReason ? "<noerror>" : errorReason}
    <%@include file="/WEB-INF/jspf/main_footer.jspf"%>
</body>
</html>
