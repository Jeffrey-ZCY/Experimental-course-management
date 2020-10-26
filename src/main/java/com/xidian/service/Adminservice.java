package com.xidian.service;

import com.xidian.Mapper.Experiment_scoreMapper;
import com.xidian.pojo.*;
import com.xidian.Mapper.StuPageMapper;
import com.xidian.Mapper.StudentsMapper;
import com.xidian.utils.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Adminservice {
        public List<Students> Studentlist()
        {
            SqlSession session = GetSqlSession.createSqlSession();
            StudentsMapper studentsMapper = session.getMapper(StudentsMapper.class);
            List<Students> list = studentsMapper.getStudentsList();
            return list;
        }

        public Experiment_score Experiment_scorefind(Integer id)
        {
            SqlSession session = GetSqlSession.createSqlSession();
            Experiment_scoreMapper experiment_scoreMapper = session.getMapper(Experiment_scoreMapper.class);
            Experiment_score experiment_score= experiment_scoreMapper.getExperiment_score(id);
            return experiment_score;
        }

        public Students Studentfind(Integer id)
        {
            SqlSession session = GetSqlSession.createSqlSession();
            StudentsMapper studentMapper = session.getMapper(StudentsMapper.class);
            Students students= studentMapper.getStudentById(id);
            return students;
        }

        public void Studentdelete(Integer id)
        {
            SqlSession session = GetSqlSession.createSqlSession();
            StudentsMapper studentsMapper = session.getMapper(StudentsMapper.class);
            studentsMapper.deleteStudents(id);
            session.commit();
            session.close();
        }

        public void Studentadd(Integer id,String stu_class,Integer course_id,Integer experiment_id)
        {
            SqlSession session = GetSqlSession.createSqlSession();
            StudentsMapper studentsMapper = session.getMapper(StudentsMapper.class);
            Students students = new Students();
            students.setStu_id(id);
            students.setStu_class(stu_class);
            students.setCourse_id(course_id);
            students.setExperiment_id(experiment_id);
            studentsMapper.addStudent(students);
            session.commit();
            session.close();
        }

        public PageBean<Students> page(Integer pageNo){
            SqlSession session = GetSqlSession.createSqlSession();
            StuPageMapper stuPageMapper = session.getMapper(StuPageMapper.class);
            PageBean<Students> pagebean = new PageBean<Students>();
            pagebean.setPageNo(pageNo);
            Integer pageTotalCount = stuPageMapper.findTotalCount();
            pagebean.setPageTotalCount(pageTotalCount);
            Integer pageTotal = pageTotalCount/pagebean.getPageSize();
            if((pageTotalCount%pagebean.getPageSize()) > 0){
                pageTotal++;
            }
            pagebean.setPageTotal(pageTotal);
            if(pageNo < 1){
                pageNo = 1;
            }
            if(pageNo > pageTotal){
                pageNo = pageTotal;
            }
            pagebean.setPageNo(pageNo);
            int begin=(pagebean.getPageNo()-1)*pagebean.getPageSize();
            List<Students> list = stuPageMapper.findPageItems(begin,pagebean.getPageSize());
            pagebean.setList(list);
            return pagebean;
        }

        public PageBean<Experiment> page3(Integer pageNo){
            SqlSession session = GetSqlSession.createSqlSession();
            StuPageMapper stuPageMapper = session.getMapper(StuPageMapper.class);
            PageBean<Experiment> pagebean = new PageBean<Experiment>();
            pagebean.setPageNo(pageNo);
            Integer pageTotalCount = stuPageMapper.findExpTotalCount();
            pagebean.setPageTotalCount(pageTotalCount);
            Integer pageTotal = pageTotalCount/pagebean.getPageSize();
            if((pageTotalCount%pagebean.getPageSize()) > 0){
                pageTotal++;
            }
            pagebean.setPageTotal(pageTotal);
            if(pageNo < 1){
                pageNo = 1;
            }
            if(pageNo > pageTotal){
                pageNo = pageTotal;
            }
            pagebean.setPageNo(pageNo);
            int begin=(pagebean.getPageNo()-1)*pagebean.getPageSize();
            List<Experiment> list = stuPageMapper.findExpPageItems(begin,pagebean.getPageSize());
            pagebean.setList(list);
            return pagebean;
        }

        public PageBean<Experimenter> page4(Integer pageNo){
            SqlSession session = GetSqlSession.createSqlSession();
            StuPageMapper stuPageMapper = session.getMapper(StuPageMapper.class);
            PageBean<Experimenter> pagebean = new PageBean<Experimenter>();
            pagebean.setPageNo(pageNo);
            Integer pageTotalCount = stuPageMapper.findExperTotalCount();
            pagebean.setPageTotalCount(pageTotalCount);
            Integer pageTotal = pageTotalCount/pagebean.getPageSize();
            if((pageTotalCount%pagebean.getPageSize()) > 0){
                pageTotal++;
            }
            pagebean.setPageTotal(pageTotal);
            if(pageNo < 1){
                pageNo = 1;
            }
            if(pageNo > pageTotal){
                pageNo = pageTotal;
            }
            pagebean.setPageNo(pageNo);
            int begin=(pagebean.getPageNo()-1)*pagebean.getPageSize();
            List<Experimenter> list = stuPageMapper.findExperPageItems(begin,pagebean.getPageSize());
            pagebean.setList(list);
            return pagebean;
        }

    public PageBean<Laboratory> page5(Integer pageNo){
        SqlSession session = GetSqlSession.createSqlSession();
        StuPageMapper stuPageMapper = session.getMapper(StuPageMapper.class);
        PageBean<Laboratory> pagebean = new PageBean<Laboratory>();
        pagebean.setPageNo(pageNo);
        Integer pageTotalCount = stuPageMapper.findLaTotalCount();
        pagebean.setPageTotalCount(pageTotalCount);
        Integer pageTotal = pageTotalCount/pagebean.getPageSize();
        if((pageTotalCount%pagebean.getPageSize()) > 0){
            pageTotal++;
        }
        pagebean.setPageTotal(pageTotal);
        if(pageNo < 1){
            pageNo = 1;
        }
        if(pageNo > pageTotal){
            pageNo = pageTotal;
        }
        pagebean.setPageNo(pageNo);
        int begin=(pagebean.getPageNo()-1)*pagebean.getPageSize();
        List<Laboratory> list = stuPageMapper.findLaPageItems(begin,pagebean.getPageSize());
        pagebean.setList(list);
        return pagebean;
    }

        public PageBean<Experiment_score> page1(Integer pageNo){
            SqlSession session = GetSqlSession.createSqlSession();
            StuPageMapper stuPageMapper = session.getMapper(StuPageMapper.class);
            PageBean<Experiment_score> pagebean = new PageBean<Experiment_score>();
            pagebean.setPageNo(pageNo);
            Integer pageTotalCount = stuPageMapper.findExTotalCount();
            pagebean.setPageTotalCount(pageTotalCount);
            Integer pageTotal = pageTotalCount/pagebean.getPageSize();
            if((pageTotalCount%pagebean.getPageSize()) > 0){
                pageTotal++;
            }
            pagebean.setPageTotal(pageTotal);
            if(pageNo < 1){
                pageNo = 1;
            }
            if(pageNo > pageTotal){
                pageNo = pageTotal;
            }
            pagebean.setPageNo(pageNo);
            int begin=(pagebean.getPageNo()-1)*pagebean.getPageSize();
            List<Experiment_score> list = stuPageMapper.findExPageItems(begin,pagebean.getPageSize());
            pagebean.setList(list);
            return pagebean;
        }

        public PageBean<Class_schedule> page2(Integer pageNo){
            SqlSession session = GetSqlSession.createSqlSession();
            StuPageMapper stuPageMapper = session.getMapper(StuPageMapper.class);
            PageBean<Class_schedule> pagebean = new PageBean<Class_schedule>();
            pagebean.setPageNo(pageNo);
            Integer pageTotalCount = stuPageMapper.findETotalCount();
            pagebean.setPageTotalCount(pageTotalCount);
            Integer pageTotal = pageTotalCount/pagebean.getPageSize();
            if((pageTotalCount%pagebean.getPageSize()) > 0){
                pageTotal++;
            }
            pagebean.setPageTotal(pageTotal);
            if(pageNo < 1){
                pageNo = 1;
            }
            if(pageNo > pageTotal){
                pageNo = pageTotal;
            }
            pagebean.setPageNo(pageNo);
            int begin=(pagebean.getPageNo()-1)*pagebean.getPageSize();
            List<Class_schedule> list = stuPageMapper.findCsPageItems(begin,pagebean.getPageSize());
            pagebean.setList(list);
            return pagebean;
        }
}
