package com.xidian.Mapper;

import com.xidian.pojo.Experimenter;

import java.util.List;

public interface ExperimenterMapper {

    //增加实验员
    public void addExperimenter(Experimenter experimenter);

    //删除实验员
    public void deleteExperimenter(int id);

    //查看全部实验员
    public List<Experimenter> getExperimenterList();

    //查看指定工号实验员
    public Experimenter getExperimenterById(int id);
}
