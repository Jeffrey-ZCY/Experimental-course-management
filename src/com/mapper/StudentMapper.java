package com.mapper;

import com.entity.Student;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface StudentMapper {
    public void add(Student Student);
    public void delete(Integer id);
    public void update(Student Student);
    public List<Student> list();
    public Student findByIdAndTest(@Param("stunumber")Integer stunumber,@Param("testname")String testname);
    //public Student findByIdAndTest(Student student);
    public Student findByName(String name);
}
