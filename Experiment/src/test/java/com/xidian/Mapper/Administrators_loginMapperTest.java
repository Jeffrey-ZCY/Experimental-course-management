package com.xidian.Mapper;

import com.xidian.Mapper.Administrators_loginMapper;
import com.xidian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Administrators_loginMapperTest {
    @Test
    public void getPwdById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Administrators_loginMapper mapper = sqlSession.getMapper(Administrators_loginMapper.class);
        String pwd = mapper.getPwdById(1000);
        System.out.println(pwd);
        sqlSession.close();
    }
}