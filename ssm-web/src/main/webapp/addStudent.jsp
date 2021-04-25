<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%
    String basePath = request.getScheme()
            + "://" + request.getServerName()
            + ":" + request.getServerPort()
            + request.getContextPath() + "/";
%>

<head>
    <title>注册学生</title>
    <head>
        <base href="<%=basePath%>"/>
    </head>
</head>

<body>
<div align="center">
    <form action="student/addStudent.do" method="post">
        <table>
            <tr>
                <td>姓名：</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>班级ID：</td>
                <td><input type="text" name="classId"></td>
            </tr>
            <tr>
                <td>&nbsp;&nbsp;&nbsp;</td>
                <td><input type="submit" name="注册"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
