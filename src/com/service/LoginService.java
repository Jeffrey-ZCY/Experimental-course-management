package com.service;

import com.entity.Admin;
import com.entity.Tester;
import com.entity.vo.MessageModel;
import com.mapper.TesterMapper;
import com.util.GetSqlSession;
import com.mapper.AdminMapper;
import com.mapper.StudentMapper;
import com.util.StringUtil;
import org.apache.ibatis.session.SqlSession;

public class LoginService {

    public MessageModel userLogin(String uname, String upwd, String type) {
        MessageModel messageModel = new MessageModel();
        if ("1".equals(type)) {
            //回显数据
            Tester s = new Tester();
            s.setTestername(uname);
            s.setTesterpwd(upwd);
            messageModel.setObject(s);
            //参数非空判断
            if (StringUtil.isEmpty(uname) || StringUtil.isEmpty(upwd)) {
                messageModel.setCode(0);
                messageModel.setMsg("用户密码不能为空");
                return messageModel;
            }
            SqlSession session = GetSqlSession.createSqlSession();
            TesterMapper testerMapper = session.getMapper(TesterMapper.class);
            Tester tester = testerMapper.findByName(uname);//查询uname，返回一个User对象
            //用户对象非空判断
            if (tester == null) {
                messageModel.setCode(0);
                messageModel.setMsg("用户不存在");
                return messageModel;
            }
            //用户密码判断
            if (!upwd.equals(tester.getTesterpwd())) {
                messageModel.setCode(0);
                messageModel.setMsg("密码错误");
                return messageModel;
            }
            messageModel.setObject(tester);
        }
        else if("2".equals(type))
        {
            //回显数据
            Admin t = new Admin();
            t.setAdminname(uname);
            t.setAdminpwd(upwd);
            messageModel.setObject(t);
            //参数非空判断
            if (StringUtil.isEmpty(uname) || StringUtil.isEmpty(upwd)) {
                messageModel.setCode(0);
                messageModel.setMsg("用户密码不能为空");
                return messageModel;
            }
            SqlSession session = GetSqlSession.createSqlSession();
            AdminMapper adminMapper = session.getMapper(AdminMapper.class);
            Admin admin = adminMapper.findByName(uname);//查询uname，返回一个User对象
            //用户对象非空判断
            if (admin == null) {
                messageModel.setCode(0);
                messageModel.setMsg("用户不存在");
                return messageModel;
            }
            //用户密码判断
            if (!upwd.equals(admin.getAdminpwd())) {
                messageModel.setCode(0);
                messageModel.setMsg("密码错误");
                return messageModel;
            }
            messageModel.setObject(admin);
        }
        return messageModel;
    }
}