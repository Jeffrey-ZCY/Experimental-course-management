package com.xidian.utils;

import com.xidian.Mapper.Class_scheduleMapper;
import com.xidian.Mapper.ExperimentMapper;
import com.xidian.Mapper.ExperimenterMapper;
import com.xidian.Mapper.LaboratoryMapper;
import com.xidian.pojo.Class_schedule;
import com.xidian.pojo.Experiment;
import com.xidian.pojo.Experimenter;
import com.xidian.pojo.Laboratory;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Schedule {
    //使用此方法
    //我们在测试时，为数据库添加的学生人数较少，现在为了模拟大数量学生的排课，使用虚拟的学生人数200人
    public static void scheduling() {
        int total_number = 200;
        scheduling(total_number);
    }

    //最终实现
    public static void scheduling(int total_number) {
        try {
            //获取排课所需的信息 拿到Experiment Experimenter Laboratory的所有信息
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            ExperimentMapper mapper1 = sqlSession.getMapper(ExperimentMapper.class);
            List<Experiment> experimentList = mapper1.getExperimentList();
            ExperimenterMapper mapper2 = sqlSession.getMapper(ExperimenterMapper.class);
            List<Experimenter> experimenterList = mapper2.getExperimenterList();
            LaboratoryMapper mapper3 = sqlSession.getMapper(LaboratoryMapper.class);
            List<Laboratory> laboratoryList = mapper3.getLaboratoryList();
            //根据正常逻辑还应当从数据库学生表中获取到相关学生人数，现用虚拟人数代替
            //开始排课
            List<Class_schedule> list = new ArrayList<>();
            for (int i = 0; i < experimentList.size(); i++) {
                //计算批次
                int j = 0;
                int batch = 0;
                int t = total_number;
                int last = 0;
                while (t > 0) {
                    last = t;
                    t -= laboratoryList.get(j++).getNumber();
                    batch++;
                    if (j == laboratoryList.size())
                        j = 0;
                }
                int roomNumber = 0;
                if (batch > 7) {
                    System.out.println("学生人数过多无法在指定周次安排完所有实验");
                    System.exit(1);
                }
                for (int m = 0; m < batch; m++) {
                    Class_schedule schedule = new Class_schedule();
                    schedule.setCourse_id(experimentList.get(i).getCourse_id());
                    schedule.setTotal_number(total_number);
                    schedule.setExperiment_id(experimentList.get(i).getExperiment_id());
                    //随机分配实验员
                    Random random = new Random();
                    int r = random.nextInt(experimenterList.size());
                    schedule.setName(experimenterList.get(r).getName());
                    //批次
                    schedule.setBatch(m + 1);
                    //分配实验室
                    schedule.setExperiment_room(laboratoryList.get((roomNumber++) % laboratoryList.size()).getRoom());
                    //计算每批学生人数
                    if (schedule.getBatch() != batch) {
                        schedule.setStu_number(laboratoryList.get(roomNumber - 1).getNumber());
                    } else {
                        schedule.setStu_number(last);
                    }
                    //分配每次实验时间
                    int week = experimentList.get(i).getSchedule_weeks();
                    int weekTime = m + 1;
                    String time = "第" + week + "周" + "周" + weekTime + "晚上";
                    schedule.setExperiment_time(time);
                    list.add(schedule);
                }
            }
            Class_scheduleMapper mapper = sqlSession.getMapper(Class_scheduleMapper.class);
            for (Class_schedule schedule : list) {
                mapper.addClassSchedule(schedule);
            }
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {

        }

    }
}
