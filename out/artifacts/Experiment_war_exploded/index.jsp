<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
  String Path =request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+Path+"/";
%>
<html>
<head>
  <meta charset="utf-8" />
  <title>系统首页</title>
  <link rel="stylesheet" href="<%=basePath%>css/style.css"/>
  <link rel="stylesheet" type="text/css" href="<%=basePath%>css/font-awesome-4.7.0/css/font-awesome.min.css" />
  <script type="text/javascript" src="<%=basePath%>js/jquery-3.5.1.min.js" ></script>
  <script type="text/javascript">
    $(function(){
      $('.menux p').click(function(){
        $(this).siblings('ul').slideUp(200);
        $(this).next('ul').slideToggle(200);
      })
      $('.menux ul a').click(function(){
        $('iframe').attr("src",$(this).attr("url"));
        $('.menu_title').html($(this).attr("title"));
      })
      $('.left .title b').click(function(){
        $('iframe').attr("src",$(this).attr("url"));
        $('.menu_title').html($(this).attr("title"));
      })
      $('.logout').click(function () {
        if(confirm("确定要退出吗？")){
            window.location.href="logout";
        }
      })
    })
  </script>
</head>

<body>
<div class="header">
  <div class="logo">实验管理系统</div>
  <div class="user">
    <i class="fa fa-caret-down point"></i>
    <i class="fa fa-user"></i>
    成员
    <ul>
      <li>
        <a href="javascript:void(0);" >
          修改密码
        </a>
      </li>
      <li>
        <a href="javascript:void(0);" >
          个人信息
        </a>
      </li>
      <li>
        <a href="javascript:void(0);"  class="logout">
          退出登录
        </a>
      </li>
    </ul>
  </div>
</div>
<div class="left">
  <div class="title">
    <b href="javascript:void(0);" url="main.jsp" title="系统功能">
      <i class="fa fa-home"></i>
      系统功能
    </b>
  </div>
  <div class="menux">
    <c:if test="${type == 2}">
    <p>
      <i class="fa fa-info-circle"></i>
      <i class="fa fa-angle-right point"></i>
      管理员</p>
      <ul>
        <li>
          <a href="javascript:void(0);" url="<%=basePath%>Admin?method=page" title="学生信息管理">
            <i class="fa fa-caret-right"></i>
            学生信息管理
          </a>
        </li>
        <li>
          <a href="javascript:void(0);" url="<%=basePath%>Admin?method=fill" title="学生成绩录入">
            <i class="fa fa-caret-right"></i>
            实验成绩录入
          </a>
        </li>
        <li>
          <a href="javascript:void(0);" url="<%=basePath%>Admin?method=form" title="实验课程信息">
            <i class="fa fa-caret-right"></i>
            实验课程信息
          </a>
        </li>
        <li>
          <a href="javascript:void(0);" url="<%=basePath%>Admin?method=form2" title="实验教室信息">
            <i class="fa fa-caret-right"></i>
            实验教室信息
          </a>
        </li>
        <li>
          <a href="javascript:void(0);" url="<%=basePath%>Admin?method=form1" title="实验员信息">
            <i class="fa fa-caret-right"></i>
            实验员信息
          </a>
        </li>
        <li>
          <a href="javascript:void(0);" url="<%=basePath%>Admin?method=course" title="实验课程安排">
            <i class="fa fa-caret-right"></i>
            实验课程安排
          </a>
        </li>
      </ul>
    </c:if>
    <c:if test="${type == 1}">
    <p>
      <i class="fa fa-info-circle"></i>
      <i class="fa fa-angle-right point"></i>
      实验员</p>
    <ul>
      <li>
        <a href="javascript:void(0);" url="<%=basePath%>Tester?method=page" title="学生信息管理">
          <i class="fa fa-caret-right"></i>
          学生信息管理
        </a>
      </li>
      <li>
        <a href="javascript:void(0);" url="<%=basePath%>Tester?method=fill" title="学生成绩录入">
          <i class="fa fa-caret-right"></i>
          实验成绩录入
        </a>
      </li>
      <li>
        <a href="javascript:void(0);" url="<%=basePath%>Tester?method=course" title="实验课程安排">
          <i class="fa fa-caret-right"></i>
          实验课程安排
        </a>
      </li>
    </ul>
    </c:if>
    <c:if test="${type == 3}">
    <p>
      <i class="fa fa-info-circle"></i>
      <i class="fa fa-angle-right point"></i>
      老师</p>
    <ul>
      <li>
        <a href="javascript:void(0);" url="1.html" title="子功能1">
          <i class="fa fa-caret-right"></i>
          子功能7
        </a>
      </li>
      <li>
        <a href="javascript:void(0);" url="2.html" title="子功能2">
          <i class="fa fa-caret-right"></i>
          子功能8
        </a>
      </li>
      <li>
        <a href="javascript:void(0);" url="3.html" title="子功能3">
          <i class="fa fa-caret-right"></i>
          子功能9
        </a>
      </li>
    </ul>
    </c:if>
  </div>
</div>
<div class="main">
  <div class="location">
    <i class="fa fa-home"></i>
    <span class="menu_title">用户管理</span>
  </div>
  <iframe src="main.jsp" width="100%" height="90%" frameBorder="0"></iframe>
</div>
</body>

</html>
