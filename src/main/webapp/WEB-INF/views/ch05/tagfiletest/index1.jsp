<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2024-04-05
  Time: 오후 10:53
  To change this template use File | Settings | File Templates.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/ch05" prefix="mytags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>태그 파일 예제 (조건부 액션 사용)</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/my_style.css">
    </head>
    <body>
        <div class="box padding_bottom_30px">
            <mytags:hello_1 user="홍길동" count="5"/>
        </div>
        <div class="box">
           <mytags:hello_1 user="전우치">
              오늘은 날씨가 아주 좋습니다.
           </mytags:hello_1>
        </div>
        <%@include file="/WEB-INF/jspf/main_footer.jspf" %>
    </body>
</html>
