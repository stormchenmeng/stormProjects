<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String basePath = request.getScheme()
            + "://" + request.getServerName()
            + ":" + request.getServerPort()
            + request.getContextPath() + "/";
%>

<head>
    <title>查询学生的ajax</title>
    <head>
        <base href="<%=basePath%>"/>
        <script type="text/javascript" src="js/jquery-1.8.2.js"></script>
        <script type="text/javascript">
            $(function () {
                //(1)在当前页面的dom对象一加载，主动来执行加载数据的方法，这样就不用先点击再查询了
                queryStudentData();

                //(2)先点击查询按钮，再触发方法的执行来刷新新增的学生数据
                $("#btnLoader").click(function () {
                    queryStudentData();
                })
            })

            function queryStudentData() {
                $.ajax({
                    url: "student/findAll",
                    type: "get",
                    dataType: "json",
                    success: function (date) {
                        // 测试的时候使用
                        alert("date=" + date);
                        //先清除旧的数据
                        $("#info").html("");
                        //再增加新的数据
                        $.each(date, function (i, n) {
                            $("#info").append("<tr>")
                                .append("<td>" + n.id + "<td>")
                                .append("<td>" + n.name + "<td>")
                                .append("<td>" + n.classId + "<td>")
                                .append("<td>" + n.addTime + "<td>")
                                .append("</tr>");
                        })
                    }
                })
            }
        </script>
    </head>
</head>

<body>
<div align="center">
    <table>
        <thead>
        <tr>
            <td>学号</td>
            <td>姓名</td>
            <td>班级</td>
            <td>注册时间</td>
        </tr>
        </thead>
        <tbody id="info">
        </tbody>
    </table>
    <input type="button" id="btnLoader" value="查询学生数据"/>
</div>
</body>
</html>
