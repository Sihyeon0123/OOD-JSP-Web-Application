<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 24. 5. 14.
  Time: 오후 1:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSP 초기화 방법</title>
    <style>
        body {
            margin: 50px 100px 50px 100px;
            background-color: rgb(220, 220, 220);
        }

        div {
            border: thin solid;
            margin-top: 10px;
            margin-bottom: 10px;
            padding: 10px;
        }

        a:link, a:visited {
            color: navy;
        }

        a:hover {
            background-color: yellow;


        }

        p.usage {
            margin: 50px;
            border: solid 2px;
            border-color: gray;
            padding: 5px;
        }

        h1 {
           border-style: groove;
        }
    </style>
</head>
<body>
    <p>다음은 웹 애플리케이션 초기화 예제입니다.</p>

    <div id="first">
        <h1>1. Model 인터페이스 이용 방법</h1>
        컨텍스트 내에 있는 모든 서블릿에 사용 가능한 초기 값을 제공할 수 있습니다.

        <p class="usage">
            개는 <strong> <%= request.getAttribute("dogSound")%>
            ${requestScope["dogSound"]}
            ${dogSound}
        </strong> 짖습니다.
        </p>
    </div>

    <div id="second">
        <h1>2. SelvletContext 인터페이스 이용 방법</h1>
        컨텍스트 내에 있는 모든 서블릿에 사용 가능한 초기 값을 제공할 수 있습니다.

        <p class="usage">
            새는 <strong> ${birdSound}
                <%= application.getAttribute("ctxBirdSound") %>
                ${applicationScope["ctxBirdSound"]}
            </strong> 웁니다.
        </p>

        ServletContext 인터페이스는 application 객체와 관련 있습니다.
    </div>
</body>
</html>
