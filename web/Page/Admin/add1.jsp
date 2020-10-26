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
                    experiment_name:"required",
                    course_name:"required",
                    stu_id:"required",
                    stu_name:"required",
                    stu_class:"required",

                },
                messages:{
                    experiment_name:"实验名称不能为空",
                    course_name: "课程名称不能为空",
                    stu_id:"学生ID不能为空",
                    stu_name:"学生姓名不能为空",
                    stu_class:"班级不能为空",

                }
            })

        })
    </script>
</head>
<body>
<div class="add">
    <form id="addform" action="<%=basePath%>Admin?method=add1" method="post">
    <table class="add_table" style="width: 75%;">

        <tr>
            <td>实验名称</td>
            <td style="color: red"><input type="text" name="experiment_name" value="${experiment_score.experiment_name}"></td>
        </tr>
        <tr>
            <td>课程名称</td>
            <td style="color: red"><input type="text" name="course_name" value="${experiment_score.course_name}"></td>
        </tr>
        <tr>
            <td>学号</td>
            <td style="color: red"><input type="text" name="stu_id" value="${experiment_score.stu_id}"></td>
        </tr>
        <tr>
            <td>学生姓名</td>
            <td style="color: red"><input type="text" name="stu_name" value="${experiment_score.stu_name}"></td>
        </tr>
        <tr>
            <td>班级</td>
            <td style="color: red"><input type="text" name="stu_class" value="${experiment_score.stu_class}"></td>
        </tr>
        <tr>
            <td>实验成绩</td>
            <td style="color: red"><input type="text" name="experiment_score" value="${experiment_score.experiment_score}"></td>
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

