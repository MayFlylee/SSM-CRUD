<%--
  Created by IntelliJ IDEA.
  User: zaiji
  Date: 2020/8/3
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<%--<jsp:forward page="/emps"></jsp:forward>--%>
<html>
<%--<link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="static/js/jquery.js" type="text/javascript"></script>--%>
<head>
    <title>Title</title>
</head>
<body>
主页
<a href="emps">跳转list页面的请求</a>
<a href="some">发起some.do的请求</a>

</body>
</html>
