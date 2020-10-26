package com.xidian.Mapper;

import com.xidian.pojo.Course;
import com.xidian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class CourseMapperTest {
    @Test
    public void addCourse(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        mapper.addCourse(new Course(15054038,"计算机组成原理", 12,
                "计0312，计0313","计算机科学与技术","第三学期"));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteCourse(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        mapper.deleteCourse(15054038);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getCourseList(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        List<Course> courseList = mapper.getCourseList();
        for (Course course:courseList) {
            System.out.println(course);
        }
        sqlSession.close();
    }

    @Test
    public void getCourseById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        Course course = mapper.getCourseById(15054037);
        System.out.println(course);
        sqlSession.close();
    }

}
