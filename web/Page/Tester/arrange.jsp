<%--
  Created by IntelliJ IDEA.
  User: 张辰逸
  Date: 2020/10/23
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <script>
        $(function () {
            $('.remove').click(function(){
                if(confirm("确定要删除吗？")){
                    window.location.href="<%=basePath%>Tester?method=delete&id="+$(this).attr("keyword");
                }
            })
        })
    </script>
</head>
<body>
<%--<div class="condition">--%>
<%--    用户名：<input type="text" />--%>
<%--    用户名：<input type="text" />--%>
<%--    用户名：<input type="text" />--%>
<%--    <button>--%>
<%--        <i class="fa fa-search"></i>--%>
<%--        查询--%>
<%--    </button>--%>
<%--    <button onclick="window.location.href='Page/Tester/add.jsp'">--%>
<%--        <i class="fa fa-plus"></i>--%>
<%--        新增--%>
<%--    </button>--%>
<%--</div>--%>
<table class="tablelist">
    <thead>
    <tr>
        <%--        <td>课程ID</td>--%>
        <%--        <td>课程总人数</td>--%>
        <%--        <td>课程ID</td>--%>
        <%--        <td>任课教师</td>--%>
        <%--        <td>上课时间</td>--%>
        <%--        <td>上课地点</td>--%>
        <%--        <td>批次</td>--%>
        <%--        <td>实验人数</td>--%>
        <td>课程ID</td>
        <td>实验总人数</td>
        <td>实验ID</td>
        <td>实验员姓名</td>
        <td>实验时间</td>
        <td>实验教室</td>
        <td>实验批次</td>
        <td>当前实验人数</td>
    </tr>
    </thead>
    <c:forEach items="${requestScope.pagebean.list}" var="class_schedule">
        <tr>
            <td>${class_schedule.course_id}</td>
            <td>${class_schedule.total_number}</td>
            <td>${class_schedule.experiment_id}</td>
            <td>${class_schedule.name}</td>
            <td>${class_schedule.experiment_time}</td>
            <td>${class_schedule.experiment_room}</td>
            <td>${class_schedule.batch}</td>
            <td>${class_schedule.stu_number}</td>
        </tr>
    </c:forEach>
</table>
<table class="page">
    <td>
        <button onclick="window.location.href='<%=basePath%>Tester?method=course&pageNo=1'">首页</button>
        <button onclick="window.location.href='<%=basePath%>Tester?method=course&pageNo=${requestScope.pagebean.pageNo-1}'">上一页</button>
        <button onclick="window.location.href='<%=basePath%>Tester?method=course&pageNo=${requestScope.pagebean.pageNo+1}'">下一页</button>
        <button onclick="window.location.href='<%=basePath%>Tester?method=course&pageNo=${requestScope.pagebean.pageTotal}'">尾页</button>
        <input id="pageinput" type="text" class="page_no" name="pageNo" />
        <button id="searchPage">跳转</button>
        总记录条数${requestScope.pagebean.pageTotalCount}条，当前${requestScope.pagebean.pageNo}/${requestScope.pagebean.pageTotal}页 每页${requestScope.pagebean.pageSize}条数据
    </td>
</table>
</body>
</html>
