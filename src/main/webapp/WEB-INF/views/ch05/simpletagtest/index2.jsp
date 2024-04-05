<%-- 
    Document   : index2
    Created on : 2024. 4. 4., 오전 11:27:29
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="/WEB-INF/tlds/mytags2.tld" prefix="mytags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Simple Tag Handler</title>
    </head>
    <body>
        <mytags:hello user="홍길동" count="5" />
        <%@include file="/WEB-INF/jspf/main_footer.jspf" %>
    </body>
</html>
