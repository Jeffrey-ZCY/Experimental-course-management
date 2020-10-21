package com.xidian.Mapper;

import com.xidian.pojo.Experiment;

import java.util.List;

public interface ExperimentMapper {

    //增加实验
    public void addExperiment(Experiment experiment);

    //删除实验
    public void deleteExperiment(int experiment_id);

    //查看全部实验
    public List<Experiment> getExperimentList();

    //查看指定编号实验
    public Experiment getExperimentById(int experiment_id);

}
