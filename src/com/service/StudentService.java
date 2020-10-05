package com.service;

import com.entity.PageBean;
import com.entity.Student;
import com.mapper.StuPageMapper;
import com.mapper.StudentMapper;
import com.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;


import java.util.List;

public class StudentService {
        public List<Student> Studentlist()
        {
            SqlSession session = GetSqlSession.createSqlSession();
            StudentMapper StudentMapper = session.getMapper(StudentMapper.class);
            List<Student> list = StudentMapper.list();
            return list;
        }

        public Student Studentfind(Integer id,String testname)
        {
            SqlSession session = GetSqlSession.createSqlSession();
            StudentMapper StudentMapper = session.getMapper(StudentMapper.class);
            Student student=StudentMapper.findByIdAndTest(id,testname);
            return student;
        }

        public void Studentdelete(Integer id)
        {
            SqlSession session = GetSqlSession.createSqlSession();
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            studentMapper.delete(id);
            session.commit();
            session.close();
        }

        public void Studentadd(String stuname,Integer id,String stuclass,String testname)
        {
            SqlSession session = GetSqlSession.createSqlSession();
            StudentMapper StudentMapper = session.getMapper(StudentMapper.class);
            Student student = new Student();
            student.setStuname(stuname);
            student.setStuclass(stuclass);
            student.setTestname(testname);
            student.setStunumber(id);
            StudentMapper.add(student);
            session.commit();
            session.close();
        }

        public void Studentupdate(String stuname,Integer id,String stuclass,String testname)
        {
            SqlSession session = GetSqlSession.createSqlSession();
            StudentMapper StudentMapper = session.getMapper(StudentMapper.class);
            Student student = new Student();
            student.setStuname(stuname);
            student.setStuclass(stuclass);
            student.setTestname(testname);
            student.setStunumber(id);
            StudentMapper.update(student);
            session.commit();
            session.close();
        }

        public PageBean<Student> page(Integer pageNo){
            SqlSession session = GetSqlSession.createSqlSession();
            StuPageMapper stuPageMapper = session.getMapper(StuPageMapper.class);
            PageBean<Student> pagebean = new PageBean<Student>();
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
            List<Student> list = stuPageMapper.findPageItems(begin,pagebean.getPageSize());
            pagebean.setList(list);
            return pagebean;
        }
}
