package com.xidian.Mapper;

import com.xidian.pojo.Course;

import java.util.List;

public interface CourseMapper {

    //增加课程
    public void addCourse(Course course);

    //删除课程
    public void deleteCourse(int course_id);

    //查看全部课程
    public List<Course> getCourseList();

    //查看指定编号课程
    public Course getCourseById(int course_id);

}
