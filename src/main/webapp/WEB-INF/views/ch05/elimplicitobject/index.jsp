<%-- 
    Document   : index
    Created on : 2024. 4. 4., 오전 10:51:38
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>EL 표현식 묵시적 객체 사용 예제</title>
    </head>
    <body>
        <ol>
            <li>웹 브라우저 : ${ header["user-agent"]}</li>
            <li>사용자 컴퓨터 : ${ header.host}</li>
            <li>HTTP 메소드  : ${ pageContext.request.method}</li>
            <li>name 매개변수 : ${ empty param["name"] ? "없음" : param.name }</li>
            <li>세션 ID : ${ cookie["JSESSIONID"].value }</li>
        </ol>
        <div>
            headers : <%=java.util.Collections.list(request.getHeaderNames())%>
        </div>
        <%@include file="/WEB-INF/jspf/main_footer.jspf" %>
    </body>
</html>
