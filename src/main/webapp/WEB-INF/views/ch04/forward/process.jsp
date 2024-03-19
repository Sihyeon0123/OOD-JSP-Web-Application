<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-20
  Time: 오전 1:42
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>process.jsp</title>
    </head>
    <body>
        반갑습니다.
        <%=request.getParameter("user") %> 님!

        <%@ include file="/WEB-INF/jspf/main_footer.jspf"%>
    </body>
</html>