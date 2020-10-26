package com.xidian.controller;

import com.xidian.Mapper.Experiment_scoreMapper;
import com.xidian.Mapper.StudentsMapper;
import com.xidian.pojo.*;
import com.xidian.service.StudentService;
import com.xidian.utils.GetSqlSession;
import com.xidian.utils.StringUtil;
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
        System.out.println(Tester.uid);
        Integer uid = Tester.uid;
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
        else if("edit1".equals(method)){
            this.find1(request, response);
        }
        else if("editsubmit".equals(method)){

            this.editsubmit(request, response);
        }
        else if("editsubmit1".equals(method)){

            this.editsubmit1(request, response);
        }
        else if("delete".equals(method)){
            this.delete(request, response);
        }
        else if("course".equals(method)){
            String ss = request.getParameter("pageNo");
            if(StringUtil.isEmpty(ss)){
                ss = "1";
            }
            int s = Integer.valueOf(ss).intValue();
            PageBean<Class_schedule> pagebean = studentService.page2(s,uid);
            request.setAttribute("pagebean",pagebean);
            request.getRequestDispatcher("Page/Tester/arrange.jsp").forward(request,response);
        }
        else if("fill".equals(method)){
            String ss = request.getParameter("pageNo");
            if(StringUtil.isEmpty(ss)){
                ss = "1";
            }
            int s = Integer.valueOf(ss).intValue();
            //System.out.println(s);
            PageBean<Experiment_score> pagebean = studentService.page1(s,uid);
            request.setAttribute("pagebean",pagebean);
            request.getRequestDispatcher("Page/Tester/fill.jsp").forward(request,response);
        }
        else if("page".equals(method)){
            String ss = request.getParameter("pageNo");
            if(StringUtil.isEmpty(ss)){
                ss = "1";
            }
            int s = Integer.valueOf(ss).intValue();
           //System.out.println(s);
            PageBean<Students> pagebean = studentService.page(s,uid);
            request.setAttribute("pagebean",pagebean);
            request.getRequestDispatcher("Page/Tester/list.jsp").forward(request,response);
        }
    }

    private void list(HttpServletRequest request, HttpServletResponse response){
        try {
            List<Students> list = new StudentService().Studentlist();
            request.setAttribute("list",list);
            request.getRequestDispatcher("Page/Tester/list.jsp").forward(request,response);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    private void find1(HttpServletRequest request, HttpServletResponse response){
        try {
            Integer stunumber = Integer.parseInt(request.getParameter("id"));
            Experiment_score experiment_score = studentService.Experiment_scorefind(stunumber);
            request.setAttribute("experiment_score",experiment_score);
            request.getRequestDispatcher("Page/Tester/update1.jsp").forward(request,response);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void find(HttpServletRequest request, HttpServletResponse response){
        try {
            Integer stunumber = Integer.parseInt(request.getParameter("id"));
            Students student = studentService.Studentfind(stunumber);
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
            Integer stu_id = Integer.parseInt(request.getParameter("id"));
            Integer course_id  = Integer.parseInt(request.getParameter("course_id"));
            String stu_class = request.getParameter("stu_class");
            Integer experiment_id = Integer.parseInt(request.getParameter("experiment_id"));
            studentService.Studentadd(stu_id,stu_class,course_id,experiment_id);
            response.sendRedirect("Tester?method=page");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void editsubmit(HttpServletRequest request, HttpServletResponse response){
        try {
            Integer stu_id = Integer.parseInt(request.getParameter("id"));
            Integer course_id  = Integer.parseInt(request.getParameter("course_id"));
            String stu_class = request.getParameter("stu_class");
            Integer experiment_id = Integer.parseInt(request.getParameter("experiment_id"));
            Integer total_score = Integer.parseInt(request.getParameter("total_score"));
            studentService.Studentupdate(stu_id,stu_class,course_id,experiment_id,total_score);
            response.sendRedirect("Tester?method=page");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void editsubmit1(HttpServletRequest request, HttpServletResponse response){
        try {
            Integer stu_id = Integer.parseInt(request.getParameter("stu_id"));
            String course_name  = request.getParameter("course_name");
            String stu_class = request.getParameter("stu_class");
            String stu_name = request.getParameter("stu_name");
            String experiment_name = request.getParameter("experiment_name");
            Integer experiment_score = Integer.parseInt(request.getParameter("experiment_score"));
            SqlSession session = GetSqlSession.createSqlSession();
            Experiment_scoreMapper experiment_scoreMapper=session.getMapper(Experiment_scoreMapper.class);
            Experiment_score experiment_score1= new Experiment_score();
            experiment_score1.setCourse_name(course_name);
            experiment_score1.setExperiment_name(experiment_name);
            experiment_score1.setExperiment_score(experiment_score);
            experiment_score1.setStu_class(stu_class);
            experiment_score1.setStu_id(stu_id);
            experiment_score1.setStu_name(stu_name);
            experiment_scoreMapper.update(experiment_score1);
            session.commit();
            session.close();
            response.sendRedirect("Tester?method=fill");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
