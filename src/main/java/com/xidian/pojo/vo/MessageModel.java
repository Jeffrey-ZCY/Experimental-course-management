package com.xidian.pojo.vo;

public class MessageModel {
    private Integer code = 1; //状态码（1，成功，0，失败）
    private String msg = "";//提示消息
    private Object object;//回显信息

    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Object getObject() {
        return object;
    }
    public void setObject(Object object) {
        this.object = object;
    }
}
