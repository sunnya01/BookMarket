<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sunchaowei
  Date: 2026/3/27
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<jsp:forward page="/loginServlet" />--%>
测试jsp的servlet class文件
<%--${ 12 == 12 }<br>--%>
<% request.setAttribute("msg","true"); %><br>
${  requestScope.msg ? "默认值" : requestScope.msg }
<%--保存之前：${ sessionScope.abc }<br>--%>
<%--<c:set var="abc" value="123" scope="session" />--%>
<%--保存之后：${ sessionScope.abc }<br>--%>
</body>
</html>
