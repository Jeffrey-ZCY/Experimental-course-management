package com.xidian.Mapper;

import com.xidian.pojo.Laboratory;
import com.xidian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class LaboratoryMapperTest {
    @Test
    public void addLaboratory(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        LaboratoryMapper mapper = sqlSession.getMapper(LaboratoryMapper.class);
        mapper.addLaboratory(new Laboratory(312,60));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteLaboratory(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        LaboratoryMapper mapper = sqlSession.getMapper(LaboratoryMapper.class);
        mapper.deleteLaboratory(312);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getLaboratoryList(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        LaboratoryMapper mapper = sqlSession.getMapper(LaboratoryMapper.class);
        List<Laboratory> laboratoryList = mapper.getLaboratoryList();
        for(Laboratory l:laboratoryList){
            System.out.println(l);
        }
        sqlSession.close();
    }

    @Test
    public void getLaboratoryByRoom(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        LaboratoryMapper mapper = sqlSession.getMapper(LaboratoryMapper.class);
        Laboratory laboratory = mapper.getLaboratoryByRoom(310);
        System.out.println(laboratory);
        sqlSession.close();
    }
}
