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
                    course_id:"required",
                    total_number:"required",
                    experiment_id:"required",
                    name:"required",
                    experiment_time:"required",
                    experiment_room:"required",
                    batch:"required",
                    stu_number:"required",
                },
                messages:{
                    course_id:"课程名称不能为空",
                    total_number:"实验总人数不能为空",
                    experiment_id:"实验名称不能为空",
                    name:"实验员姓名不能为空",
                    experiment_time:"实验时间不能为空",
                    experiment_room:"实验教室不能为空",
                    batch:"实验批次不能为空",
                    stu_number:"当前实验人数不能为空"
                }
            })

        })
    </script>
</head>
<body>
<div class="add">
    <form id="addform" action="<%=basePath%>Admin?method=add2" method="post">
    <table class="add_table" style="width: 75%;">

        <tr>
            <td>课程ID</td>
            <td style="color: red"><input type="text" name="course_id" value="${class_schedule.course_id}"></td>
        </tr>
        <tr>
            <td>实验总人数</td>
            <td style="color: red"><input type="text" name="total_number" value="${class_schedule.total_number}"></td>
        </tr>
        <tr>
            <td>实验ID</td>
            <td style="color: red"><input type="text" name="experiment_id" value="${class_schedule.experiment_id}"></td>
        </tr>
        <tr>
            <td>实验员姓名</td>
            <td style="color: red"><input type="text" name="name" value="${class_schedule.name}"></td>
        </tr>
        <tr>
            <td>实验时间</td>
            <td style="color: red"><input type="text" name="experiment_time" value="${class_schedule.experiment_time}"></td>
        </tr>
        <tr>
            <td>实验教室</td>
            <td style="color: red"><input type="text" name="experiment_room" value="${class_schedule.experimemt_room}"></td>
        </tr>
        <tr>
            <td>实验批次</td>
            <td style="color: red"><input type="text" name="batch" value="${class_schedule.batch}"></td>
        </tr>
        <tr>
            <td>当前实验人数</td>
            <td style="color: red"><input type="text" name="stu_number" value="${class_schedule.stu_number}"></td>
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

