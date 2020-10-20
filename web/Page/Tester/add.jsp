<%--
  Created by IntelliJ IDEA.
  User: 张辰逸
  Date: 2020/9/24
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String Path =request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+Path+"/";
%>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="<%=basePath%>css/style.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/font-awesome-4.7.0/css/font-awesome.min.css" />
    <script type="text/javascript" src="<%=basePath%>js/jquery-3.5.1.min.js"></script>
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#addform").validate({
                rules:{
                    stuname:"required",
                    stunumber:
                        {
                            required:true,
                            digits:true,
                        },
                    stuclass:"required",
                    testname:"required"
                },
                messages:{
                    stuname: "学生姓名不能为空",
                    stunumber:"学号不能为空",
                    stuclass: "班级不能为空",
                    testname:"实验名不能为空"
                }
            })

        })
    </script>
</head>
<body>
<div class="add">
    <form id="addform" action="<%=basePath%>Tester?method=add" method="post">
    <table class="add_table" style="width: 75%;">
        <tr>
            <td>学生姓名</td>
            <td style="color: red"><input type="text" name="stuname"></td>
        </tr>
        <tr>
            <td>学生学号</td>
            <td style="color: red"><input type="text" name="stunumber"></td>
        </tr>
        <tr>
            <td>班级</td>
            <td style="color: red"><input type="text" name="stuclass"></td>
        </tr>
        <tr>
            <td>实验名称</td>
            <td style="color: red"><input type="text" name="testname"></td>
        </tr>
        <tr>
            <td colspan="6" align="left" >
                <button class="edit" type="button" onclick="window.history.back(-1)">
                    <i class="fa fa-arrow-left"></i>
                    返回
                </button>
                <button class="remove" type="submit">
                    <i class="fa fa-save"></i>
                    提交
                </button>
            </td>
        </tr>
    </table>
    </form>
</div>
</body>
</html>

