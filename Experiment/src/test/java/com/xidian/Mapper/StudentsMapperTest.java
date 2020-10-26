package com.xidian.Mapper;

import com.xidian.pojo.Students;
import com.xidian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class StudentsMapperTest {
    @Test
    public void addStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentsMapper mapper = sqlSession.getMapper(StudentsMapper.class);
        mapper.addStudent(new Students(16,"计0312",15054038,
                1505403801,50));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteStudents(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentsMapper mapper = sqlSession.getMapper(StudentsMapper.class);
        mapper.deleteStudents(16);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getStudentsList(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentsMapper mapper = sqlSession.getMapper(StudentsMapper.class);
        List<Students> studentsList = mapper.getStudentsList();
        for(Students student:studentsList){
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void getStudentById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentsMapper mapper = sqlSession.getMapper(StudentsMapper.class);
        Students student = mapper.getStudentById(11);
        System.out.println(student);
        sqlSession.close();

    }
}
