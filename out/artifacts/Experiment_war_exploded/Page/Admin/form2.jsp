<%--
  Created by IntelliJ IDEA.
  User: 张辰逸
  Date: 2020/9/24
  Time: 14:27
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
                    window.location.href="<%=basePath%>Admin?method=delete&id="+$(this).attr("keyword");
                }
            })
        })
    </script>
</head>
<body>
<table class="tablelist">
    <thead>
    <tr>
        <td>实验教室</td>
        <td>实验人数</td>

    </tr>
    </thead>
    <c:forEach items="${requestScope.pagebean.list}" var="laboratory">
        <tr>
            <td>${laboratory.room}</td>
            <td>${laboratory.number}</td>
        </tr>
    </c:forEach>
</table>
<table class="page">
    <td>
        <button onclick="window.location.href='<%=basePath%>Admin?method=form2&pageNo=1'">首页</button>
        <button onclick="window.location.href='<%=basePath%>Admin?method=form2&pageNo=${requestScope.pagebean.pageNo-1}'">上一页</button>
        <button onclick="window.location.href='<%=basePath%>Admin?method=form2&pageNo=${requestScope.pagebean.pageNo+1}'">下一页</button>
        <button onclick="window.location.href='<%=basePath%>Admin?method=form2&pageNo=${requestScope.pagebean.pageTotal}'">尾页</button>
        <input id="pageinput" type="text" class="page_no" name="pageNo" />
        <button id="searchPage">跳转</button>
        总记录条数${requestScope.pagebean.pageTotalCount}条，当前${requestScope.pagebean.pageNo}/${requestScope.pagebean.pageTotal}页 每页${requestScope.pagebean.pageSize}条数据
    </td>
</table>
</body>

</html>
