<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 24. 4. 17.
  Time: 오후 6:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; ISO-8859-1" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>주소록 보기 1</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/my_style.css">
    <script>
        <c:if test="${!empty msg}">
        alert("${msg}");
        </c:if>
    </script>
</head>
<body>
    <h1>주소록</h1>
    <hr/>
    <table border="1">
        <thead>
            <tr>
                <th>이름</th>
                <th>이메일</th>
                <th>전화번호</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="row" items="${dataRows}">
                <tr>
                    <td>${row.name}</td>
                    <td>${row.email}</td>
                    <td>${row.phone}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <br><br>

    <a href="${pageContext.request.contextPath}/ch06/insert_addrbook">주소록 추가</a> &emsp;&emsp;
    <a href="${pageContext.request.contextPath}/ch06/delete_addrbook">주소록 삭제</a>

    <%@include file="/WEB-INF/jspf/main_footer.jspf"%>
</body>
</html>
