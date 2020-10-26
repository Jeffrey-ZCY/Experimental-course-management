package com.xidian.controller;

import com.xidian.Mapper.Class_scheduleMapper;
import com.xidian.Mapper.ExperimentMapper;
import com.xidian.Mapper.Experiment_scoreMapper;
import com.xidian.Mapper.StudentsMapper;
import com.xidian.pojo.*;
import com.xidian.service.Adminservice;
import com.xidian.service.StudentService;
import com.xidian.utils.GetSqlSession;
import com.xidian.utils.Schedule;
import com.xidian.utils.StringUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Admin")
public class AdminServlet extends HttpServlet {
    private Adminservice adminservice = new Adminservice();
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
        else if("add1".equals(method)){
            this.add1(request, response);
        }
        else if("add2".equals(method)){
            this.add2(request, response);
        }
        else if("add3".equals(method)){
            this.add3(request, response);
        }
        else if("edit".equals(method)){
            this.find(request, response);
        }
        else if("edit1".equals(method)){
            this.find1(request, response);
        }
        else if("edit2".equals(method)){
            this.find2(request, response);
        }
        else if("editsubmit".equals(method)){

            this.editsubmit(request, response);
        }
        else if("editsubmit1".equals(method)){

            this.editsubmit1(request, response);
        }
        else if("editsubmit2".equals(method)){

            this.editsubmit2(request, response);
        }
        else if("delete".equals(method)){
            this.delete(request, response);
        }
        else if("delete1".equals(method)){
           try {
                Integer stunumber = Integer.parseInt(request.getParameter("id"));
                SqlSession session = GetSqlSession.createSqlSession();

                 session.commit();
                 session.close();
                response.sendRedirect("Admin?method=fill");
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else if("delete2".equals(method)){
            try {
                Integer stunumber = Integer.parseInt(request.getParameter("id"));
                SqlSession session = GetSqlSession.createSqlSession();
                Class_scheduleMapper class_scheduleMapper = session.getMapper(Class_scheduleMapper.class);
                class_scheduleMapper.deleteClassSchedule(stunumber);
                session.commit();
                session.close();
                response.sendRedirect("Admin?method=course");
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else if("delete3".equals(method)){
            try {
                Integer stunumber = Integer.parseInt(request.getParameter("id"));
                SqlSession session = GetSqlSession.createSqlSession();
                ExperimentMapper experimentMapper = session.getMapper(ExperimentMapper.class);
                experimentMapper.deleteExperiment(stunumber);
                session.commit();
                session.close();
                response.sendRedirect("Admin?method=form");
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else if("form".equals(method)){
            String ss = request.getParameter("pageNo");
            if(StringUtil.isEmpty(ss)){
                ss = "1";
            }
            int s = Integer.valueOf(ss).intValue();
            //System.out.println(s);
            PageBean<Experiment> pagebean = adminservice.page3(s);
            request.setAttribute("pagebean",pagebean);
            request.getRequestDispatcher("Page/Admin/form.jsp").forward(request,response);
        }
        else if("form1".equals(method)){
            String ss = request.getParameter("pageNo");
            if(StringUtil.isEmpty(ss)){
                ss = "1";
            }
            int s = Integer.valueOf(ss).intValue();
            //System.out.println(s);
            PageBean<Experimenter> pagebean = adminservice.page4(s);
            request.setAttribute("pagebean",pagebean);
            request.getRequestDispatcher("Page/Admin/form1.jsp").forward(request,response);
        }
        else if("form2".equals(method)){
            String ss = request.getParameter("pageNo");
            if(StringUtil.isEmpty(ss)){
                ss = "1";
            }
            int s = Integer.valueOf(ss).intValue();
            //System.out.println(s);
            PageBean<Laboratory> pagebean = adminservice.page5(s);
            request.setAttribute("pagebean",pagebean);
            request.getRequestDispatcher("Page/Admin/form2.jsp").forward(request,response);
        }
        else if("arrange".equals(method)){
            Schedule.scheduling();
            response.sendRedirect("Admin?method=course");
        }
        else if("course".equals(method)){
            String ss = request.getParameter("pageNo");
            if(StringUtil.isEmpty(ss)){
                ss = "1";
            }
            int s = Integer.valueOf(ss).intValue();
            PageBean<Class_schedule> pagebean = adminservice.page2(s);
            request.setAttribute("pagebean",pagebean);
            request.getRequestDispatcher("Page/Admin/arrange.jsp").forward(request,response);
        }
        else if("fill".equals(method)){
            String ss = request.getParameter("pageNo");
            if(StringUtil.isEmpty(ss)){
                ss = "1";
            }
            int s = Integer.valueOf(ss).intValue();
            //System.out.println(s);
            PageBean<Experiment_score> pagebean = adminservice.page1(s);
            request.setAttribute("pagebean",pagebean);
            request.getRequestDispatcher("Page/Admin/fill.jsp").forward(request,response);
        }
        else if("page".equals(method)){
            String ss = request.getParameter("pageNo");
            if(StringUtil.isEmpty(ss)){
                ss = "1";
            }
            int s = Integer.valueOf(ss).intValue();
            //System.out.println(s);
            PageBean<Students> pagebean = adminservice.page(s);
            request.setAttribute("pagebean",pagebean);
            request.getRequestDispatcher("Page/Admin/list.jsp").forward(request,response);
        }
    }

    private void list(HttpServletRequest request, HttpServletResponse response){
        try {
            List<Students> list = new Adminservice().Studentlist();
            request.setAttribute("list",list);
            request.getRequestDispatcher("Page/Admin/list.jsp").forward(request,response);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void find2(HttpServletRequest request, HttpServletResponse response){
        try {
            Integer experiment_id = Integer.parseInt(request.getParameter("id"));
            SqlSession session = GetSqlSession.createSqlSession();
            ExperimentMapper experimentMapper = session.getMapper(ExperimentMapper.class);
            Experiment experiment= experimentMapper.getExperimentById(experiment_id);
            request.setAttribute("experiment",experiment);
            request.getRequestDispatcher("Page/Admin/update2.jsp").forward(request,response);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void find1(HttpServletRequest request, HttpServletResponse response){
        try {
            Integer stunumber = Integer.parseInt(request.getParameter("id"));
            Experiment_score experiment_score = adminservice.Experiment_scorefind(stunumber);
            request.setAttribute("experiment_score",experiment_score);
            request.getRequestDispatcher("Page/Admin/update1.jsp").forward(request,response);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void find(HttpServletRequest request, HttpServletResponse response){
        try {
            Integer stunumber = Integer.parseInt(request.getParameter("id"));
            Students students = adminservice.Studentfind(stunumber);
            //System.out.println(student);
            request.setAttribute("students",students);
            request.getRequestDispatcher("Page/Admin/update.jsp").forward(request,response);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response){
        try {
            Integer stunumber = Integer.parseInt(request.getParameter("id"));
            adminservice.Studentdelete(stunumber);
            response.sendRedirect("Admin?method=page");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    private void add(HttpServletRequest request, HttpServletResponse response){
        try {
            Integer stu_id = Integer.parseInt(request.getParameter("stu_id"));
            Integer course_id  = Integer.parseInt(request.getParameter("course_id"));
            String stu_class = request.getParameter("stu_class");
            Integer experiment_id = Integer.parseInt(request.getParameter("experiment_id"));
            adminservice.Studentadd(stu_id,stu_class,course_id,experiment_id);
            response.sendRedirect("Admin?method=page");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    private void add1(HttpServletRequest request, HttpServletResponse response){
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
            experiment_scoreMapper.addScoreList(experiment_score1);
            System.out.println(experiment_score1);
            session.commit();
            session.close();
            response.sendRedirect("Admin?method=fill");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void add2(HttpServletRequest request, HttpServletResponse response){
        try {
            String name = request.getParameter("name");
            String experiment_time = request.getParameter("experiment_time");
            Integer course_id = Integer.parseInt(request.getParameter("course_id"));
            Integer total_number = Integer.parseInt(request.getParameter("total_number"));
            Integer experiment_id = Integer.parseInt(request.getParameter("experiment_id"));
            Integer experiment_room = Integer.parseInt(request.getParameter("experiment_room"));
            Integer batch = Integer.parseInt(request.getParameter("batch"));
            Integer stu_number = Integer.parseInt(request.getParameter("stu_number"));
            SqlSession session = GetSqlSession.createSqlSession();
            Class_scheduleMapper class_scheduleMapper=session.getMapper(Class_scheduleMapper.class);
            Class_schedule class_schedule = new Class_schedule();
            class_schedule.setStu_number(stu_number);
            class_schedule.setBatch(batch);
            class_schedule.setCourse_id(course_id);
            class_schedule.setExperiment_id(experiment_id);
            class_schedule.setExperiment_room(experiment_room);
            class_schedule.setExperiment_time(experiment_time);
            class_schedule.setTotal_number(total_number);
            class_schedule.setName(name);
            class_scheduleMapper.addClassSchedule(class_schedule);
            session.commit();
            session.close();
            response.sendRedirect("Admin?method=form");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void add3(HttpServletRequest request, HttpServletResponse response){
        try {
            Integer course_id  = Integer.parseInt(request.getParameter("course_id"));
            String experiment_category = request.getParameter("experiment_category");
            String experiment_name = request.getParameter("experiment_name");
            Integer experiment_id = Integer.parseInt(request.getParameter("experiment_id"));
            Integer hours = Integer.parseInt(request.getParameter("hours"));
            Integer difficulty = Integer.parseInt(request.getParameter("difficulty"));
            Integer schedule_weeks = Integer.parseInt(request.getParameter("schedule_weeks"));
            SqlSession session = GetSqlSession.createSqlSession();
            ExperimentMapper experimentMapper = session.getMapper(ExperimentMapper.class);
            Experiment experiment=new Experiment();
            experiment.setCourse_id(course_id);
            experiment.setDifficulty(difficulty);
            experiment.setExperiment_category(experiment_category);
            experiment.setExperiment_id(experiment_id);
            experiment.setExperiment_name(experiment_name);
            experiment.setHours(hours);
            experiment.setSchedule_weeks(schedule_weeks);
            experimentMapper.addExperiment(experiment);
            session.commit();
            session.close();
            response.sendRedirect("Admin?method=form");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    private void editsubmit(HttpServletRequest request, HttpServletResponse response){
        try {
            Integer stu_id = Integer.parseInt(request.getParameter("stu_id"));
            Integer course_id  = Integer.parseInt(request.getParameter("course_id"));
            String stu_class = request.getParameter("stu_class");
            Integer experiment_id = Integer.parseInt(request.getParameter("experiment_id"));
            Integer total_score = Integer.parseInt(request.getParameter("total_score"));
            SqlSession session = GetSqlSession.createSqlSession();
            StudentsMapper studentsMapper = session.getMapper(StudentsMapper.class);
            Students students = new Students();
            students.setStu_id(stu_id);
            students.setStu_class(stu_class);
            students.setCourse_id(course_id);
            students.setExperiment_id(experiment_id);
            students.setTotal_score(total_score);
            studentsMapper.updateStudent(students);
            session.commit();
            session.close();
            response.sendRedirect("Admin?method=page");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void editsubmit2(HttpServletRequest request, HttpServletResponse response){
        try {
            Integer course_id  = Integer.parseInt(request.getParameter("course_id"));
            String experiment_category = request.getParameter("experiment_category");
            String experiment_name = request.getParameter("experiment_name");
            Integer experiment_id = Integer.parseInt(request.getParameter("experiment_id"));
            Integer hours = Integer.parseInt(request.getParameter("hours"));
            Integer difficulty = Integer.parseInt(request.getParameter("difficulty"));
            Integer schedule_weeks = Integer.parseInt(request.getParameter("schedule_weeks"));
            SqlSession session = GetSqlSession.createSqlSession();
            ExperimentMapper experimentMapper = session.getMapper(ExperimentMapper.class);
            Experiment experiment=new Experiment();
            experiment.setCourse_id(course_id);
            experiment.setDifficulty(difficulty);
            experiment.setExperiment_category(experiment_category);
            experiment.setExperiment_id(experiment_id);
            experiment.setExperiment_name(experiment_name);
            experiment.setHours(hours);
            experiment.setSchedule_weeks(schedule_weeks);
            experimentMapper.addExperiment(experiment);
            session.commit();
            session.close();
            response.sendRedirect("Admin?method=page");
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
            response.sendRedirect("Admin?method=fill");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
