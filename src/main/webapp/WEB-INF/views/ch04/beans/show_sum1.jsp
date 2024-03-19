<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-20
  Time: 오전 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:useBean id="sumBean" scope="page" class="deu.se.ood.beans.ch04.SumBean"/>
<jsp:setProperty name="sumBean" property="n"/>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Java Bean 사용한 계산 결과</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/my_style.css">
    </head>
    <body>
        <div class="padding_bottom_30px box center" style="width: 80%;">
            Request parameter n : <%=request.getParameter("n")%>
        </div>

        <% sumBean.calculate();%>

        <ul>
            <li>계산 결과 1: <jsp:getProperty name="sumBean" property="result"/></li>
            <li>계산 결과 2: <%=sumBean.getResult()%></li>
            <li>계산 결과 3: ${sumBean.result}</li>
        </ul>

        <%@ include file="/WEB-INF/jspf/main_footer.jspf"%>
    </body>
</html>
