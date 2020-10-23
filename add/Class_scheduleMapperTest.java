package com.xidian.Mapper;

import com.xidian.pojo.Class_schedule;
import com.xidian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Class_scheduleMapperTest {

    @Test
    public void addClassSchedule(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Class_scheduleMapper mapper = sqlSession.getMapper(Class_scheduleMapper.class);
        Class_schedule schedule = new Class_schedule(15054037,200, 1505403701,
                "吴老师","第三周周四晚上",310,1,11);
        mapper.addClassSchedule(schedule);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteClassSchedule(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Class_scheduleMapper mapper = sqlSession.getMapper(Class_scheduleMapper.class);
        mapper.deleteClassSchedule(1505403701);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getClassScheduleList(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Class_scheduleMapper mapper = sqlSession.getMapper(Class_scheduleMapper.class);
        List<Class_schedule> list = mapper.getClassScheduleList();
        for (Class_schedule c:list) {
            System.out.println(c);
        }
        sqlSession.close();
    }

    @Test
    public void getClassScheduleById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Class_scheduleMapper mapper = sqlSession.getMapper(Class_scheduleMapper.class);
        Class_schedule classSchedule = mapper.getClassScheduleById(1505403701);
        System.out.println(classSchedule);
        sqlSession.close();
    }

    @Test
    public void deleteTable(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Class_scheduleMapper mapper = sqlSession.getMapper(Class_scheduleMapper.class);
        mapper.deleteTable();
        sqlSession.commit();
        sqlSession.close();
    }
}
