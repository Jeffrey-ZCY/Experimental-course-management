package com.xidian.service;

import com.xidian.Mapper.Administrators_loginMapper;
import com.xidian.Mapper.Experimenter_loginMapper;
import com.xidian.pojo.Administrators_login;
import com.xidian.pojo.Experimenter_login;
import com.xidian.pojo.vo.MessageModel;
import com.xidian.utils.GetSqlSession;
import com.xidian.utils.StringUtil;

import org.apache.ibatis.session.SqlSession;

public class LoginService {

    public MessageModel userLogin(int uid, String upwd, String type) {
        MessageModel messageModel = new MessageModel();
        if ("1".equals(type)) {
            //回显数据
            Experimenter_login s = new Experimenter_login();
            s.setId(uid);
            s.setPwd(upwd);
            messageModel.setObject(s);
            //参数非空判断
            if (StringUtil.IntisEmpty(uid) || StringUtil.isEmpty(upwd)) {
                messageModel.setCode(0);
                messageModel.setMsg("用户密码不能为空");
                return messageModel;
            }
            SqlSession session = GetSqlSession.createSqlSession();
            Experimenter_loginMapper experimenter_loginMapper = session.getMapper(Experimenter_loginMapper.class);
            Experimenter_login experimenter_login=new Experimenter_login();
            experimenter_login.setId(uid);
            experimenter_login.setPwd(experimenter_loginMapper.getPwdById(uid));
            //用户对象非空判断
            if (experimenter_login == null) {
                messageModel.setCode(0);
                messageModel.setMsg("用户不存在");
                return messageModel;
            }
            //用户密码判断
            if (!upwd.equals(experimenter_login.getPwd())) {
                messageModel.setCode(0);
                messageModel.setMsg("密码错误");
                return messageModel;
            }
            messageModel.setObject(experimenter_login);
        }
        else if("2".equals(type))
        {
            //回显数据
            Administrators_login t = new Administrators_login();
            t.setId(uid);
            t.setPwd(upwd);
            messageModel.setObject(t);
            //参数非空判断
            if (StringUtil.IntisEmpty(uid) || StringUtil.isEmpty(upwd)) {
                messageModel.setCode(0);
                messageModel.setMsg("用户密码不能为空");
                return messageModel;
            }
            SqlSession session = GetSqlSession.createSqlSession();
            Administrators_loginMapper administrators_loginMapper = session.getMapper(Administrators_loginMapper.class);
            Administrators_login administrators_login = new Administrators_login();
            administrators_login.setId(uid);
            administrators_login.setPwd(administrators_loginMapper.getPwdById(uid));
            //用户对象非空判断
            if (administrators_login == null) {
                messageModel.setCode(0);
                messageModel.setMsg("用户不存在");
                return messageModel;
            }
            //用户密码判断
            if (!upwd.equals(administrators_login.getPwd())) {
                messageModel.setCode(0);
                messageModel.setMsg("密码错误");
                return messageModel;
            }
            messageModel.setObject(administrators_login);
        }
        return messageModel;
    }
}