package com.xidian.Mapper;

import com.xidian.pojo.Students;
import com.xidian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class StuPageMapperTest {
    @Test
    public void findPageItems(){
        Integer begin=1,pagesize=2;
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StuPageMapper stuPageMapper=sqlSession.getMapper(StuPageMapper.class);
        Integer i= stuPageMapper.findETotalCount();
        System.out.println(i);
        sqlSession.close();
    }
}
