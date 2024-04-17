<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 24. 4. 17.
  Time: 오후 6:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; ISO-8859-1" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>주소록 추가</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/my_style.css">
</head>
<body>
    <h1>주소록 추가</h1>
    <hr/>

    <form action="${pageContext.request.contextPath}/ch06/insert.do" method="POST">
        <table border="0">
            <tbody>
                <tr>
                    <td>이름</td>
                    <td><input  type="text" name="name" size="20"/></td>
                </tr>
                <tr>
                    <td>이메일</td>
                    <td><input  type="text" name="email" size="20"/></td>
                </tr>
                <tr>
                    <td>전화번호</td>
                    <td><input  type="text" name="phone" size="20"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <center>
                            <input type="submit" value="추가" /> <input type="reset" value="초기화"/>
                        </center>
                    </td>
                </tr>
            </tbody>
        </table>
    </form>

    <%@include file="/WEB-INF/jspf/main_footer.jspf"%>
</body>
</html>
