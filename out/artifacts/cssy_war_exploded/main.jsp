<%--
  Created by IntelliJ IDEA.
  User: 黄海槟
  Date: 2020/9/23
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" type="text/css" href="css/font-awesome-4.7.0/css/font-awesome.min.css" />
    <script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
</head>
<body>
<div class="condition">
    用户名：<input type="text" />
    用户名：<input type="text" />
    用户名：<input type="text" />
    <button>
        <i class="fa fa-search"></i>
        查询
    </button>
    <button onclick="window.location.href='add.jsp'">
        <i class="fa fa-plus"></i>
        新增
    </button>
</div>
<table class="tablelist">
    <thead>
    <tr>
        <th>姓名</th>
        <th>姓名</th>
        <th>姓名</th>
        <th>姓名</th>
        <th width="120px">操作</th>
    </tr>
    </thead>
    <tr>
        <td>姓名</td>
        <td>姓名</td>
        <td>姓名</td>
        <td>姓名</td>
        <td>
            <button class="edit">
                <i class="fa fa-edit"></i>
                修改
            </button>
            <button class="remove">
                <i class="fa fa-remove"></i>
                删除
            </button>
        </td>
    </tr>
    <tr>
        <td>姓名</td>
        <td>姓名</td>
        <td>姓名</td>
        <td>姓名</td>
        <td>
            <button class="edit">
                <i class="fa fa-edit"></i>
                修改
            </button>
            <button class="remove">
                <i class="fa fa-remove"></i>
                删除
            </button>
        </td>
    </tr>
    <tr>
        <td>姓名</td>
        <td>姓名</td>
        <td>姓名</td>
        <td>姓名</td>
        <td>
            <button class="edit">
                <i class="fa fa-edit"></i>
                修改
            </button>
            <button class="remove">
                <i class="fa fa-remove"></i>
                删除
            </button>
        </td>
    </tr>
    <tr>
        <td>姓名</td>
        <td>姓名</td>
        <td>姓名</td>
        <td>姓名</td>
        <td>
            <button class="edit">
                <i class="fa fa-edit"></i>
                修改
            </button>
            <button class="remove">
                <i class="fa fa-remove"></i>
                删除
            </button>
        </td>
    </tr>
    <tr>
        <td>姓名</td>
        <td>姓名</td>
        <td>姓名</td>
        <td>姓名</td>
        <td>
            <button class="edit">
                <i class="fa fa-edit"></i>
                修改
            </button>
            <button class="remove">
                <i class="fa fa-remove"></i>
                删除
            </button>
        </td>
    </tr>
</table>
<table class="page">
    <td>
        <button>首页</button>
        <button>下一页</button>
        <button>上一页</button>
        <button>尾页</button>
        <input type="text" class="page_no" name="pageNo" />
        <button>跳转</button>
    </td>
</table>
</body>
</html>
