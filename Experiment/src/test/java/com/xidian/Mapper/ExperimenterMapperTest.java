package com.xidian.Mapper;

import com.xidian.pojo.Experimenter;
import com.xidian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ExperimenterMapperTest {
    @Test
    public void addExperimenter(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ExperimenterMapper mapper = sqlSession.getMapper(ExperimenterMapper.class);
        mapper.addExperimenter(new Experimenter(5,"李老师"));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteExperimenter(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ExperimenterMapper mapper = sqlSession.getMapper(ExperimenterMapper.class);
        mapper.deleteExperimenter(5);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getExperimenterList(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ExperimenterMapper mapper = sqlSession.getMapper(ExperimenterMapper.class);
        List<Experimenter> experimenterList = mapper.getExperimenterList();
        for(Experimenter e : experimenterList){
            System.out.println(e);
        }
        sqlSession.close();
    }

    @Test
    public void getExperimenterById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ExperimenterMapper mapper = sqlSession.getMapper(ExperimenterMapper.class);
        Experimenter experimenter = mapper.getExperimenterById(2);
        System.out.println(experimenter);
        sqlSession.close();
    }
}
