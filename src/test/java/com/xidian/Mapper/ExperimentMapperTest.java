package com.xidian.Mapper;

import com.xidian.pojo.Experiment;
import com.xidian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ExperimentMapperTest {
    @Test
    public void addExperiment(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ExperimentMapper mapper = sqlSession.getMapper(ExperimentMapper.class);
        mapper.addExperiment(new Experiment(15054039,1505403901,
                "电子线路实验","验证性",1,3,8));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteExperiment(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ExperimentMapper mapper = sqlSession.getMapper(ExperimentMapper.class);
        mapper.deleteExperiment(1505403901);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getExperimentList(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ExperimentMapper mapper = sqlSession.getMapper(ExperimentMapper.class);
        List<Experiment> experimentList = mapper.getExperimentList();
        for(Experiment e : experimentList){
            System.out.println(e);
        }
        sqlSession.close();
    }

    @Test
    public void getExperimentById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ExperimentMapper mapper = sqlSession.getMapper(ExperimentMapper.class);
        Experiment experiment = mapper.getExperimentById(1505403801);
        System.out.println(experiment);
        sqlSession.close();
    }
}
