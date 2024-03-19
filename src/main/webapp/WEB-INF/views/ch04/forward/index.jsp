<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-20
  Time: 오전 1:35
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>&lt;jsp:forward&gt; 액션 예제</title>
    </head>
    <body>
        <%
          request.setCharacterEncoding("UTF-8");
          String user = request.getParameter("user");
          if (user == null || user.equals("")){
        %>
            사용자가 지정되지 않았습니다. 사용자 이름을 입력해 주시기 바랍니다.
        <%-- form에 action 속성이 지정되어 있지 않으면 자기 자신(페이지)로 돌아온다 --%>
        <form method="POST">
            이름: <input type="text" name="user" value="" />
            <input type="submit" value="입력" />
        </form>

        <%
          } else {
        %>
        <jsp:forward page="process.jsp"/>
        <%
          } 
        %>
    
        <%@ include file="/WEB-INF/jspf/main_footer.jspf"%>
    </body>
</html>
