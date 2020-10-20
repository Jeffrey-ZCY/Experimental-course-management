package com.controller;

import com.entity.PageBean;
import com.entity.Student;
import com.mapper.StudentMapper;
import com.service.LoginService;
import com.service.StudentService;
import com.util.GetSqlSession;
import com.util.StringUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Tester")
public class TesterServlet extends HttpServlet {
    private StudentService studentService = new StudentService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if("list".equals(method)){
            this.list(request, response);
        }
        else if("add".equals(method)){
            this.add(request, response);
        }
        else if("edit".equals(method)){
            this.find(request, response);
        }
        else if("editsubmit".equals(method)){

            this.editsubmit(request, response);
        }
        else if("delete".equals(method)){
            this.delete(request, response);
        }
        else if("page".equals(method)){
            String ss = request.getParameter("pageNo");
            if(StringUtil.isEmpty(ss)){
                ss = "1";
            }
            int s = Integer.valueOf(ss).intValue();
            System.out.println(s);
            PageBean<Student> pagebean = studentService.page(s);
            request.setAttribute("pagebean",pagebean);
            request.getRequestDispatcher("Page/Tester/list.jsp").forward(request,response);
        }
    }

    private void list(HttpServletRequest request, HttpServletResponse response){
        try {
            List<Student> list = new StudentService().Studentlist();
            request.setAttribute("list",list);
            request.getRequestDispatcher("Page/Tester/list.jsp").forward(request,response);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void find(HttpServletRequest request, HttpServletResponse response){
        try {
            String testname = request.getParameter("testname");
            Integer stunumber = Integer.parseInt(request.getParameter("id"));
            Student student = studentService.Studentfind(stunumber,testname);
            request.setAttribute("student",student);
            request.getRequestDispatcher("Page/Tester/update.jsp").forward(request,response);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response){
        try {
            Integer stunumber = Integer.parseInt(request.getParameter("id"));
            studentService.Studentdelete(stunumber);
            response.sendRedirect("Tester?method=list");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response){
        try {
            Integer stunumber = Integer.parseInt(request.getParameter("stunumber"));
            String testname = request.getParameter("testname");
            String stuclass = request.getParameter("stuclass");
            String stuname = request.getParameter("stuname");
            studentService.Studentadd(stuname,stunumber,stuclass,testname);
            response.sendRedirect("Tester?method=list");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void editsubmit(HttpServletRequest request, HttpServletResponse response){
        try {
            Integer stunumber = Integer.parseInt(request.getParameter("stunumber"));
            String testname = request.getParameter("testname");
            String stuclass = request.getParameter("stuclass");
            String stuname = request.getParameter("stuname");
            studentService.Studentupdate(stuname,stunumber,stuclass,testname);
            response.sendRedirect("Tester?method=list");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
