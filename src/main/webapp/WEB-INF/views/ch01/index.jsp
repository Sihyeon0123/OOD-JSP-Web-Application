<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 24. 4. 18.
  Time: 오후 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; ISO-8859-1" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/my_style.css">
    <title>Title</title>
</head>
<body>
    <c:forEach begin="1" end="5">
        hi
    </c:forEach>

</body>
</html>
