package com.xidian.Mapper;

import com.xidian.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuPageMapper {
    public int findTotalCount();
    public int find1TotalCount(Integer id);
    public int find2TotalCount(Integer id);
    public int findTTotalCount(Integer id);
    public int findExTotalCount();
    public int findETotalCount();
    public int findExpTotalCount();
    public int findLaTotalCount();
    public int findExperTotalCount();
    public List<Students> findPageItems(@Param("begin") Integer begin, @Param("pageSize") Integer pageSize);
    public List<Students> find1PageItems(@Param("id") Integer id,@Param("begin") Integer begin, @Param("pageSize") Integer pageSize);
    public List<Experiment_score> findExPageItems(@Param("begin") Integer begin, @Param("pageSize") Integer pageSize);
    public List<Experiment_score> find2PageItems(@Param("id") Integer id,@Param("begin") Integer begin, @Param("pageSize") Integer pageSize);
    public List<Experiment> findExpPageItems(@Param("begin") Integer begin, @Param("pageSize") Integer pageSize);
    public List<Laboratory> findLaPageItems(@Param("begin") Integer begin, @Param("pageSize") Integer pageSize);
    public List<Class_schedule> findTPageItems(@Param("id") Integer id,@Param("begin") Integer begin, @Param("pageSize") Integer pageSize);
    public List<Experimenter> findExperPageItems(@Param("begin") Integer begin, @Param("pageSize") Integer pageSize);
    public List<Class_schedule> findCsPageItems(@Param("begin") Integer begin, @Param("pageSize") Integer pageSize);
}
