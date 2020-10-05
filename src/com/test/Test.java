package com.test;


import com.entity.Admin;
import com.entity.PageBean;
import com.entity.Student;
import com.entity.Tester;
import com.entity.vo.MessageModel;
import com.mapper.StuPageMapper;
import com.mapper.StudentMapper;
import com.mapper.TesterMapper;
import com.service.StudentService;
import com.util.GetSqlSession;
import com.util.StringUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Integer pageNo = 1;
        SqlSession session = GetSqlSession.createSqlSession();
        StuPageMapper stuPageMapper = session.getMapper(StuPageMapper.class);
        PageBean<Student> pagebean = new PageBean<Student>();
        pagebean.setPageNo(pageNo);
        Integer pageTotalCount = stuPageMapper.findTotalCount();
        pagebean.setPageTotalCount(pageTotalCount);
        Integer pageTotal = pageTotalCount/pagebean.getPageSize();

        if((pageTotalCount%pagebean.getPageSize()) > 0){
            pageTotal++;
        }
        pagebean.setPageTotal(pageTotal);
        if(pageNo < 1){
            pageNo = 1;
        }
        if(pageNo > pageTotal){
            pageNo = pageTotal;
        }
        pagebean.setPageNo(pageNo);
        int begin=(pagebean.getPageNo()-1)*pagebean.getPageSize();
        List<Student> list = stuPageMapper.findPageItems(begin,pagebean.getPageSize());
        pagebean.setList(list);;
    }
}
