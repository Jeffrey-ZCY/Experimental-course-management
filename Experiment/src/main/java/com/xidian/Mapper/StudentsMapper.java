package com.xidian.Mapper;


import com.xidian.pojo.Students;

import java.util.List;

public interface StudentsMapper {
    //增加学生成绩单
    public void addStudent(Students students);

    //删除学生成绩单
    public void deleteStudents(int stu_id);

    //查看全部学生成绩单
    public List<Students> getStudentsList();

    //查看指定学号的学生成绩单
    public Students getStudentById(int stu_id);
}
