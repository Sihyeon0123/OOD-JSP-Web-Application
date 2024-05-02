<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 24. 4. 17.
  Time: 오후 4:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; ISO-8859-1" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:eval expression="@environment.getProperty('spring.datasource.driver-class-name')" var="db_driver" />
<spring:eval expression="@environment.getProperty('spring.datasource.username')" var="db_username" />
<spring:eval expression="@environment.getProperty('spring.datasource.password')" var="db_password" />

<spring:eval expression="@configProperties['mysql.server.ip']" var="mysqlServerIp"/>
<spring:eval expression="@configProperties['mysql.server.port']" var="mysqlServerPort"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>주소록 보기 1</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/my_style.css">
</head>
<body>
    <h1>주소록</h1>
    <hr/>
    <%
        // Spring Boot @environment 를 통해서 가져온 정보
        final String JDBC_DRIVER = (String)pageContext.getAttribute("db_driver");
        // Controller 에서 전송한 정보
        final String mysqlServerIp = (String) request.getAttribute("mysql_server_ip");
        // configProperties 메서드를 통해 반환받은 객체를 사용하여 얻은 정보
        final String mysqlServerPort = (String)pageContext.getAttribute("mysqlServerPort");

        final String JDBC_URL = String.format("jdbc:mysql://%s:%s/webmail?serverTimezone=Asia/Seoul", mysqlServerIp, mysqlServerPort);
        final String USER = (String)pageContext.getAttribute("db_username");
        final String PASSWORD = (String)pageContext.getAttribute("db_password");

        // 드라이버 적재
        Class.forName(JDBC_DRIVER);
        // DB 연결
        Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        // Statement 생성
        Statement stmt = conn.createStatement();
        // SQL 정의
        String sql = "SELECT email, name, phone FROM addrbook";
        ResultSet rs = stmt.executeQuery(sql);
    %>
    <table border="1">
        <thead>
            <tr>
                <td>이름</td>
                <td>이메일</td>
                <td>전화번호</td>
            </tr>
        </thead>
        <tbody>
            <%
                while (rs.next()) {
                    out.println("<tr>");
                    out.println("<td>" + rs.getString("name") +"</td>");
                    out.println("<td>" + rs.getString("email") +"</td>");
                    out.println("<td>" + rs.getString("phone") +"</td>");
                    out.println("</tr>");
                }
                rs.close();
                stmt.close();
                conn.close();
            %>
        </tbody>
    </table>
    <br><br>

    <div>
        참고 &dollar;(db.driver) = ${db_driver}
    </div>
    <%@include file="/WEB-INF/jspf/main_footer.jspf" %>
</body>
</html>
