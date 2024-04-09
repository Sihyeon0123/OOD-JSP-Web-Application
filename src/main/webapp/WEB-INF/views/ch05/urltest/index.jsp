<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 24. 4. 9.
  Time: 오후 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>URL 관련 액션 예제</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/my_style.css">
  </head>
  <body>
    <c:import url="header.jsp"/>

    본문 내용입니다.
    <br/>

    <c:url value="footer.jsp" var="footerUrl1">
      <c:param name="date" value="<%=java.time.LocalDate.now().toString()%>"/>
      <c:param name="user" value="홍길동"/>
    </c:url>
    <c:url value="urltest_footer" var="footerUrl2">
      <c:param name="date" value="<%=java.util.Date%>"/>
      <c:param name="user" value="전우치"/>
    </c:url>
    <br>

    footer URL1: <c:out value="${footerUrl1}"/> <br>
    footer URL2: <c:out value="${footerUrl2}"/> <br><br>

    <a href="${footerUrl1}">footer1 따로 보기</a> &nbsp; &nbsp; &nbsp;
    <a href="${footerUrl2}">footer2 따로 보기 </a>

    <c:import url="${footerUrl1}" var="urltest_footer1"/>
    <c:import url="${footerUrl2}" var="urltest_footer2"/>

    <br>
    footer1: <c:out value="${urltest_footer1}"/> <br>
    footer2: <c:out value="${urltest_footer2}"/>

    <div class="box">
      &lt;c:import&gt;는 footer.jsp를 바로 사용 가능하지만,
      &lt;c:url&gt;에서는 footer.jsp 대신 controller에서 연결시켜 줄  수 있는 이름을 사용해야 함.
    </div>
    <c:import url="${footerUrl1}"/>
  </body>
</html>
