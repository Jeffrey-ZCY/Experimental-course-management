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
            $("#editform").validate({
                rules:{
                    course_id:"required",
                    experiment_id:"required",
                    experiment_name:"required",
                    experiment_category:"required",
                    difficulty:"required",
                    hours:"required",
                    schedule_weeks:"required"
                },
                messages:{
                    course_id:"required",
                    experiment_id:"required",
                    experiment_name:"required",
                    experiment_category:"required",
                    difficulty:"required",
                    hours:"required",
                    schedule_weeks:"required"
                }
            })

        })
    </script>
</head>
<body>
<div class="add">
    <form id="editform" action="<%=basePath%>Admin?method=editsubmit2" method="post">
        <%--        <input type="hidden" name="id" value="${students.stu_id}"></td>--%>
        <table class="add_table" style="width: 75%;">
            <tr>
                <td>课程ID</td>
                <td style="color: red"><input type="text" name="course_id" value="${experiment.course_id}"></td>
            </tr>
            <tr>
                <td>实验ID</td>
                <td style="color: red"><input type="text" name="experiment_id" value="${experiment.experiment_id}"></td>
            </tr>
            <tr>
                <td>实验名称</td>
                <td style="color: red"><input type="text" name="experiment_name" value="${experiment.experiment_name}"></td>
            </tr>
            <tr>
                <td>实验类别</td>
                <td style="color: red"><input type="text" name="experiment_category" value="${experiment.experiment_category}"></td>
            </tr>
            <tr>
                <td>实验难度</td>
                <td style="color: red"><input type="text" name="difficulty" value="${experiment.difficulty}"></td>
            </tr>
            <tr>
                <td>实验学时</td>
                <td style="color: red"><input type="text" name="hours" value="${experiment.hours}"></td>
            </tr>
            <tr>
                <td>实验周次</td>
                <td style="color: red"><input type="text" name="schedule_weeks" value="${experiment.schedule_weeks}"></td>
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


