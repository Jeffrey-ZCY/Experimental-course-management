package com.xidian.Mapper;

import com.xidian.pojo.Experiment_score;

public interface Experiment_scoreMapper {

    //初始化列表，仅供程序调用,插入分数应当为0
    public void addScoreList(Experiment_score score);

    //获取已有的数据，其中分数为0，便于生成带分数的数据
    public Experiment_score getExperiment_score(int stu_id);

    //实验员打分
    public void updateScore(Experiment_score score);
}
