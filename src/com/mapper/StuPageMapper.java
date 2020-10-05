package com.mapper;

import com.entity.PageBean;
import com.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuPageMapper {
    public int findTotalCount();
    public List<Student> findPageItems(@Param("begin")Integer begin, @Param("pageSize")Integer pageSize);
}
