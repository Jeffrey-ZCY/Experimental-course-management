package com.xidian.utils;

import org.apache.ibatis.io.Resources;//ibatis是mybatis的原名
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


public class GetSqlSession {//需要几个数据库就创建几个实例
    public static SqlSession createSqlSession()
    {
        SqlSessionFactory sqlSessionFactory=null;
        InputStream input=null;
        SqlSession session=null;
        try{
            String resource="mybatis-config.xml";
            input=Resources.getResourceAsStream(resource);
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(input);
            session=sqlSessionFactory.openSession();
            return session;
        }catch(IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        System.out.println(createSqlSession());
    }

}