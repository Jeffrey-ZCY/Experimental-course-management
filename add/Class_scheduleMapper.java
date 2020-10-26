package com.xidian.Mapper;


import com.xidian.pojo.Class_schedule;

import java.util.List;

public interface Class_scheduleMapper {
    //增加排好的实验课表
    public void addClassSchedule(Class_schedule schedule);

    //删除实验课表
    public void deleteClassSchedule(int experiment_id);

    //查看全部排好的实验课表
    public List<Class_schedule> getClassScheduleList();

    //查看指定实验编号的课程安排
    public Class_schedule getClassScheduleById(int experiment_id);

    //删除表中的数据，但是保留结构
    public void deleteTable();
}
