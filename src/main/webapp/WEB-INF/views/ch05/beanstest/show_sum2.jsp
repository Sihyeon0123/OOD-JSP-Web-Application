<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 24. 4. 9.
  Time: 오후 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="sum" scope="page" class="deu.se.ood.beans.ch04.SumBean"/>
<c:set target="${sum}" property="n" value="${param.n}"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Beans 사용 예제</title>
    </head>
    <body>
        <%      sum.calculate();%>

        계산 결과 1:    <jsp:getProperty name="sum" property="result"/> <br>
        계산 결과 2:    <c:out value="${sum.result}" /> <br>
        계산 결과 3:    ${sum.result}

        <%@ include file="/WEB-INF/jspf/main_footer.jspf"%>
    </body>
</html>
