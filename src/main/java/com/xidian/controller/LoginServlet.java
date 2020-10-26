package com.xidian.controller;

import com.xidian.pojo.vo.MessageModel;
import com.xidian.service.LoginService;
import com.xidian.controller.Tester;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private LoginService loginService = new LoginService();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(1);
        Integer uid=Integer.parseInt(request.getParameter("uid"));
        Tester.uid = uid;
        String upwd=request.getParameter("upwd");
        String type = request.getParameter("type");
        MessageModel messageModel=loginService.userLogin(uid,upwd,type);//判断当前的uid和upwd
        if(messageModel.getCode()==1&&"1".equals(type))
        { //登录成功
            request.getSession().setAttribute("user",messageModel.getObject());
            request.getSession().setAttribute("type",type);
            response.sendRedirect("index.jsp");
            System.out.println("实验员");
        }
        else if(messageModel.getCode()==1&&"2".equals(type))
        { //登录成功
            request.getSession().setAttribute("user",messageModel.getObject());
            request.getSession().setAttribute("type",type);
            response.sendRedirect("index.jsp");
            System.out.println("实验管理员");
        }
        else
        {//登录失败
            request.setAttribute("messageModel",messageModel);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }

}
