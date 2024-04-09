<%--
    Document    : hello
    Created on  : 2024. 4. 5., 오후 10:49:53
    Author      : 양시현
--%>

<%@tag description="사용자 이름과 반복 횟수를 속성으로 받아서 처리" pageEncoding="UTF-8" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@attribute name="user" required="true" %>
<%@attribute name="count"%>

<c:if test="${empty count}">
    <c:set var="count" value="1"/>
</c:if>

<c:forEach begin="1" end="${count}">
    ${user}님, 안녕하십니까? <br>
</c:forEach>

<jsp:doBody/>