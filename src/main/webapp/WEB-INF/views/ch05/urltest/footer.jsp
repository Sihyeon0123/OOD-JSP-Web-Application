<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 24. 4. 9.
  Time: 오후 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:requestEncoding value="UTF-8"/>

<hr/>
페이지 하단에 들어갈 내용입니다. <br>
날짜: ${param.date}
사용자: ${param.user}