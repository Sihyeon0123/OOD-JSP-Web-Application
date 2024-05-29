<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 24. 5. 29.
  Time: 오후 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="fileList" scope="page" class="deu.se.ood.beans.ch07.FileListBean"/>
<jsp:setProperty name="fileList" property="dirName" value="${targetDirectory}"/>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>필터링</title>
    <script>
        <c:if test="${!empty msg}">
            alert("${msg}")
        </c:if>
    </script>
</head>
<body>
    <h1>파일 내려받기 (필터링)</h1>
    <hr/>
    원하는 파일을 선택하세요.
    <br/>
    <br/>

    <form action="${pageContext.request.contextPath}/ch08/filter/download.do" method="POST">
        <c:forEach var="fileName" items="${fileList.relativeFileList}">
            <label>
                <input type="radio" name="file_name" value="${fileName}" /> ${fileName}
            </label>
            <br/>
        </c:forEach>
        <input type="hidden" name="AbsolutePath" value="${targetDirectory}"/>

        <br/>
        <input type="submit" value="내려받기"/>
    </form>
</body>
</html>
