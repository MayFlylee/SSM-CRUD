<%--
  Created by IntelliJ IDEA.
  User: zaiji
  Date: 2020/8/5
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<%--
不以/开始的相对路径，找资源，以当前资源的路径为准，经常容易出错
以/开始的相对路径，找资源，以服务器的路径为标准（http://localhost）
--%>
<head>
    <title>员工列表</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <link rel="stylesheet" href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="${APP_PATH}/static/js/jquery.js" type="text/javascript"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <h1>SSM-CRUD</h1>
        </div>
    </div>
    <div class="row"></div>
    <div class="row"></div>
    <div class="row"></div>
</div>

</body>
</html>
