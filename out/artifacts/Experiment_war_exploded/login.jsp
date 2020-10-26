<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <style type="text/css">
        *{
            margin: 0px;
            padding: 0px;
            font-family: "Microsoft YaHei UI";
        }
        html,body{
            background-image: url("/img/back.jpg");
            background-size: 100%,80%;
            height: 100%;
        }
        input{
            height: 35px;
            background-color: #F2F2FA;
            border: 0px;
            border-radius: 5px;
            width: 70%;
            left: 10%;
            right: 10%;
        }
        button{
            background-color: #467FE6;
            height: 35px;
            width: 60%;
            border: 0px;
            border-radius: 5px;
        }
        select{
            width: 60%;
            height: 35px;
            border-radius: 5px;
        }
        .Login{
            background-color: rgba(255,255,255,.4);
            top: 25%;
            position: absolute;
            bottom: 25%;
            left: 60%;
            right: 10%;
            border-radius: 5px;
        }
        .title,.b,.name,.s,.password,.message{
            position: absolute;
            width: 100%;
        }
        .title{
            text-align: center;
            top: 0%;
            bottom: 80%;
            font-size: 25px;
            font-weight: bold;
            padding-top: 10px;
        }
        .name{
            top: 20%;
            bottom: 60%;
            left: 10%;
        }
        .password{
            top: 40%;
            bottom: 40%;
            left: 10%;
        }
        .message{
            top: 95%;
            color: red;
            text-align: center;
        }
        .s{
            top: 60%;
            bottom: 20%;
            text-align: center;
        }
        .b{
            top: 80%;
            left:20%;
            right: 20%;
        }
    </style>
</head>
<body>
<div class="Login">
    <div class="title">
        实验管理系统
    </div>
    <form action="/login" method="post" id="loginForm">
        <div class="name">
            用户ID <input type="text" name="uid" id="uid" ><br>
        </div>
        <div class="password">
            密码   <input type="password" name="upwd" id="upwd" ><br>
        </div>
        <div class="s">
            <select name="type">
                <option value="">请选择登录类型</option>
                <option value="1">实验员</option>
                <option value="2">实验管理员</option>
            </select>
        </div>
        <div class="message">
            <span id="msg" >${messageModel.msg}</span><br>
        </div>
        <div class="b">
            <button type="button" id="loginBtn">登录</button>
        </div>
    </form>
</div>
</body>
<script type="text/javascript" src="js/jquery-3.5.1.js"></script>
<script type="text/javascript">
    $("#loginBtn").click(function () {
        var uid = $("#uid").val();
        var upwd = $("#upwd").val();
        if (isEmpty(uid)) {
            $("#msg").html("用户姓名不可为空");
            return;
        }
        if (isEmpty(upwd)) {
            $("#msg").html("用户密码不可为空");
            return;
        }
        $("#loginForm").submit();
    });
    /*
      判断是否为空，空返回true
      不空返回false
     */
    function isEmpty(str) {
        if(str==null||str.trim()=="")
        {
            return true;
        }
        return false;
    }
</script>
</html>
