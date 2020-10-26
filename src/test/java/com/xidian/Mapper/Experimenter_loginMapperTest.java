package com.xidian.Mapper;

import com.xidian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Experimenter_loginMapperTest {

    @Test
    public void getPwdById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Experimenter_loginMapper mapper = sqlSession.getMapper(Experimenter_loginMapper.class);
        String pwd = mapper.getPwdById(1);
        System.out.println(pwd);
        sqlSession.close();
    }
}
