<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<%
    String basePath = request.getScheme()
            + "://" + request.getServerName()
            + ":" + request.getServerPort()
            + request.getContextPath() + "/";
%>
<head>
    <title>学生功能入口</title>
    <base href="<%=basePath%>"/>
</head>

<body>

<div align="center">
    <p>SSM整合的小例子</p>
    <img src="WEB-INF/images/car.jpg"/>
    <table>
        <tr>
            <td><a href="addStudent.jsp">注册学生</a></td>
        </tr>
        <tr>
            <td><a href="queryStudent.jsp">浏览学生</a></td>
        </tr>
    </table>
</div>

</body>
</html>
