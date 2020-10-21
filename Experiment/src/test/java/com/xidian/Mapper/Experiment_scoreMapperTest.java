package com.xidian.Mapper;

import com.xidian.pojo.Experiment_score;
import com.xidian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Experiment_scoreMapperTest {

    @Test
    public void addScoreList(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Experiment_scoreMapper mapper = sqlSession.getMapper(Experiment_scoreMapper.class);
        mapper.addScoreList(new Experiment_score("ROM实验","计算机组成原理",11,
                "程咬金","计0312",0));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getExperiment_score(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Experiment_scoreMapper mapper = sqlSession.getMapper(Experiment_scoreMapper.class);
        Experiment_score experiment_score = mapper.getExperiment_score(11);
        System.out.println(experiment_score);
        sqlSession.close();
    }

    @Test
    public void updateScore(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Experiment_scoreMapper mapper = sqlSession.getMapper(Experiment_scoreMapper.class);
        mapper.updateScore(new Experiment_score("ROM实验","计算机组成原理",11,
                "程咬金","计0312",90));
        sqlSession.commit();
        sqlSession.close();
    }
}
