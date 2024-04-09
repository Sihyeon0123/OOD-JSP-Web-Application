<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 24. 4. 9.
  Time: 오후 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Java Beans 사용 예제</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/my_style.css">
    </head>
    <body>
        1부터 n까지의 합을 구하는 프로그램
        <form action="${pageContext.request.contextPath}/ch05/beanstest/show_sum2" method="POST">
            n을 입력하시오 :
            <input type="text" name="n" value="" size="10"/> <br>
            <input type="submit" value="계산"/>
            <input type="reset" value="초기화"/>
        </form>

        <%@ include file="/WEB-INF/jspf/main_footer.jspf"%>
    </body>
</html>
